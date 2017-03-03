package com.cypher;

/**
 * Created by adlerd on 3/2/17.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MessageEncrypt extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent scene = FXMLLoader.load(getClass().getResource("MessageEncrypt.fxml"));

        primaryStage.setTitle("Message Encryptors");
        primaryStage.setScene(new Scene(scene, 600, 400));
        primaryStage.show();
    }
}
