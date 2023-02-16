package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainController {

    private final UserManager userManager = new UserManager();

    @FXML
    private SubjectTaskTabController subjectsAndTasksTabController;
    @FXML
    private ToDoTabController toDoTabController;
    @FXML
    public GridPane subjectsAndTasksTab;

    public MenuItem logOutButton;
    public Label tokenNumber;
    public Label currentDate;
    public Tab subjectTaskTab;
    private Stage stage;
    private Scene scene;
    private Parent root;


    private String username;

    @FXML
    public void initialize() throws PlanerException {
        if(username != null) {
            //System.out.println("evo me u initialize maina");
            //System.out.println("Username nije null " + new Date());
            //Alert al = new Alert(Alert.AlertType.CONFIRMATION, username);
            //al.show();

            User currentUser = userManager.getUserByUsername(username);
            tokenNumber.setText(Integer.toString(currentUser.getTokens()));

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEEE, dd.MM.yyyy.");
            currentDate.setText(dateFormat.format(date));


            subjectsAndTasksTabController.injectMainController(this);
            subjectsAndTasksTabController.initialize();

            //System.out.println("EVO ME U MAIN KONTROLER INITIALIZE " + this.getUsername());
        }

        /*if(username != null) {
            System.out.println("Username nije null " + new Date());
            Alert al = new Alert(Alert.AlertType.CONFIRMATION, username);
            al.show();
            User currentUser = userManager.getUserByUsername(username);
            tokenNumber.setText(Integer.toString(currentUser.getTokens()));

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEEE, dd.MM.yyyy.");
            currentDate.setText(dateFormat.format(date));

        }else
            System.out.println("Username je null " + new Date());*/
    }

    /*public void initializeDateAndTokens() throws PlanerException, IOException {
        System.out.println("Username nije null " + new Date());
        Alert al = new Alert(Alert.AlertType.CONFIRMATION, username);
        al.show();
        User currentUser = userManager.getUserByUsername(username);
        tokenNumber.setText(Integer.toString(currentUser.getTokens()));

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEEE, dd.MM.yyyy.");
        currentDate.setText(dateFormat.format(date));

    }*/

    public void setUsername (String usernamea) {
        username = usernamea;
    }

    public String getUsername() {
        return username;
    }


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
