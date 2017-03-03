package com.cypher;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by adlerd on 3/3/17.
 */
public class MessageEncryptController implements Initializable {
    @FXML
    private Button EncryptButton;
    private TextField PasswordTextField;
    private TextArea UnencryptedInput;
    private TextArea EncryptedOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert EncryptButton != null : "fx:id=\"EncryptButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert PasswordTextField != null : "fx:id=\"PasswordTextField\" was not injected: check your FXML file 'simple.fxml'.";
        assert UnencryptedInput != null : "fx:id=\"UnencryptedInput\" was not injected: check your FXML file 'simple.fxml'.";
        assert EncryptedOutput != null : "fx:id=\"EncryptedOutput\" was not injected: check your FXML file 'simple.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

        EncryptButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Encrypting!");
            }
        });
    }

}
