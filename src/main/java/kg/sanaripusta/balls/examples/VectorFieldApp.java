package kg.sanaripusta.balls.examples;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VectorFieldApp extends Application {

    double mouseX;
    double mouseY;
    Circle circle;

    List<Arrow> arrowList = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent());
        scene.setOnMouseMoved(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });
        stage.setScene(scene);
        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(700, 500);
        for (int x = 0; x < 700 / 26; x ++) {
            for (int y = 0; y < 500 / 26; y ++) {
                Arrow arrow = new Arrow();
                arrow.setTranslateX(x * 25);
                arrow.setTranslateY(y * 25);
                root.getChildren().add(arrow);
                arrowList.add(arrow);
            }
        }

        circle = new Circle(10, Color.BLACK);
        root.getChildren().add(circle);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        animationTimer.start();
        return root;
    }

    private void onUpdate() {
        circle.setCenterX(mouseX);
        circle.setCenterY(mouseY);

        arrowList.forEach(arrow -> {
            double vx = mouseX - arrow.getTranslateX();
            double vy = mouseY - arrow.getTranslateY();
            double angle = Math.toDegrees(- Math.atan2(vx, vy));
            arrow.setRotate(angle);
        });
    }

    private static class Arrow extends Parent {
        float scale = 1f;

        Arrow() {
            Line lineTop = new Line(15 * scale, 5 * scale, 13.5 * scale, 3.5 * scale);
            Line lineMidle = new Line(0 * scale, 5 * scale, 15 * scale, 5 * scale);
            Line lineBottom = new Line(15 * scale, 5 * scale, 13.5 * scale, 6.5 * scale);
            getChildren().addAll(lineTop, lineMidle, lineBottom);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
