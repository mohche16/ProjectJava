package com.example.tictac;

//importering av javafx och andra libs
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //Buttons för våra rutor
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text winnerText;

    @FXML
    private Text playerOneScoreAmount;

    @FXML
    private Text playerTwoScoreAmount;


    //Variablar som vi kommer använda för att avgöra vinnare förlorare
    private int playerTurn = 0;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    //array till alla knappar
    ArrayList<Button> buttons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //lägga alla knappar i array
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        buttons.forEach(button ->{ //en foreach med lambda expression
            setupButton(button); //kör funktionen setup per knapp
            button.setFocusTraversable(false);
        });

    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
        playerOneScoreAmount.setText(String.valueOf(playerOneScore));
        playerTwoScoreAmount.setText(String.valueOf(playerTwoScore));
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> { //vid knapptryckning körs event nedan
            setPlayerSymbol(button); //applicerar symbol (X/O)
            button.setDisable(true); //disablear knappen
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){ //if-else om det är jämn/ojämna turer
            button.setText("X");
            playerTurn = 1;
        } else{
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) { //implementering av switch cases, för att se horizontell och diagonal vinst
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                winnerText.setText("Spelare 1 har vunnit!");
                playerOneScore++;
            }

            //O winner
            else if (line.equals("OOO")) {
                winnerText.setText("Spelare 2 har vunnit!");
                playerTwoScore++;
            }


        }
    }
}