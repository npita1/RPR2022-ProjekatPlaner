package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.TaskManager;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;

public class ToDoTabController {

    // Database managers
    private final TaskManager taskManager = new TaskManager();
    private final SubjectManager subjectManager = new SubjectManager();

    // FX Components
    public TableColumn subjectColumn;
    public TableColumn taskColumn;
    public TableColumn doneColumn;
    public ProgressIndicator progressCircle;


    @FXML
    public void initialize() {
        //System.out.println("todotodo");
        //System.out.println(main.getUsername());
    }

}
