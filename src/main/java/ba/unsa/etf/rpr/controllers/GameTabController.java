package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameTabController {

    // Database managers
    private final UserManager userManager = new UserManager();
    public Label warningLabel;
    public Button playButton;

    private MainController mainController;

    private User user;

    @FXML
    public void initialize() throws PlanerException {
        if(mainController != null) {
            user = userManager.getUserByUsername(mainController.getUsername());
        }
    }

    public void playGame(ActionEvent actionEvent) {


    }




    // Controller injections
    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
