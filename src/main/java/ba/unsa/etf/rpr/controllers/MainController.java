package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public MenuItem logOutButton;
    private Stage stage;
    private Scene scene;
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage = (Stage)logOutButton.getParentPopup().getOwnerWindow();
        //scene = stage.getScene();
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, stage.getScene().getWidth(),stage.getScene().getHeight());
        stage.setScene(scene);
        stage.show();
    }
}
