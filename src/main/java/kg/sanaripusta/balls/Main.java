package kg.sanaripusta.balls;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("hello-view.fxml"));
//        String cssPath = Objects.requireNonNull(this.getClass().getResource("hello-view.fxml")).toExternalForm();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Balls");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}