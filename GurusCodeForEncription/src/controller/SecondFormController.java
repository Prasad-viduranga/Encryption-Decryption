package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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



    public void btnEncryptFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1= (Stage) contextOfSecondForm.getScene().getWindow();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }

    public void btnDecryptOnAction(ActionEvent actionEvent) {
    }
}
