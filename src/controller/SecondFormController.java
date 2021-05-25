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

    //If click on "Encryption" button, then launch the Encryption Window in previous context of window.
    public void btnEncryptFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) contextOfSecondForm.getScene().getWindow();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }
    //when click on "Decryption" button,it is get both text of cipher and key text fields,
    //and check those are empty or not.if it is empty it give a msg about it.if it is not,it going to decode the cipher as text and key
    //finally check the key is correct with decrypted key.it is correct then decr000ypted text is deploy on text field.
    public void btnDecryptOnAction(ActionEvent actionEvent) {

        String inputString = txtCipherText.getText();
        String inputKey = txtKey.getText();

        try {
            //System.out.println(inputString.toCharArray().length);

            int keyInput=Integer.parseInt(inputKey);

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

        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING, "Please check the key ", ButtonType.CANCEL).show();
        }



    }
}
