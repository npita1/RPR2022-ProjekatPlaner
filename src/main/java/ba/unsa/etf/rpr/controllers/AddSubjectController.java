package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddSubjectController {

    private final SubjectManager subjectManager = new SubjectManager();
    private final UserManager userManager = new UserManager();


    private String username;
    private String subjectName;
    private String subjectAcronym;

    @FXML
    public Button cancelButton;
    public TextField subjectAcronymField;
    public Button addButton;
    public TextField subjectNameField;
    public Label warningMessage;

    private SubjectTaskTabController subjectTaskTabController;

    @FXML
    public void initialize() {
        subjectNameField.setOnMouseClicked((e)-> {
            if(!warningMessage.textProperty().getValue().equals("")) {
                warningMessage.textProperty().setValue("");
            }
        });
        subjectAcronymField.setOnMouseClicked((e) -> {
            if(!warningMessage.textProperty().getValue().equals("")) {
                warningMessage.textProperty().setValue("");
            }
        });
    }

    public void closeWindow (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void addSubjectToList(ActionEvent actionEvent) throws IOException, PlanerException {
        User user = userManager.getUserByUsername(username);
        if(!subjectManager.hasDuplicateAcronymUser(user.getId(),subjectAcronymField.getText()) && !subjectManager.hasDuplicateSubjectUser(user.getId(),subjectNameField.getText()) ) {
            if(subjectNameField.getText().length() >= 5 && subjectAcronymField.getText().length()>=2) {
                subjectManager.add(new Subject(subjectNameField.getText(), subjectAcronymField.getText(), "null", user.getId()));

                subjectName = subjectNameField.getText();
                subjectAcronym = subjectAcronymField.getText();

                SubjectTaskTabController subtask = this.getSubjectTaskTabController();
                subtask.injectAddSubjectController(this);

                subtask.getInfo(username, subjectName, subjectAcronym);
                subtask.initialize();

                Stage stage = (Stage) addButton.getScene().getWindow();
                stage.close();
            }else {
                warningMessage.setText("Subject name must be 5 and acronym 2 characters long.");
                subjectNameField.setText("");
                subjectAcronymField.setText("");
            }
        } else {
            subjectAcronymField.setText("");
            subjectNameField.setText("");
            warningMessage.setText("You cannot add an already existing subject name or acronym.");
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    // Controller injections
    public void injectSubjectTaskController (SubjectTaskTabController subjectTaskTabController) {
        this.subjectTaskTabController = subjectTaskTabController;
    }
    public SubjectTaskTabController getSubjectTaskTabController() {
        return this.subjectTaskTabController;
    }

}
