package propfile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gui/view/MainView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
