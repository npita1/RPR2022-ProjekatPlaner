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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

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

    public void addTaskToList(ActionEvent actionEvent) throws PlanerException, ParseException {
        System.out.println("Ulaz");
            LocalDate currentDate = deadlineDatePicker.getValue();
            ZoneId systemTimeZone = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime = currentDate.atStartOfDay(systemTimeZone);
            Date utilDate = Date.from(zonedDateTime.toInstant());

            if (taskManager.validateEnteredDate(utilDate)) {
                //System.out.println("ok");
                // vidi kakav ti je format kad ukucas datum uneses tas
                // u Main controller imas formatiranje datuma
                if (!subjectComboBox.getSelectionModel().isEmpty()) {
                    if(taskTextField.getText().length() >= 3 || !taskTextField.getText().replaceAll("\\s", "").isEmpty()) { // dodaj i u ostalim dijelovima ove provjere
                        Subject chosenSubject = subjectManager.getSubjectByName((String) subjectComboBox.getValue());

                        taskManager.add(new Task(taskTextField.getText(), utilDate, chosenSubject.getId()));

                        SubjectTaskTabController subtask = this.getSubjectTaskTabController();
                        subtask.injectAddTaskController(this);
                        subtask.getAddedTaskSubject(chosenSubject);
                        subtask.initialize();

                        Stage stage = (Stage) addTaskButton.getScene().getWindow();
                        stage.close();
                    } else
                        System.out.println("duzina uslov");

                } else
                    System.out.println("combo box uslov");

            }else
                System.out.println("datum validnost");

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
