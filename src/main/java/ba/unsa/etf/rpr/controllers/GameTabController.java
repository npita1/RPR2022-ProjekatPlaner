package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.ParseException;

public class GameTabController {

    // Database managers
    private final UserManager userManager = new UserManager();


    public Label warningLabel;
    public Button playButton;

    private MainController mainController;

    private User user;

    @FXML
    public void initialize() throws PlanerException {
        warningLabel.setVisible(false);
        if(mainController != null) {
            user = userManager.getUserByUsername(mainController.getUsername());
        }
    }

    public void playGame(ActionEvent actionEvent) throws PlanerException, ParseException {
        if(user != null) {
            if(user.getTokens() >= 20) {
                user.setTokens(user.getTokens() - 20);
                userManager.update(user);
                mainController.initialize();
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
