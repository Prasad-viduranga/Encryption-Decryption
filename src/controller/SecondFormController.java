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

public class SecondFormController {
    public TextField txtCipherText;
    public TextField txtKey;
    public Button btnDecrypt;
    public AnchorPane contextOfMainForm;
    public AnchorPane contextOfSecondForm;
    public Button btnEncryptForm;
    public Button btnDecrypt1;
    public TextField txtDecrypted;


    public void btnEncryptFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) contextOfSecondForm.getScene().getWindow();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }

    public void btnDecryptOnAction(ActionEvent actionEvent) {

        String inputString = txtCipherText.getText();
        String inputKey = txtKey.getText();


        //System.out.println(inputString.toCharArray().length);
        String decrypted = "";
        for (int i = 0; i < inputString.toCharArray().length; i++) {
            decrypted = decrypted + (char) ((int) inputString.toCharArray()[i] - (int) ('z'));
        }

        String decryptedFinal = "";

        for (char s1 : decrypted.toCharArray()
        ) {
            decryptedFinal = s1 + decryptedFinal;

        }
        String keyFinder = "";
        String decodeText="";
        int l = 0;

        char c[] = decryptedFinal.toCharArray();
        for (int i = c.length - 1; i > -1; i--) {

            if (l < inputKey.length()) {
                keyFinder = c[i] + keyFinder;
                l++;
            }else {
                decodeText = c[i]+decodeText;
            }


        }
        if (keyFinder.equals(inputKey)) {
            txtDecrypted.setText(decodeText);
        }else {
            new Alert(Alert.AlertType.ERROR,"Access Denied", ButtonType.CANCEL).show();
        }


    }
}
