package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import com.thoughtworks.qdox.model.expression.Add;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class SubjectTaskTabController {

    @FXML public TableView subjectsTableView;
    @FXML public TableColumn<Subject,String> acronymTableColumn;
    @FXML public TableColumn<Subject,String> subjectTableColumn;


    private MainController main;
    private final UserManager userManager = new UserManager();
    private final SubjectManager subjectManager = new SubjectManager();
    private AddSubjectController addSubCon;

    private Parent root;

    public void injectMainController(MainController mainController) {
        this.main = mainController;
    }
    public void injectAddSubjectController(AddSubjectController addSubjectController) {
        this.addSubCon = addSubjectController;
    }

    private String subAddName;
    private String subAddAcronym;
    private String username;

    public void getInfo (String username, String subName, String subAcronym) {
        this.username = username;
        this.subAddName = subName;
        this.subAddAcronym = subAcronym;
    }

    //ObservableList<Subject> userSubjects = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws PlanerException {
        //System.out.println("initialize subtasktab main nije null");
        if(main != null) {
            System.out.println("initialize subtasktab main nije null");
            User user = userManager.getUserByUsername(main.getUsername());

            ObservableList<Subject> userSubjects = FXCollections.observableArrayList(subjectManager.getSubjectsFromUser(user.getId()));

            subjectTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("name"));
            acronymTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("acronym"));

            subjectsTableView.setItems(userSubjects);
            for(Object i : userSubjects) {
                if(i instanceof Subject) {
                    System.out.println(((Subject) i).getName());
                }
            }

        }
        if(addSubCon != null) {
            System.out.println("initialize subtasktab main null");
            User user = userManager.getUserByUsername(username);

            ObservableList<Subject> userSubjects = FXCollections.observableArrayList(subjectManager.getSubjectsFromUser(user.getId()));

            subjectTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("name"));
            acronymTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("acronym"));

            subjectsTableView.setItems(userSubjects);
            subjectsTableView.refresh();

            for(Object i : userSubjects) {
                if(i instanceof Subject) {
                    System.out.println(((Subject) i).getName());
                }
            }
        }
    }


    public void openAddSubject (ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addSubject.fxml"));
        root = loader.load();
        AddSubjectController addSub = loader.getController();
        addSub.injectSubjectTaskController(this);
        addSub.setUsername(main.getUsername());
        //addSub.initialize();

        //FXMLLoader fxmlLoader = new FXMLLoader();
        //fxmlLoader.setLocation(getClass().getResource("/fxml/addSubject.fxml"));
        Scene scene = new Scene(root, 450, 500);
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

    public void refresh(String username, String subName, String subAcronym) throws PlanerException {
        User user = userManager.getUserByUsername(username);

        ObservableList<Subject> userSubjects = FXCollections.observableArrayList(subjectManager.getSubjectsFromUser(user.getId()));

        subjectTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("name"));
        acronymTableColumn.setCellValueFactory(new PropertyValueFactory<Subject,String>("acronym"));
        System.out.println("refresh");
        for(Object i : userSubjects) {
            if(i instanceof Subject) {
                System.out.println(((Subject) i).getName());
            }
        }

    }

}
