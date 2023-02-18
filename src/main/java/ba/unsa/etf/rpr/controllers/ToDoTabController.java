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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ToDoTabController {

    // Database managers
    private final TaskManager taskManager = new TaskManager();
    private final SubjectManager subjectManager = new SubjectManager();
    private final ToDoListManager toDoListManager = new ToDoListManager();
    private final UserManager userManager = new UserManager();

    // FX Components
    public TableColumn subjectColumn;
    public TableColumn taskColumn;
    public TableColumn doneColumn;
    public ProgressIndicator progressCircle;
    public TableView toDoListTableView;


    // Controllers for injection
    private SubjectTaskTabController subjectTaskTabController;
    private MainController mainController;

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }

    private Task selectedTask;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;


    @FXML
    public void initialize() throws PlanerException {
        if(subjectTaskTabController != null  && selectedTask!=null) {

            User user = userManager.getUserByUsername(username);
            System.out.println(username);
            System.out.println(user.getId());
            ObservableList<ToDoList> toDoListItems = FXCollections.observableArrayList(toDoListManager.getAllToDoTasksFromUser(user.getId()) );

            // treba dodati checkbox kolonu i povezati sa onim progress barom
            subjectColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectAcronym"));
            taskColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("taskText"));

            toDoListTableView.setItems(toDoListItems);

            /*for(Object i : toDoListItems) {
                if(i instanceof ToDoList) {
                    System.out.println(((ToDoList) i).getTaskText());
                }
            }*/
        }
        if (mainController != null){
            User user = userManager.getUserByUsername(mainController.getUsername());

            ObservableList<ToDoList> toDoListItems = FXCollections.observableArrayList(toDoListManager.getAllToDoTasksFromUser(user.getId()) );

            subjectColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectAcronym"));
            taskColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("taskText"));

            toDoListTableView.setItems(toDoListItems);
        }
    }




    // Injection methods
    public void injectSubjectTaskController (SubjectTaskTabController subjectTaskTabController) {
        this.subjectTaskTabController = subjectTaskTabController;
    }
    public SubjectTaskTabController getSubjectTaskTabController() {
        return this.subjectTaskTabController;
    }
    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }


}
