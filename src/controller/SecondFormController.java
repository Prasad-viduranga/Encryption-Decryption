package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.crypto.Crypto;

import java.io.IOException;

public class SecondFormController {
    public TextField txtCipherText;
    public TextField txtKey;
    public Button btnDecrypt;
    public AnchorPane contextOfMainForm;
    public AnchorPane contextOfSecondForm;
    public Button btnEncryptForm;
    public TextField txtDecrypted;

    public void initialize() {
        txtCipherText.focusedProperty();
    }

    //If click on "Encryption" button, then launch the Encryption Window in previous context of window.
    public void btnEncryptFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) contextOfSecondForm.getScene().getWindow();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
        stage1.setResizable(false);
    }

    public void btnDecryptOnAction(ActionEvent actionEvent) {

        String inputString = txtCipherText.getText();
        String inputKey = txtKey.getText();


        txtDecrypted.setText(Crypto.decrypt(inputString,inputKey));

    }
}
