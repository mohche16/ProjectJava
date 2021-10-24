package com.example.tictac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        stage.setTitle("Hello welcome to grit Tic Tac Toe!!");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}