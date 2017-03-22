package com.cypher;

/**
 * Created by adlerd on 3/2/17.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MessageEncrypt extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent page = FXMLLoader.load(getClass().getResource("MessageEncrypt.fxml"));
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Encrypt");
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "CRASH!", ex);
        }
    }
}
