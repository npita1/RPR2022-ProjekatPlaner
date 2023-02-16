package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class SubjectTaskTabController {

    public TableView subjectsTableView;
    public TableColumn acronymTableColumn;
    public TableColumn subjectTableColumn;


    private MainController main;
    private final UserManager userManager = new UserManager();
    private final SubjectManager subjectManager = new SubjectManager();


    public void injectMainController(MainController mainController) {
        this.main = mainController;
    }
    @FXML
    public void initialize() throws PlanerException {
        //System.out.println("tasskkkk");
        if(main != null) {
            //System.out.println(main);
            //System.out.println("EVO ME U SUBJECT KONTROLER  " + main.getUsername());

            User user = userManager.getUserByUsername(main.getUsername());

            ObservableList<Subject> userSubjects = FXCollections.observableArrayList(subjectManager.getSubjectsFromUser(main.getUsername()));

            subjectTableColumn.setCellFactory(new PropertyValueFactory<Subject,String>("Subject"));
            acronymTableColumn.setCellFactory(new PropertyValueFactory<Subject,String>("Acronym"));

            subjectsTableView.setItems(userSubjects);

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
