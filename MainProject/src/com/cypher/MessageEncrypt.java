package com.cypher;

/**
 * Created by adlerd on 3/2/17.
 */

import com.cypher.encryption.Decrypt;
import com.cypher.encryption.Encrypt;
import com.cypher.encryption.KeyFile;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import static java.lang.System.out;


public class MessageEncrypt extends Application {

    @FXML
    private Button buttonDecrypt, buttonEncrypt, buttonLoadDecrypt, buttonLoadEncrypt, buttonSaveDecrypt, buttonSaveEncrypt;
    @FXML
    private TextArea inputDecrypt, inputEncrypt, outputDecrypt, outputEncrypt;
    @FXML
    private TextField saltDecrypt, saltEncrypt;
    @FXML
    private PasswordField passwordDecrypt, passwordEncrypt;
    @FXML
    private SplitMenuButton methodDecrypt, methodEncrypt;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent page = FXMLLoader.load(getClass().getResource("MessageEncrypt.fxml"));
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Encrypt");
        primaryStage.show();
    }

    private static String stringEncrypt(String str, String password) throws Exception{
        Encrypt strCrypt = new Encrypt(str);
        strCrypt.setPadding("NoPadding");
        KeyFile key = new KeyFile(password, 1);
        return strCrypt.encryptToByteValues(key);
    }

    private static String stringEncrypt(String str, String password, String salt) throws Exception{
        Encrypt strCrypt = new Encrypt(str);
        KeyFile key = new KeyFile(password, 1);
        key.setSalt(salt);
        return strCrypt.encryptToByteValues(key);
    }

    private static String stringDecrypt(String str, String password) throws Exception{
        Decrypt strDecrypt = new Decrypt(str);
        strDecrypt.setPadding("NoPadding");
        KeyFile keyDecrypt = new KeyFile(password, 1);
        return strDecrypt.decryptDataToString(keyDecrypt);
    }

    private static String stringDecrypt(String str, String password, String salt) throws Exception{
        Decrypt strDecrypt = new Decrypt(str);
        KeyFile keyDecrypt = new KeyFile(password, 1);
        keyDecrypt.setSalt(salt);
        return strDecrypt.decryptDataToString(keyDecrypt);
    }

    public void encrypt() throws Exception{
        String password = passwordEncrypt.getText();
        String input = inputEncrypt.getText();
        String salt = saltEncrypt.getText();
        String output;

//        out.printf("[DEBUG] Input: %s%n", input);

        if (!input.equalsIgnoreCase("")) {
            if (!salt.equalsIgnoreCase("")) {
                output = stringEncrypt(input, password, salt);
                outputEncrypt.setText(output);
                out.println(output);
            } else {
                output = stringEncrypt(input, password);
                outputEncrypt.setText(output);
                out.println(output);
            }
        }
    }

    public void decrypt() throws Exception{
        String password = passwordDecrypt.getText();
        String input = inputDecrypt.getText();
        String salt = saltDecrypt.getText();
        String output;

//        out.printf("[DEBUG] Input: %s%n", input);

        if (!input.equalsIgnoreCase("")) {
            if (!salt.equalsIgnoreCase("")) {
                    output = stringDecrypt(input, password, salt);
                    outputDecrypt.setText(output);
                } else {
                    output = stringDecrypt(input, password);
                    outputDecrypt.setText(output);
                    out.println(output);
            }
        }
    }

    // WIP Method for picking files
    public void encryptPickFile(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            out.printf("[DEBUG] File selected: %s%n", selectedFile.getName());
        }
        else {
            out.printf("[DEBUG] No file selected%n");
        }

    }
}
