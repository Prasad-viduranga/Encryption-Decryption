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
import util.Crypto;

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


    public void btnEncryptOnAction(ActionEvent actionEvent) {
        String text = txtText.getText();
        String key = txtKey.getText();


        txtCipherText.setText(Crypto.encrypt(text,key));
    }
}
