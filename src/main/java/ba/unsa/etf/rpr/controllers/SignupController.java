package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class SignupController {

    private final UserManager userManager = new UserManager();

    public TextField usernameField;
    public RadioButton maleRadioButton;
    public RadioButton femaleRadioButton;
    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    public Label warningLabel;
    public Button signUpButton;
    public ToggleGroup gender;

    private Stage stage;
    private Scene scene;

    @FXML
    public void initialize() {
        usernameField.textProperty().addListener((obs,o,n) -> {
            try {
                if(o == null) o = "";
                if(n == null) n = "";

                if(userManager.validateNewUsernameExist(n)) {
                    warningLabel.textProperty().setValue("");
                    warningLabel.setText("This username is already taken.");
                }
                else if(userManager.validateNewUsernameLength(n)) {
                    warningLabel.textProperty().setValue("");
                    warningLabel.setText("Username must be between 3 and 20 characters long.");
                } else {
                    warningLabel.textProperty().setValue("");
                }
            } catch (PlanerException e) {
                throw new RuntimeException(e);
            }
        });

        passwordField.textProperty().addListener((obs,o,n) -> {
            if(o == null) o = "";
            if(n == null) n = "";
            try {
                if(userManager.validatePasswordLength(n)) {
                    warningLabel.textProperty().setValue("");
                    warningLabel.setText("Password must be between 6 and 25 characters long.");
                } else {
                    warningLabel.textProperty().setValue("");
                }
            } catch (PlanerException e) {
                throw new RuntimeException(e);
            }
        });

        confirmPasswordField.textProperty().addListener((obs,o,n) -> {
            if(o == null) o = "";
            if(n == null) n = "";
            try {
                if(!userManager.validateConfirmPassword(passwordField.getText(), n)) {
                    warningLabel.textProperty().setValue("");
                    warningLabel.setText("Confirmation password does not match the initial password.");
                } else {
                    warningLabel.textProperty().setValue("");
                }
            } catch (PlanerException e) {
                throw new RuntimeException(e);
            }
        });


    }


    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, stage.getScene().getWidth(),stage.getScene().getHeight());
        stage.setScene(scene);
        stage.show();
    }

    public void signUpAccount(ActionEvent event) throws PlanerException, IOException {
        if(!userManager.validatePasswordLength(passwordField.getText()) && userManager.validateConfirmPassword(passwordField.getText(),confirmPasswordField.getText()) && !userManager.validateNewUsernameExist(usernameField.getText()) && !userManager.validateNewUsernameLength(usernameField.getText())) {
            String gen = "";
            if(maleRadioButton.isSelected()) gen = maleRadioButton.getText();
            else gen = femaleRadioButton.getText();

            User u = new User(usernameField.getText(), passwordField.getText(), gen);

            userManager.add(u);

            Alert succesSignUp = new Alert(Alert.AlertType.CONFIRMATION);

        } else {
            System.out.println("nece");
            System.out.println(passwordField.getText());
            System.out.println(usernameField.getText());
            System.out.println(confirmPasswordField.getText());
        }
    }






}
