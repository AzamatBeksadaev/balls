package kg.sanaripusta.balls.service;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import kg.sanaripusta.balls.handler.BounceEventHandler;
import kg.sanaripusta.balls.handler.LineEventHandler;
import kg.sanaripusta.balls.utilities.NumberUtility;

import java.util.ArrayList;
import java.util.List;

public class CircleService {
    public void launchBalls(Circle[] circles, Pane pane, Duration duration) {
        int circleCount = circles.length;
        double[] xVel = this.getRandomVelocity(circleCount);
        double[] yVel = this.getRandomVelocity(circleCount);

        List<Line> lineList = createLines(circleCount);
        pane.getChildren().addAll(lineList);
        pane.getChildren().addAll(circles);

        List<KeyFrame> frameList = new ArrayList<>(circleCount);

        int n = 0;
        for (int i = 0; i < circleCount; i++, n++) {
            BounceEventHandler handler = new BounceEventHandler(xVel[i], yVel[i], circles[i], pane);
            frameList.add(new KeyFrame(duration, handler));
        }

        int lineNumber = 0;
        for (int i = 0; i < circleCount; i++, n++) {
            for (int j = i + 1; j < circleCount; j++) {
                LineEventHandler lineEventHandler = new LineEventHandler(circles[i], circles[j], lineList.get(lineNumber));
                frameList.add(new KeyFrame(duration, lineEventHandler));
                lineNumber++;
            }
        }
        KeyFrame[] keyFrames1 = frameList.toArray(new KeyFrame[0]);

        Timeline timeline = new Timeline(keyFrames1);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public Circle[] createCircles(int ballsCount) {
        Circle[] balls = new Circle[ballsCount];
        for (int i = 0; i < ballsCount; i++) {
            int radius = this.getRandomBallRadius(10, 30);
            Circle ball = new Circle(radius, Color.WHITESMOKE);
            ball.setStrokeWidth(1);
            ball.setStrokeType(StrokeType.INSIDE);
            ball.setStroke(Color.valueOf("0x0a0a0a"));
            ball.relocate(5, 5);
            balls[i] = ball;
        }
        return balls;
    }

    public List<Line> createLines(int ballsCount) {
        int lineCount = calcLineCount(ballsCount);
        List<Line> lineList = new ArrayList<>(lineCount);
        for (int i = 0; i < lineCount; i++) {
            lineList.add(new Line(5, 5, 5, 5));
        }
        return lineList;
    }

    private Integer calcLineCount(Integer ballsCount) {
        int count = ballsCount - 1;
        return (count * (count + 1)) / 2;
    }

    private double[] getRandomVelocity(int count) {
        double[] velocities = new double[count];
        for (int i = 0; i < count; i++) {
            velocities[i] = NumberUtility.getRandomDouble();
        }
        return velocities;
    }

    private int getRandomBallRadius(int min, int max) {
        return NumberUtility.getRandomInt(min, max);
    }
}
