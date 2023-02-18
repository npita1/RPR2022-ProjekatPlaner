package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.TaskManager;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class AddTaskController {

    // Database managers
    private final SubjectManager subjectManager = new SubjectManager();
    private final TaskManager taskManager = new TaskManager();


    // FX Components
    public Button cancelButton;
    public ComboBox subjectComboBox;
    public TextField taskTextField;
    public DatePicker deadlineDatePicker;
    public Button addTaskButton;
    public Label taskWarning;
    public Label subjectWarning;
    public Label dateWarning;


    // Controllers for injection
    private SubjectTaskTabController subjectTaskTabController;

    // Observable lists
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
        taskTextField.setOnMouseClicked((e)-> {
            if(!taskWarning.textProperty().getValue().equals("") || !dateWarning.textProperty().getValue().equals("") || !subjectWarning.textProperty().getValue().equals("")) {
                taskWarning.textProperty().setValue("");
                dateWarning.textProperty().setValue("");
                subjectWarning.textProperty().setValue("");
            }
        });
        deadlineDatePicker.setOnMouseClicked((e) -> {
            if(!taskWarning.textProperty().getValue().equals("") || !dateWarning.textProperty().getValue().equals("") || !subjectWarning.textProperty().getValue().equals("")) {
                taskWarning.textProperty().setValue("");
                dateWarning.textProperty().setValue("");
                subjectWarning.textProperty().setValue("");
            }
        });
        subjectComboBox.setOnMouseClicked((e) -> {
            if(!taskWarning.textProperty().getValue().equals("") || !dateWarning.textProperty().getValue().equals("") || !subjectWarning.textProperty().getValue().equals("")) {
                taskWarning.textProperty().setValue("");
                dateWarning.textProperty().setValue("");
                subjectWarning.textProperty().setValue("");
            }
        });

    }

    public void addTaskToList(ActionEvent actionEvent) throws PlanerException, ParseException {
            if(deadlineDatePicker.getValue() != null) {
                LocalDate currentDate = deadlineDatePicker.getValue();
                ZoneId systemTimeZone = ZoneId.systemDefault();
                ZonedDateTime zonedDateTime = currentDate.atStartOfDay(systemTimeZone);
                Date utilDate = Date.from(zonedDateTime.toInstant());

                if (taskManager.validateEnteredDate(utilDate)) {


                    if (!subjectComboBox.getSelectionModel().isEmpty()) {
                        if (taskTextField.getText().length() >= 3 || !taskTextField.getText().replaceAll("\\s", "").isEmpty()) { // dodaj i u ostalim dijelovima ove provjere
                            Subject chosenSubject = subjectManager.getSubjectByName((String) subjectComboBox.getValue());

                            taskManager.add(new Task(taskTextField.getText(), utilDate, chosenSubject.getId()));

                            SubjectTaskTabController subtask = this.getSubjectTaskTabController();
                            subtask.injectAddTaskController(this);
                            subtask.getAddedTaskSubject(chosenSubject);
                            subtask.initialize();

                            Stage stage = (Stage) addTaskButton.getScene().getWindow();
                            stage.close();
                        } else {
                            taskTextField.setText("");
                            taskWarning.setText("Task text must be at least 3 characters long!");
                        }

                    } else {
                        subjectWarning.setText("Subject must be selected.");
                    }

                } else {
                    dateWarning.setText("Deadline cannot be in the past.");
                }
            } else {
                if (!subjectComboBox.getSelectionModel().isEmpty()) {
                    if (taskTextField.getText().length() >= 3 || !taskTextField.getText().replaceAll("\\s", "").isEmpty()) { // dodaj i u ostalim dijelovima ove provjere
                        Subject chosenSubject = subjectManager.getSubjectByName((String) subjectComboBox.getValue());

                        taskManager.add(new Task(taskTextField.getText(), null, chosenSubject.getId()));

                        SubjectTaskTabController subtask = this.getSubjectTaskTabController();
                        subtask.injectAddTaskController(this);
                        subtask.getAddedTaskSubject(chosenSubject);
                        subtask.initialize();

                        Stage stage = (Stage) addTaskButton.getScene().getWindow();
                        stage.close();
                    } else {
                        taskTextField.setText("");
                        taskWarning.setText("Task text must be at least 3 characters long!");
                    }

                } else {
                    subjectWarning.setText("Subject must be selected.");
                }
            }

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
