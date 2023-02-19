package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import javafx.fxml.FXML;

public class GameTabController {

    // Database managers
    private final UserManager userManager = new UserManager();

    private MainController mainController;

    @FXML
    public void initialize() {
        if(mainController != null) {

        }
    }





    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
