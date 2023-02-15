package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SubjectTaskTabController {

    private MainController main;

    public void injectMainController(MainController mainController) {
        this.main = mainController;
    }
    @FXML
    public void initialize() {
        System.out.println("tasskkkk");
        if(main != null) {
            System.out.println(main);
            System.out.println("EVO ME U SUBJECT KONTROLER  " + main.getUsername());
        }
    }


    public void openAddSubject (ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/addSubject.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 510, 540);
        Stage stage = new Stage();
        stage.setTitle("Add subject");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void openAddTask (ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/addTask.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 510, 540);
        Stage stage = new Stage();
        stage.setTitle("Add task");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
