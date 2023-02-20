package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.ParseException;

/**
 * Controller for managing the game tab
 *
 * @author Naida Pita
 */
public class GameTabController {

    // Database managers
    private final UserManager userManager = new UserManager();


    // FX COMPONENTS
    public Label warningLabel;
    public Button playButton;

    // Controllers for injection
    private MainController mainController;

    // Fetched and needed data
    private User user;

    
    @FXML
    public void initialize() throws PlanerException {
        warningLabel.setVisible(false);
        if(mainController != null) {
            user = userManager.getUserByUsername(mainController.getUsername());
        }
    }

    public void playGame(ActionEvent actionEvent) throws PlanerException, ParseException, IOException {
        if(user != null) {
            if(user.getTokens() >= 20) {
                user.setTokens(user.getTokens() - 20);
                userManager.update(user);
                mainController.initialize();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                scene.getRoot().requestFocus();
                Stage stage = new Stage();
                stage.setTitle("Tic Tac Toe");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            } else {
                if(!warningLabel.isVisible()) {
                    warningLabel.setVisible(true);
                    PauseTransition pause = new PauseTransition(Duration.seconds(3));
                    pause.setOnFinished(e -> warningLabel.setVisible(false));
                    pause.play();
                }
            }
        }

    }



    // Controller injections
    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
