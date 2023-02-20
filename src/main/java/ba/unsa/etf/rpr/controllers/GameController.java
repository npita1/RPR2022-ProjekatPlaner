package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.sql.SQLSyntaxErrorException;
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
    private String firstOneToPlay;
    private ArrayList<Button> enabledButtons;
    private String playerSign;
    private String AISign;



    @FXML
    public void initialize() {
        enabledButtons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7, button8,button9));
    }


    public void startGame(ActionEvent actionEvent) {

        int randomFirst = ThreadLocalRandom.current().nextInt(0,2);
        nowTurn = randomTurnArray.get(randomFirst);
        firstOneToPlay = nowTurn;

        if(nowTurn.equals("AI")) {
            int randomButton =  ThreadLocalRandom.current().nextInt(0,enabledButtons.size());
            enabledButtons.get(randomButton).setText("X");
            enabledButtons.get(randomButton).setDisable(true);
            enabledButtons.remove(enabledButtons.get(randomButton));
            playerSign = "O";
            AISign = "X";
        } else {
            playerSign = "X";
            AISign = "O";
        }

        startButton.setDisable(true);
    }


    public void button1Clicked(ActionEvent actionEvent) {
        // player O
        if(firstOneToPlay.equals("AI")) {
            nowTurn = "Player";
            button1.setText("O");
            button1.setDisable(true);
            enabledButtons.remove(button1);
        } else {
            button1.setText("X");
            button1.setDisable(true);
            enabledButtons.remove(button1);
        }
    }

    public void button2Clicked(ActionEvent actionEvent) {
        // player O
        if(firstOneToPlay.equals("AI")) {
            nowTurn = "Player";
            button2.setText("O");
            button2.setDisable(true);
            enabledButtons.remove(button2);
        } else {
            button2.setText("X");
            button2.setDisable(true);
            enabledButtons.remove(button2);
        }
    }

    public void button3Clicked(ActionEvent actionEvent) {
        // player O
        if(firstOneToPlay.equals("AI")) {
            nowTurn = "Player";
            button3.setText("O");
            button3.setDisable(true);
            enabledButtons.remove(button3);
        } else {
            button3.setText("X");
            button3.setDisable(true);
            enabledButtons.remove(button3);
        }
    }

    public void button4Clicked(ActionEvent actionEvent) {
        // player O
        if(firstOneToPlay.equals("AI")) {
            nowTurn = "Player";
            button4.setText("O");
            button4.setDisable(true);
            enabledButtons.remove(button4);
        } else {
            button4.setText("X");
            button4.setDisable(true);
            enabledButtons.remove(button4);
        }
    }

    public void button5Clicked(ActionEvent actionEvent) {
        // player O
        if(nowTurn.equals("AI")) {
            nowTurn = "Player";
            button5.setText("O");
            button5.setDisable(true);
            enabledButtons.remove(button5);
        } else {
            button5.setText("X");
            button5.setDisable(true);
            enabledButtons.remove(button5);
        }
    }

    public void button6Clicked(ActionEvent actionEvent) {
        // player O
        if(nowTurn.equals("AI")) {
            nowTurn = "Player";
            button6.setText("O");
            button6.setDisable(true);
            enabledButtons.remove(button6);
        } else {
            button6.setText("X");
            button6.setDisable(true);
            enabledButtons.remove(button6);
        }
    }

    public void button7Clicked(ActionEvent actionEvent) {
        // player O
        if(nowTurn.equals("AI")) {
            nowTurn = "Player";
            button7.setText("O");
            button7.setDisable(true);
            enabledButtons.remove(button7);
        } else {
            button7.setText("X");
            button7.setDisable(true);
            enabledButtons.remove(button7);
        }
    }

    public void button8Clicked(ActionEvent actionEvent) {
        // player O
        if(nowTurn.equals("AI")) {
            nowTurn = "Player";
            button8.setText("O");
            button8.setDisable(true);
            enabledButtons.remove(button8);
        } else {
            button8.setText("X");
            button8.setDisable(true);
            enabledButtons.remove(button8);
        }
    }

    public void button9Clicked(ActionEvent actionEvent) {
        // player O
        if(nowTurn.equals("AI")) {
            nowTurn = "Player";
            button9.setText("O");
            button9.setDisable(true);
            enabledButtons.remove(button9);
        } else {
            button9.setText("X");
            button9.setDisable(true);
            enabledButtons.remove(button9);
        }
    }

    private void AITurn() {
        nowTurn = "AI";
        int randomButton = ThreadLocalRandom.current().nextInt(0,enabledButtons.size());
        if(firstOneToPlay.equals("AI")) {
            enabledButtons.get(randomButton).setText("X");
            enabledButtons.get(randomButton).setDisable(true);
            enabledButtons.remove(enabledButtons.get(randomButton));
        } else {
            enabledButtons.get(randomButton).setText("O");
            enabledButtons.get(randomButton).setDisable(true);
            enabledButtons.remove(enabledButtons.get(randomButton));
        }
        nowTurn = "Player";
    }

}



