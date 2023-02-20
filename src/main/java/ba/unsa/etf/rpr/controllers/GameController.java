package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GameController {


    public GridPane buttonGrid;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public Button startButton;
    public Label winnerLabel;


    private ArrayList<Button> playerClicked;
    private ArrayList<Button> AIClicked;
    private final ArrayList<String> randomTurnArray = new ArrayList<String>(Arrays.asList("Player","AI"));
    private String nowTurn;
    private ArrayList<Button> enabledButtons;



    @FXML
    public void initialize() {
        enabledButtons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7, button8,button9));
    }


    public void startGame(ActionEvent actionEvent) {

        int randomFirst = ThreadLocalRandom.current().nextInt(0,2);
        nowTurn = randomTurnArray.get(randomFirst);
        System.out.println(nowTurn);
        if(nowTurn.equals("AI")) {
            int random =  ThreadLocalRandom.current().nextInt(0,enabledButtons.size() + 1);

        }
        //startButton.setDisable(true);
    }


    public void button1Clicked(ActionEvent actionEvent) {
    }

    public void button2Clicked(ActionEvent actionEvent) {
    }

    public void button3Clicked(ActionEvent actionEvent) {
    }

    public void button4Clicked(ActionEvent actionEvent) {
    }

    public void button5Clicked(ActionEvent actionEvent) {
    }

    public void button6Clicked(ActionEvent actionEvent) {
    }

    public void button7Clicked(ActionEvent actionEvent) {
    }

    public void button8Clicked(ActionEvent actionEvent) {
    }

    public void button9Clicked(ActionEvent actionEvent) {
    }

}



