package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class AppFX extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getRoot().requestFocus();
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();*/


        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("Mirus planner app");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.setMinHeight(670);
        stage.setMinWidth(980);
        stage.show();
    }

    public static void main( String[] args ) {
        launch(args);
    }

}
