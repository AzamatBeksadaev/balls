package kg.sanaripusta.balls.examples;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class SequentialFadeIn extends Application {

    @Override
    public void start(Stage stage) {
        int width = 600;
        int height = 400;

        Group points = new Group();
        SequentialTransition seq = new SequentialTransition();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            double xCentre = random.nextInt(width);
            double yCentre = random.nextInt(height);

            Circle point = new Circle(xCentre , yCentre, 10, Color.FORESTGREEN);
            point.setOpacity(0.0);

            points.getChildren().add(point);
            FadeTransition fade = new FadeTransition(Duration.seconds(3), point);
            fade.setToValue(1.0);
            seq.getChildren().add(fade);
        }

        stage.setScene(new Scene(points, width, height));
        stage.show();
        seq.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
