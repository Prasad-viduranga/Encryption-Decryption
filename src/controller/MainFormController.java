package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class MainFormController {
    public TextField txtText;
    public TextField txtKey;
    public Button btnEncrypt;
    public AnchorPane contextOfMainForm;
    public Button btnEncryptForm;
    public Button btnDecryptForm;
    public TextField txtCipherText;

    public void initialize() {


    }

    public void btnDecryptFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextOfMainForm.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SecondForm.fxml"))));
    }

    public void btnEncryptOnAction(ActionEvent actionEvent) {
        String text = txtText.getText();
        String key = txtKey.getText();
        String textEncoded = "";
        int i = 0;

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
    }
}
