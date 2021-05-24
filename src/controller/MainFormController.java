package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public void initialize() {


    }

    public void btnDecryptFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextOfMainForm.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SecondForm.fxml"))));
    }

    public void btnEncryptOnAction(ActionEvent actionEvent) {
        String text = txtText.getText();
        String key = txtKey.getText();
        String sEncoded = "";
        int i = 0;
        for (char s1 : text.toCharArray()
        ) {
            char c= key.toCharArray()[i];
            //System.out.println(s1);
            sEncoded = s1 + sEncoded+ c;
             if (i<key.toCharArray().length){
                 i++;
             }

        }

        System.out.println(text);
        System.out.println(sEncoded);
        //txt
    }
}
