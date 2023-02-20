package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller for managing help window
 *
 * @author Naida Pita
 */
public class HelpController {
    public Button okButton;

    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

}
