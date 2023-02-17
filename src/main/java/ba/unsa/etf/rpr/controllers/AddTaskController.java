package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddTaskController {

    public Button cancelButton;
    public ComboBox subjectComboBox;
    public TextField taskTextField;
    public DatePicker deadlineDatePicker;
    public Button addTaskButton;

    @FXML
    public void initialize() {

    }

    public void addTaskToList(ActionEvent actionEvent) {

    }


    public void closeWindow (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
