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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.ParseException;

public class ToDoTabController {

    // Database managers
    private final TaskManager taskManager = new TaskManager();
    private final SubjectManager subjectManager = new SubjectManager();
    private final ToDoListManager toDoListManager = new ToDoListManager();
    private final UserManager userManager = new UserManager();

    // FX Components
    public TableColumn subjectColumn;
    public TableColumn taskColumn;
    public ProgressIndicator progressCircle;
    public TableView toDoListTableView;


    // Controllers for injection
    private SubjectTaskTabController subjectTaskTabController;
    private MainController mainController;


    // Data
    private Task selectedTask;
    private String username;
    private Task doneTask;


    @FXML
    public void initialize() throws PlanerException {
        if(subjectTaskTabController != null  && selectedTask!=null) {

            User user = userManager.getUserByUsername(username);

            ObservableList<ToDoList> toDoListItems = FXCollections.observableArrayList(toDoListManager.getAllToDoTasksFromUser(user.getId()) );

            subjectColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectAcronym"));
            taskColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("taskText"));

            toDoListTableView.setItems(toDoListItems);

        }
        if (mainController != null){
            User user = userManager.getUserByUsername(mainController.getUsername());

            ObservableList<ToDoList> toDoListItems = FXCollections.observableArrayList(toDoListManager.getAllToDoTasksFromUser(user.getId()) );

            subjectColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectAcronym"));
            taskColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("taskText"));

            toDoListTableView.setItems(toDoListItems);
        }
    }


    /**
     * task done event handler
     * @param actionEvent
     * @throws PlanerException
     * @throws ParseException
     */
    // done removes from list and database + progress + tokens
    // remove and clear removes from list + nothing
    public void taskDoneAction(ActionEvent actionEvent) throws PlanerException, ParseException {
        Object o = toDoListTableView.getSelectionModel().getSelectedItem();
        if(o instanceof ToDoList) {

            toDoListManager.delete(((ToDoList) o).getId());
            taskManager.delete(((ToDoList) o).getTaskId());
            subjectTaskTabController.initialize();


            if(progressCircle.getProgress() == 1) {
                progressCircle.setProgress(0);
            }
            progressCircle.setProgress(progressCircle.getProgress() + 0.25);
            if(progressCircle.getProgress() <= 0.33) {
                progressCircle.getStyleClass().removeAll("progress-barMedium");
                progressCircle.getStyleClass().removeAll("progress-barHigh");
                progressCircle.getStyleClass().add("progress-barLow");
            } else if(progressCircle.getProgress() >= 0.34 && progressCircle.getProgress() <= 0.66) {
                progressCircle.getStyleClass().removeAll("progress-barLow");
                progressCircle.getStyleClass().removeAll("progress-barHigh");
                progressCircle.getStyleClass().add("progress-barMedium");
            }else {
                progressCircle.getStyleClass().removeAll("progress-barLow");
                progressCircle.getStyleClass().removeAll("progress-barMedium");
                progressCircle.getStyleClass().add("progress-barHigh");
            }

            User user = userManager.getById(((ToDoList) o).getUserId());
            user.setTokens(user.getTokens() + 10);
            userManager.update(user);
            mainController.initialize();
            this.initialize();
            toDoListTableView.refresh();
        }
    }

    public void removeOneTask(ActionEvent actionEvent) throws PlanerException {
        Object o = toDoListTableView.getSelectionModel().getSelectedItem();
        if(o instanceof ToDoList) {
            User user;
            if(mainController != null)
                user = userManager.getUserByUsername(mainController.getUsername());
            else
                user = userManager.getUserByUsername(username);

            ObservableList<ToDoList> toDoListItems = FXCollections.observableArrayList(toDoListManager.getAllToDoTasksFromUser(user.getId()));
            toDoListItems.remove(o);
            toDoListManager.delete(((ToDoList) o).getId());
            toDoListTableView.setItems(toDoListItems);
            toDoListTableView.refresh();
        }
    }

    public void removeAllTasks(ActionEvent actionEvent) throws PlanerException {
        User user;
        if(mainController != null)
            user = userManager.getUserByUsername(mainController.getUsername());
        else
            user = userManager.getUserByUsername(username);

        ObservableList<ToDoList> toDoListItems = FXCollections.observableArrayList(toDoListManager.getAllToDoTasksFromUser(user.getId()));
        for(ToDoList t : toDoListItems) {
            toDoListManager.delete(t.getId());
        }
        toDoListItems.removeAll();
        toDoListTableView.setItems(toDoListItems);
        toDoListTableView.refresh();

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }
    public Task getDoneTask() {
        return doneTask;
    }

    public void setDoneTask(Task doneTask) {
        this.doneTask = doneTask;
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
