package kg.sanaripusta.balls.examples;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBallExample extends Application {

    @Override
    public void start(Stage stage) {

        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
        Circle ball = new Circle(10, Color.CADETBLUE);
        ball.setStrokeWidth(1);
        ball.setStrokeType(StrokeType.INSIDE);
        ball.setStroke(Color.valueOf("0x0a0a0a"));
        ball.relocate(5, 5);

        canvas.getChildren().add(ball);

        stage.setTitle("Animated Ball");
        stage.setScene(scene);
        stage.show();
        Bounds bounds1 = canvas.getBoundsInLocal();
        System.out.printf("MinX = %f\n", bounds1.getMinX());
        System.out.printf("MaxX = %f\n", bounds1.getMaxX());
        System.out.printf("MaxY = %f\n", bounds1.getMaxY());
        System.out.printf("MinY = %f\n", bounds1.getMinY());
        System.out.println(canvas.isResizable());

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(20),
                        new EventHandler<>() {

                            double dx = 4; //Step on x or velocity
                            double dy = 2; //Step on y

                            @Override
                            public void handle(ActionEvent t) {
                                //move the ball
                                ball.setLayoutX(ball.getLayoutX() + dx);
                                ball.setLayoutY(ball.getLayoutY() + dy);

                                Bounds bounds = canvas.getBoundsInLocal();

                                double ballLayoutX = ball.getLayoutX();
                                double ballLayoutY = ball.getLayoutY();
                                double ballRadius = ball.getRadius();
//                                System.out.printf("x = %.0f\n", ballLayoutX);
//                                System.out.printf("y = %.0f\n", ballLayoutY);

                                //If the ball reaches the left or right border make the step negative
                                if (Double.compare(ballLayoutX, (bounds.getMinX() + ballRadius)) <= 0 ||
                                        Double.compare(ballLayoutX, (bounds.getMaxX() - ballRadius)) >= 0) {
                                    dx = -dx;
                                }

                                //If the ball reaches the bottom or top border make the step negative
                                if (Double.compare(ballLayoutY,(bounds.getMaxY() - ballRadius)) >= 0 ||
                                        Double.compare(ballLayoutY, (bounds.getMinY() + ballRadius)) <= 0) {
                                    dy = -dy;
                                }
                            }
                        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}
