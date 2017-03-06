package com.cypher;

import com.cypher.encryption.EncryptString;

import com.cypher.encryption.KeyFile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

/**
 * Created by adlerd on 3/3/17.
 */
public class MessageEncryptController implements Initializable {
    @FXML
    private Button encryptButton;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField saltyField;
    @FXML
    private TextArea unencryptedInput;
    @FXML
    private TextArea encryptedOutput;
    @FXML
    private Label outputLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert encryptButton != null : "fx:id=\"encryptButton\" was not injected: check your FXML file 'MessageEncrypt.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'MessageEncrypt.fxml'.";
        assert saltyField != null : "fx:id=\"saltyField\" was not injected: check your FXML file 'MessageEncrypt.fxml'.";
        assert unencryptedInput != null : "fx:id=\"unencryptedInput\" was not injected: check your FXML file 'MessageEncrypt.fxml'.";
        assert encryptedOutput != null : "fx:id=\"encryptedOutput\" was not injected: check your FXML file 'MessageEncrypt.fxml'.";
        assert outputLabel != null : "fx:id=\"outputLabel\" was not injected: check your FXML file 'MessageEncrypt.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

        encryptButton.setOnAction(event -> {
            String salt = "much";
            String password = passwordField.getText();
            String input = unencryptedInput.getParagraphs().toString().replace("[", "").replace("]", "").replace(",", "").replace("\n", "").trim();

            out.println("Encrypting!");

            // Run teh file encryption
            EncryptString cryptStr = new EncryptString(input);
            KeyFile key = new KeyFile(password, 0);

            try {
                outputLabel.setText(cryptStr.encryptToStringAES(key));
            } catch (Exception ex){
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "YOU MESSED UP ENCRYPTING THE STRING!!!", ex);
            }

            // Done
            out.println("Encrypted!");
        });

    }

}
