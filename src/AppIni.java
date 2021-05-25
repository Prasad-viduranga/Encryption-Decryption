import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppIni extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Deploy the Main Form.fxml file

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/MainForm.fxml"))));

        primaryStage.titleProperty().setValue("Encoder/Decoder ");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}



