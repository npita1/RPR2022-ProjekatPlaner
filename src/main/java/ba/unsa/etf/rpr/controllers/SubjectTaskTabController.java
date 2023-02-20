package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.TaskManager;
import ba.unsa.etf.rpr.business.ToDoListManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.domain.ToDoList;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class SubjectTaskTabController {

    // Database managers
    private final UserManager userManager = new UserManager();
    private final SubjectManager subjectManager = new SubjectManager();
    private final TaskManager taskManager = new TaskManager();
    private final ToDoListManager toDoListManager = new ToDoListManager();

    // FX COMPONENTS
    @FXML public TableView subjectsTableView;
    @FXML public TableColumn<Subject,String> acronymTableColumn;
    @FXML public TableColumn<Subject,String> subjectTableColumn;
    public Button removeSubjectButton;
    public TableView tasksTableView;
    public TableColumn<Task,String> taskTextTableColumn;
    public TableColumn<Task, Date> deadlineTableColumn;
    public Label taskAdddedConfirmation;


    // Controllers for injection
    private MainController main;
    private AddSubjectController addSubCon;
    private AddTaskController addTaskController;
    private ToDoTabController toDoTabController;


    private Parent root;

    // Needed data
    private String subAddName;
    private String subAddAcronym;
    private String username;
    private Subject changedSubjectTask;


    @FXML
    public void initialize() throws PlanerException, ParseException {

        // Initial initialization after login
        if(main != null) {
            taskAdddedConfirmation.setVisible(false);

            User user = userManager.getUserByUsername(main.getUsername());

            ObservableList<Subject> userSubjects = FXCollections.observableArrayList(subjectManager.getSubjectsFromUser(user.getId()));

            subjectTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("name"));
            acronymTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("acronym"));

            subjectsTableView.setItems(userSubjects);

        }

        // Initialization after adding subject
        if(addSubCon != null) {
            taskAdddedConfirmation.setVisible(false);
            User user = userManager.getUserByUsername(username);

            ObservableList<Subject> userSubjects = FXCollections.observableArrayList(subjectManager.getSubjectsFromUser(user.getId()));

            subjectTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("name"));
            acronymTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("acronym"));

            subjectsTableView.setItems(userSubjects);
            subjectsTableView.refresh();

        }

        // Initialization after adding task
        if(addTaskController != null) {
            taskAdddedConfirmation.setVisible(false);
            Object o = subjectsTableView.getSelectionModel().getSelectedItem();
            if(o instanceof Subject) {
                if(changedSubjectTask.getName().equals(((Subject) o).getName())) {
                    ObservableList<Task> taskFromClickedSubject = FXCollections.observableArrayList(taskManager.getTasksWithSubjectID(changedSubjectTask.getId()));

                    // auto-removing tasks with deadlines in past
                    ObservableList<Task> remove = FXCollections.observableArrayList();
                    for(Task t : taskFromClickedSubject) {
                        if(!taskManager.validateEnteredDate(t.getDeadline())) {
                            remove.add(t);
                            taskManager.delete(t.getId());
                        }
                    }
                    taskFromClickedSubject.removeAll(remove);

                    taskTextTableColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskText"));
                    deadlineTableColumn.setCellValueFactory(new PropertyValueFactory<Task, Date>("deadline"));

                    tasksTableView.setItems(taskFromClickedSubject);
                    subjectsTableView.refresh();
                }
            }
        }

    }


    public void openAddSubject (ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addSubject.fxml"));
        root = loader.load();

        AddSubjectController addSub = loader.getController();
        addSub.injectSubjectTaskController(this);
        addSub.setUsername(main.getUsername());

        Scene scene = new Scene(root, 400, 400);
        Stage stage = new Stage();
        stage.setTitle("Add subject");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void openAddTask (ActionEvent actionEvent) throws IOException, PlanerException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addTask.fxml"));
        root = loader.load();

        AddTaskController addTask = loader.getController();
        addTask.injectSubjectTaskController(this);

        User user = userManager.getUserByUsername(main.getUsername());
        ObservableList<Subject> userSubjects = FXCollections.observableArrayList(subjectManager.getSubjectsFromUser(user.getId()));
        addTask.setInsertedSubjects(userSubjects);
        addTask.initialize();

        Scene scene = new Scene(root, 510, 540);
        Stage stage = new Stage();
        stage.setTitle("Add task");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void removeSubjectAction(ActionEvent actionEvent) throws PlanerException, ParseException {
        ObservableList<Subject> allSubjects, oneSubject;
        allSubjects = subjectsTableView.getItems();
        oneSubject = subjectsTableView.getSelectionModel().getSelectedItems();
        Subject sub = oneSubject.get(0);
        oneSubject.forEach(allSubjects::remove);

        ArrayList<ToDoList> removeTODO = toDoListManager.getTasksBySubjectAcronym(sub.getAcronym());
        for(ToDoList t : removeTODO)
            toDoListManager.delete(t.getId());

        ArrayList<Task> removeTasks = taskManager.getTasksWithSubjectID(sub.getId());
        for(Task t : removeTasks)
            taskManager.delete(t.getId());

        subjectManager.delete(sub.getId());
        this.initialize();
        toDoTabController.initialize();
        tasksTableView.refresh();
    }

    public void removeTaskAction (ActionEvent actionEvent) throws PlanerException {
        ObservableList<Task> allTasks, oneTask;
        allTasks = tasksTableView.getItems();
        oneTask = tasksTableView.getSelectionModel().getSelectedItems();
        Task sub = oneTask.get(0);
        oneTask.forEach(allTasks::remove);

        ToDoList toDoTask = toDoListManager.getToDoItemByTaskID(sub.getId());
        toDoListManager.delete(toDoTask.getId());
        taskManager.delete(sub.getId());
    }


    public void clickedItem(MouseEvent mouseEvent) throws PlanerException, ParseException {
        Object o = subjectsTableView.getSelectionModel().getSelectedItem();
        if(o instanceof Subject) {
            //Subject clickedSubject = subjectManager.getSubjectByName(((Subject) o).getName());

            ObservableList<Task> taskFromClickedSubject = FXCollections.observableArrayList(taskManager.getTasksWithSubjectID(((Subject) o).getId()));
            ObservableList<Task> remove =   FXCollections.observableArrayList();
            for(Task t : taskFromClickedSubject) {
                if(!taskManager.validateEnteredDate(t.getDeadline())) {
                    remove.add(t);
                    taskManager.delete(t.getId());
                }
            }
            taskFromClickedSubject.removeAll(remove);

            taskTextTableColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("taskText"));
            deadlineTableColumn.setCellValueFactory(new PropertyValueFactory<Task,Date>("deadline"));

            tasksTableView.setItems(taskFromClickedSubject);
            tasksTableView.refresh();

        }
    }

    public void getAddedTaskSubject (Subject subject) {
        this.changedSubjectTask = subject;
    }

    public void getInfo (String username, String subName, String subAcronym) {
        this.username = username;
        this.subAddName = subName;
        this.subAddAcronym = subAcronym;
    }


    public void sendToTODOList(ActionEvent actionEvent) throws PlanerException {
        if(toDoTabController != null) {

            Object o = tasksTableView.getSelectionModel().getSelectedItem();
            if(o instanceof Task) {
                ArrayList<ToDoList> checkIfExists = toDoListManager.chechIfTaskAlreadyAdded(((Task) o).getId());
                if (checkIfExists.size() == 0) {
                    toDoTabController.setSelectedTask((Task) o);
                    Subject sub = subjectManager.getById(((Task) o).getSubjectId());
                    User user;
                    if (main != null) {
                        user = userManager.getUserByUsername(main.getUsername());
                    } else {
                        user = userManager.getUserByUsername(username);
                    }
                    toDoListManager.add(new ToDoList(user.getId(), ((Task) o).getId(), ((Task) o).getTaskText(), sub.getAcronym()));
                    if (main != null)
                        toDoTabController.setUsername(main.getUsername());
                    else
                        toDoTabController.setUsername(username);

                    toDoTabController.initialize();
                    if(!taskAdddedConfirmation.isVisible()) {
                        taskAdddedConfirmation.setVisible(true);
                        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                        pause.setOnFinished(e -> taskAdddedConfirmation.setVisible(false));
                        pause.play();
                    }
                }
            }

        }

    }

    // Controller injections
    public void injectMainController(MainController mainController) {
        this.main = mainController;
    }
    public void injectAddSubjectController(AddSubjectController addSubjectController) {
        this.addSubCon = addSubjectController;
    }
    public void injectAddTaskController (AddTaskController addTaskController) {
        this.addTaskController = addTaskController;
    }
    public void injectToDoListController (ToDoTabController toDoTabController) {
        this.toDoTabController = toDoTabController;
    }

}
