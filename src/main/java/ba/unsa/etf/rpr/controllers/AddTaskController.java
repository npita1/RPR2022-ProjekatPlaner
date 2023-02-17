package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.TaskManager;
import ba.unsa.etf.rpr.domain.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddTaskController {

    private final SubjectManager subjectManager = new SubjectManager();
    private final TaskManager taskManager = new TaskManager();

    public Button cancelButton;
    public ComboBox subjectComboBox;
    public TextField taskTextField;
    public DatePicker deadlineDatePicker;
    public Button addTaskButton;

    private SubjectTaskTabController subjectTaskTabController;


    private ObservableList<Subject> insertedSubjects;
    private ObservableList<String> comboBoxSubjectsNames = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        if(subjectTaskTabController != null ) {
            subjectTaskTabController.injectAddTaskController(this);

            for(Subject s : insertedSubjects) {
                comboBoxSubjectsNames.add(s.getName());
            }

            subjectComboBox.setItems(comboBoxSubjectsNames);

        }

    }

    public void addTaskToList(ActionEvent actionEvent) {

    }


    public void closeWindow (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setInsertedSubjects(ObservableList<Subject> insertedSubjects) {
        this.insertedSubjects = insertedSubjects;
    }

    public ObservableList<Subject> getInsertedSubjects () {
        return this.insertedSubjects;
    }


    // Controller injections
    public void injectSubjectTaskController (SubjectTaskTabController subjectTaskTabController) {
        this.subjectTaskTabController = subjectTaskTabController;
    }
    public SubjectTaskTabController getSubjectTaskTabController() {
        return this.subjectTaskTabController;
    }

}
