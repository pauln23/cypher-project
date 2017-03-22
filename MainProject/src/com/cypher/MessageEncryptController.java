package com.cypher;

import com.cypher.encryption.Encrypt;
import com.cypher.encryption.KeyFile;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import static java.lang.System.out;

/**
 * Created on 3/3/17.
 */
public class MessageEncryptController {
    @FXML
    private Button encryptButton;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField saltyField;
    @FXML
    private TextField textInput;
    @FXML
    private TextField encryptedOutput;
    @FXML
    private MenuButton encryptMethod;

    private String salt = "";
    private String password;
    private String input;
    private String output;




    private static String stringEncrypt(String str, String password) throws Exception{
        Encrypt strCrypt = new Encrypt(str);
        KeyFile key = new KeyFile(password, 1);
        return strCrypt.encryptToByteValues(key);
    }

    private static String stringEncrypt(String str, String password, String salt) throws Exception{
        Encrypt strCrypt = new Encrypt(str);
        KeyFile key = new KeyFile(password, 1);
        key.setSalt(salt);
        return strCrypt.encryptToByteValues(key);
    }

    public void encrypt() throws Exception{
        password = passwordField.getText();
        input = textInput.getText();
        salt = saltyField.getText();

        if (!salt.equalsIgnoreCase("")) {
            try {
                output = stringEncrypt(input, password, salt);
                encryptedOutput.setText(output);
                out.println(output);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                output = stringEncrypt(input, password);
                encryptedOutput.setText(output);
                out.println(output);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
