package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Controller for managing game
 *
 * @author Naida Pita
 */
public class GameController {

    // FX COMPONENTS
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
    public Button restartButton;


    // Needed attributes
    private ArrayList<Button> playerClicked = new ArrayList<>();
    private ArrayList<Button> AIClicked = new ArrayList<>();
    private final ArrayList<String> randomTurnArray = new ArrayList<String>(Arrays.asList("Player","AI"));
    private String nowTurn;
    private String firstOneToPlay;
    private ArrayList<Button> enabledButtons;
    private String playerSign;
    private String AISign;



    @FXML
    public void initialize() {
        restartButton.setVisible(false);
        enabledButtons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7, button8,button9));
    }

    /**
     * game start event handler
     *
     * @param actionEvent
     */
    public void startGame(ActionEvent actionEvent) {

        int randomFirst = ThreadLocalRandom.current().nextInt(0,2);
        nowTurn = randomTurnArray.get(randomFirst);
        firstOneToPlay = nowTurn;

        if(firstOneToPlay.equals("AI")) {
            int randomButton =  ThreadLocalRandom.current().nextInt(0,enabledButtons.size());
            enabledButtons.get(randomButton).setText("X");
            enabledButtons.get(randomButton).setDisable(true);
            AIClicked.add(enabledButtons.get(randomButton));
            enabledButtons.remove(enabledButtons.get(randomButton));
            playerSign = "O";
            AISign = "X";
        } else {
            playerSign = "X";
            AISign = "O";
        }

        startButton.setDisable(true);
    }

    /**
     * button click event handlers
     *
     *
     * @param actionEvent
     */

    public void button1Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button1);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button1.setText("O");
                button1.setDisable(true);
                enabledButtons.remove(button1);
            } else {
                button1.setText("X");
                button1.setDisable(true);
                enabledButtons.remove(button1);
            }
            if (playerSign.equals("X")) {
                button1.setText("X");
                button1.setDisable(true);

                enabledButtons.remove(button1);
            } else {
                button1.setText("O");
                button1.setDisable(true);
                enabledButtons.remove(button1);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }
    }

    public void button2Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button2);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button2.setText("O");
                button2.setDisable(true);
                enabledButtons.remove(button2);
            } else {
                button2.setText("X");
                button2.setDisable(true);
                enabledButtons.remove(button2);
            }
            if (playerSign.equals("X")) {
                button2.setText("X");
                button2.setDisable(true);
                enabledButtons.remove(button2);
            } else {
                button2.setText("O");
                button2.setDisable(true);
                enabledButtons.remove(button2);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }
    }

    public void button3Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button3);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button3.setText("O");
                button3.setDisable(true);
                enabledButtons.remove(button3);
            } else {
                button3.setText("X");
                button3.setDisable(true);
                enabledButtons.remove(button3);
            }
            if (playerSign.equals("X")) {
                button3.setText("X");
                button3.setDisable(true);
                enabledButtons.remove(button3);
            } else {
                button3.setText("O");
                button3.setDisable(true);
                enabledButtons.remove(button3);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }
    }

    public void button4Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button4);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button4.setText("O");
                button4.setDisable(true);
                enabledButtons.remove(button4);
            } else {
                button4.setText("X");
                button4.setDisable(true);
                enabledButtons.remove(button4);
            }
            if (playerSign.equals("X")) {
                button4.setText("X");
                button4.setDisable(true);
                enabledButtons.remove(button4);
            } else {
                button4.setText("O");
                button4.setDisable(true);
                enabledButtons.remove(button4);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }

    }

    public void button5Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button5);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button5.setText("O");
                button5.setDisable(true);
                enabledButtons.remove(button5);
            } else {
                button5.setText("X");
                button5.setDisable(true);
                enabledButtons.remove(button5);
            }
            if (playerSign.equals("X")) {
                button5.setText("X");
                button5.setDisable(true);
                enabledButtons.remove(button5);
            } else {
                button5.setText("O");
                button5.setDisable(true);
                enabledButtons.remove(button5);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }
    }

    public void button6Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button6);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button6.setText("O");
                button6.setDisable(true);
                enabledButtons.remove(button6);
            } else {
                button6.setText("X");
                button6.setDisable(true);
                enabledButtons.remove(button6);
            }
            if (playerSign.equals("X")) {
                button6.setText("X");
                button6.setDisable(true);
                enabledButtons.remove(button6);
            } else {
                button6.setText("O");
                button6.setDisable(true);
                enabledButtons.remove(button6);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }
    }

    public void button7Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button7);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button7.setText("O");
                button7.setDisable(true);
                enabledButtons.remove(button7);
            } else {
                button7.setText("X");
                button7.setDisable(true);
                enabledButtons.remove(button7);
            }
            if (playerSign.equals("X")) {
                button7.setText("X");
                button7.setDisable(true);
                enabledButtons.remove(button7);
            } else {
                button7.setText("O");
                button7.setDisable(true);
                enabledButtons.remove(button7);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }
    }

    public void button8Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button8);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button8.setText("O");
                button8.setDisable(true);
                enabledButtons.remove(button8);
            } else {
                button8.setText("X");
                button8.setDisable(true);
                enabledButtons.remove(button8);
            }
            if (playerSign.equals("X")) {
                button8.setText("X");
                button8.setDisable(true);
                enabledButtons.remove(button8);
            } else {
                button8.setText("O");
                button8.setDisable(true);
                enabledButtons.remove(button8);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }
    }

    public void button9Clicked(ActionEvent actionEvent) {
        if(firstOneToPlay != null) {
            playerClicked.add(button9);
            checkTheWinner();
            if (firstOneToPlay.equals("AI")) {
                nowTurn = "Player";
                button9.setText("O");
                button9.setDisable(true);
                enabledButtons.remove(button9);
            } else {
                button9.setText("X");
                button9.setDisable(true);
                enabledButtons.remove(button9);
            }
            if (playerSign.equals("X")) {
                button9.setText("X");
                button9.setDisable(true);
                enabledButtons.remove(button9);
            } else {
                button9.setText("O");
                button9.setDisable(true);
                enabledButtons.remove(button9);
            }
            if(playerClicked.size() + AIClicked.size() != 9)
                AITurn();
        }
    }

    /**
     * AI in-game turn method
     * defines the AI behaviour
     */
    private void AITurn() {
        nowTurn = "AI";
        int randomButton = ThreadLocalRandom.current().nextInt(0,enabledButtons.size());
        if(AISign.equals("X")) {
            enabledButtons.get(randomButton).setText("X");
            enabledButtons.get(randomButton).setDisable(true);
            AIClicked.add(enabledButtons.get(randomButton));
            checkTheWinner();
            enabledButtons.remove(enabledButtons.get(randomButton));
        } else {
            enabledButtons.get(randomButton).setText("O");
            enabledButtons.get(randomButton).setDisable(true);
            AIClicked.add(enabledButtons.get(randomButton));
            checkTheWinner();
            enabledButtons.remove(enabledButtons.get(randomButton));
        }
    }

    /**
     * winner check method
     * checks if the game stops or who wins
     */
    public void checkTheWinner() {
        ArrayList<Button> c1 = new ArrayList<Button>(Arrays.asList(button1,button2,button3));
        ArrayList<Button> c2 = new ArrayList<Button>(Arrays.asList(button4,button5,button6));
        ArrayList<Button> c3 = new ArrayList<Button>(Arrays.asList(button7,button8,button9));
        ArrayList<Button> c4 = new ArrayList<Button>(Arrays.asList(button1,button4,button7));
        ArrayList<Button> c5 = new ArrayList<Button>(Arrays.asList(button2,button5,button8));
        ArrayList<Button> c6 = new ArrayList<Button>(Arrays.asList(button3,button6,button9));
        ArrayList<Button> c7 = new ArrayList<Button>(Arrays.asList(button1,button5,button9));
        ArrayList<Button> c8 = new ArrayList<Button>(Arrays.asList(button3,button5,button7));

        if(playerClicked.containsAll(c1) || playerClicked.containsAll(c2) || playerClicked.containsAll(c3) || playerClicked.containsAll(c4)){
            winnerLabel.setText("Player wins!");
            for(Button b : enabledButtons)
                b.setDisable(true);
            restartButton.setVisible(true);
        }
        if(playerClicked.containsAll(c5) || playerClicked.containsAll(c6) || playerClicked.containsAll(c7) || playerClicked.containsAll(c8)){
            winnerLabel.setText("Player wins!");
            for(Button b : enabledButtons)
                b.setDisable(true);
            restartButton.setVisible(true);
        }

        if(AIClicked.containsAll(c1) || AIClicked.containsAll(c2) || AIClicked.containsAll(c3) || AIClicked.containsAll(c4)){
            winnerLabel.setText("AI wins!");
            for(Button b : enabledButtons)
                b.setDisable(true);
            restartButton.setVisible(true);
        }
        if(AIClicked.containsAll(c5) || AIClicked.containsAll(c6) || AIClicked.containsAll(c7) || AIClicked.containsAll(c8)){
            winnerLabel.setText("AI wins!");
            for(Button b : enabledButtons)
                b.setDisable(true);
            restartButton.setVisible(true);
        }
        if(playerClicked.size() + AIClicked.size() == 9) {
            winnerLabel.setText("It's a tie!");
            restartButton.setVisible(true);
        }
    }

    /**
     * game reset event handler
     * @param actionEvent
     */

    public void restartGame(ActionEvent actionEvent) {
        enabledButtons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7, button8,button9));
        playerClicked.clear();
        AIClicked.clear();
        for(Button b : enabledButtons) {
            if(b.isDisable())
                b.setDisable(false);
            b.setText("");
        }
        winnerLabel.setText("");
        restartButton.setVisible(false);
        startButton.setDisable(false);
        startGame(actionEvent);
    }

}



