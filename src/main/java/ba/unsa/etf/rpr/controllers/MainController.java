package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainController {

    private final UserManager userManager = new UserManager();

    @FXML
    private SubjectTaskTabController subjectsAndTasksTabController;
    @FXML
    private ToDoTabController toDoTabController;
    @FXML
    private GameTabController gameTabController;

    @FXML
    public GridPane subjectsAndTasksTab;

    public MenuItem logOutButton;
    public Label tokenNumber;
    public Label currentDate;
    private Stage stage;
    private Scene scene;
    private Parent root;


    private String username;

    @FXML
    public void initialize() throws PlanerException, ParseException {
        if(username != null) {

            User currentUser = userManager.getUserByUsername(username);
            tokenNumber.setText(Integer.toString(currentUser.getTokens()));

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEEE, dd.MM.yyyy.");
            currentDate.setText(dateFormat.format(date));


            subjectsAndTasksTabController.injectMainController(this);
            subjectsAndTasksTabController.injectToDoListController(toDoTabController);
            subjectsAndTasksTabController.initialize();

            toDoTabController.injectMainController(this);
            toDoTabController.injectSubjectTaskController(subjectsAndTasksTabController);
            toDoTabController.initialize();

            gameTabController.injectMainController(this);
            gameTabController.initialize();


        }

    }

    public void setUsername (String usernamea) {
        username = usernamea;
    }

    public String getUsername() {
        return username;
    }


    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage = (Stage)logOutButton.getParentPopup().getOwnerWindow();
        scene = new Scene(root, stage.getScene().getWidth(),stage.getScene().getHeight());
        stage.setScene(scene);
        stage.show();
    }


    public void openHelpWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/help.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getRoot().requestFocus();
        Stage stage = new Stage();
        stage.setTitle("Help");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
