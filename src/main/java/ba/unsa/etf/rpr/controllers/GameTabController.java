package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.fxml.FXML;

public class GameTabController {

    // Database managers
    private final UserManager userManager = new UserManager();

    private MainController mainController;

    private User user;

    @FXML
    public void initialize() throws PlanerException {
        if(mainController != null) {
            user = userManager.getUserByUsername(mainController.getUsername());
        }
    }







    // Controller injections
    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
