package kg.sanaripusta.balls.examples;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MoveOneEndOfLine extends Application {
    private static double mouseX;
    private static double mouseY;

    private static Line line;

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent(), 500, 500);
        scene.setOnMouseMoved(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });
        stage.setScene(scene);
        stage.show();
    }

    private static Parent createContent () {
        Pane pane = new Pane();
        line = new Line(10, 20, mouseX, mouseY);

        pane.getChildren().add(line);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };

        animationTimer.start();
        return pane;
    }

    private static void onUpdate() {
        line.setEndX(mouseX);
        line.setEndY(mouseY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
