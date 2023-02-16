package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddSubjectController {

    private final SubjectManager subjectManager = new SubjectManager();
    private final UserManager userManager = new UserManager();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectAcronym() {
        return subjectAcronym;
    }

    public void setSubjectAcronym(String subjectAcronym) {
        this.subjectAcronym = subjectAcronym;
    }

    private String subjectName;
    private String subjectAcronym;
    public Button cancelButton;
    public TextField subjectAcronymField;
    public Button addButton;
    public TextField subjectNameField;

    private SubjectTaskTabController subjectTaskTabController;

    @FXML
    public void initialize() {
        if(username != null) {
            //Alert a = new Alert(Alert.AlertType.NONE, username);
            //a.show();
        }
    }

    public void closeWindow (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void addSubjectToList(ActionEvent actionEvent) throws IOException, PlanerException {
        User user = userManager.getUserByUsername(username);
        if(!subjectManager.hasDuplicateAcronymUser(user.getId(),subjectAcronymField.getText()) && !subjectManager.hasDuplicateSubjectUser(user.getId(),subjectNameField.getText())) {

            subjectManager.add(new Subject(subjectNameField.getText(),subjectAcronymField.getText(),"null",user.getId()));

            subjectName = subjectNameField.getText();
            subjectAcronym = subjectAcronymField.getText();

            //FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/subjectsAndTasksTab.fxml"));
            //loader.load();
            SubjectTaskTabController subtask = this.getSubjectTaskTabController();
            subtask.injectAddSubjectController(this);
            subtask.getInfo(username,subjectName,subjectAcronym);
            subtask.initialize();

            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }

    }

    public void injectSubjectTaskController (SubjectTaskTabController subjectTaskTabController) {
        this.subjectTaskTabController = subjectTaskTabController;
    }
    public SubjectTaskTabController getSubjectTaskTabController() {
        return this.subjectTaskTabController;
    }

}
