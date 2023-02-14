package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController {

    private final UserManager userManager = new UserManager();

    public Button signupMain;
    public TextField usernameField;
    public Label usernameWarning;
    public PasswordField passwordField;
    public Label passwordWarning;
    public Button loginButton;
    private Stage stage;
    private Scene scene;


    @FXML
    public void initialize() {
        usernameField.setOnMouseClicked((e)-> {
            if(!usernameWarning.textProperty().getValue().equals("")) {
                passwordWarning.textProperty().setValue("");
                usernameWarning.textProperty().setValue("");
            }
        });
        passwordField.setOnMouseClicked((e) -> {
            if(!passwordWarning.textProperty().getValue().equals("")) {
                passwordWarning.textProperty().setValue("");
            }
        });
    }

    public void switchToSignup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, stage.getScene().getWidth(),stage.getScene().getHeight());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMain (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, stage.getScene().getWidth(),stage.getScene().getHeight());
        stage.setScene(scene);
        stage.show();
    }

    public void validate(ActionEvent event) throws IOException, PlanerException {
        if(userManager.validateUsername(usernameField.getText())) {
            if(userManager.validatePassword(usernameField.getText(), passwordField.getText())) {
                if(!passwordWarning.getText().equals("") || !usernameWarning.getText().equals("")) {
                    passwordWarning.textProperty().setValue("");
                    usernameWarning.textProperty().setValue("");
                }
                switchToMain(event);
            } else {
                passwordField.textProperty().setValue("");
                passwordWarning.requestFocus();
                passwordWarning.textProperty().setValue("Incorrect password.");
            }
        } else {
            passwordField.textProperty().setValue("");
            usernameField.textProperty().setValue("");
            usernameField.requestFocus();
            usernameWarning.textProperty().setValue("Incorrect username.");
        }
    }

}
