package kg.sanaripusta.balls.service;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import kg.sanaripusta.balls.handler.BounceEventHandler;

import java.util.Random;

public class CircleService {
    public void launchBalls(Circle[] circles, Pane pane, Duration duration) {
        double[] xVel = this.getRandomVelocity(circles.length);
        double[] yVel = this.getRandomVelocity(circles.length);
        KeyFrame [] keyFrames = new KeyFrame[circles.length];
        for (int i = 0; i < circles.length; i++) {
            pane.getChildren().add(circles[i]);
            BounceEventHandler handler = new BounceEventHandler(xVel[i], yVel[i], circles[i], pane);
            keyFrames[i] = new KeyFrame(duration, handler);
        }
        Timeline timeline = new Timeline(keyFrames);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public Circle[] createCircles(int ballsCount) {
        Circle[] balls = new Circle[ballsCount];
        for (int i = 0; i < ballsCount; i++) {
            int radius = this.getRandomBallRadius();
            Circle ball = new Circle(radius, Color.WHITESMOKE);
            ball.setStrokeWidth(1);
            ball.setStrokeType(StrokeType.INSIDE);
            ball.setStroke(Color.valueOf("0x0a0a0a"));
            ball.relocate(5, 5);
            balls[i] = ball;
        }
        return balls;
    }

    private double[] getRandomVelocity(int count) {
        double[] velocities = new double[count];
        for (int i = 0; i < count; i++) {
            velocities[i] = getRandomDouble();
        }
        return velocities;
    }

    private int getRandomBallRadius() {
        return getRandomInt(10, 30);
    }

    private double getRandomDouble() {
        Random random = new Random();
        return random.nextDouble() / 20;
    }

    private int getRandomInt(int min, int max) {
        int rand = new Random().nextInt(max);
        return rand >= min ? rand : min + rand;
    }
}
