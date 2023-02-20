package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;


/**
 * Controller for managing singup
 *
 * @author Naida Pita
 */
public class SignupController {

    // Database managers
    private final UserManager userManager = new UserManager();

    // FX COMPONENTS
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
    private Parent root;


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

        usernameField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.ENTER)) {
                    passwordField.requestFocus();
                }
            }
        });
        passwordField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.ENTER)) {
                    confirmPasswordField.requestFocus();
                }
            }
        });

    }

    /**
     * sign up event handler
     * @param event
     * @throws PlanerException
     * @throws IOException
     * @throws ParseException
     */
    public void signUpAccount(ActionEvent event) throws PlanerException, IOException, ParseException {
        if(!userManager.validatePasswordLength(passwordField.getText()) && userManager.validateConfirmPassword(passwordField.getText(),confirmPasswordField.getText()) && !userManager.validateNewUsernameExist(usernameField.getText()) && !userManager.validateNewUsernameLength(usernameField.getText())) {
            String gen = "";
            if(maleRadioButton.isSelected()) gen = maleRadioButton.getText();
            else gen = femaleRadioButton.getText();

            User u = new User(usernameField.getText(), passwordField.getText(), gen);

            userManager.add(u);

            switchToMain(event);

        } else {
            if(userManager.validateNewUsernameLength(usernameField.getText())) {
                warningLabel.textProperty().setValue("");
                warningLabel.setText("Username must be between 3 and 20 characters long.");
            } else if (userManager.validateNewUsernameExist(usernameField.getText())) {
                warningLabel.textProperty().setValue("");
                warningLabel.setText("This username is already taken.");
            } else if (userManager.validatePasswordLength(passwordField.getText())) {
                warningLabel.textProperty().setValue("");
                warningLabel.setText("Password must be between 6 and 25 characters long.");
            } else {
                warningLabel.textProperty().setValue("");
                warningLabel.setText("Confirmation password does not match the initial password.");
            }
        }
    }


    public void switchToMain (ActionEvent event) throws IOException, PlanerException, ParseException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        root = loader.load();

        MainController main = loader.getController();
        main.setUsername(usernameField.getText());
        main.initialize();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, stage.getScene().getWidth(),stage.getScene().getHeight());
        stage.setScene(scene);
        stage.show();
    }


    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, stage.getScene().getWidth(),stage.getScene().getHeight());
        stage.setScene(scene);
        stage.show();
    }



}
