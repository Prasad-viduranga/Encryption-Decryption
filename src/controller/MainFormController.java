package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public TextField txtText;
    public TextField txtKey;
    public Button btnEncrypt;
    public AnchorPane contextOfMainForm;
    public Button btnEncryptForm;
    public Button btnDecryptForm;
    public TextField txtCipherText;


    // when click on the "Decrypt Form" button, it is launch "Decryption form" in previous context of window.
    public void btnDecryptFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextOfMainForm.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SecondForm.fxml"))));
    }

    // when click on the "Decrypt Form" button, it is check text and key fields are empty or not
    // if it is not empty then pop up the encrypted text in cipher text field.
    //In Encryption process, text take to reverse, next add the ascii valuve of "z" for each of letter's ascii and numerical key value,
    //That summation of ascii convert to the new character.
    //Get a new String by new characters build as cipher text.
    public void btnEncryptOnAction(ActionEvent actionEvent) {
        String text = txtText.getText();
        String key = txtKey.getText();
        String textEncoded = "";
        int i = 0;

        if (text.trim().isEmpty() && key.trim().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Check whether your text field or key field is empty", ButtonType.CANCEL).show();

        } else {
            try {
                int keyInt = Integer.parseInt(key);
                for (char s1 : text.toCharArray()
                ) {
                    textEncoded = (char) ((int) s1 + (int) ('z')) + textEncoded;
                }

                String keyEncoded = "";
                int j = 0;

                for (char keys : key.toCharArray()
                ) {
                    j = (int) keys + (int) ('z');
                    //System.out.println((char)j);
                    keyEncoded = (char) j + keyEncoded;
                }

                String finalString = keyEncoded + textEncoded;

                txtCipherText.setText(finalString);
            }catch (Exception e){
                new Alert(Alert.AlertType.WARNING, "Please enter numerical input for the key ", ButtonType.CANCEL).show();
            }



        }
    }
}
