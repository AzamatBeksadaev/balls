package kg.sanaripusta.balls.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BounceEventHandler implements EventHandler<ActionEvent> {
    double dx; //Step on x or velocity
    double dy; //Step on y
    Circle ball;
    Pane pane;

    public BounceEventHandler(double dx, double dy, Circle ball, Pane pane) {
        this.dx = dx;
        this.dy = dy;
        this.ball = ball;
        this.pane = pane;
    }

    @Override
    public void handle(ActionEvent t) {
        //move the ball
        ball.setLayoutX(ball.getLayoutX() + dx);
        ball.setLayoutY(ball.getLayoutY() + dy);

        Bounds bounds = pane.getBoundsInLocal();
        double ballLayoutX = ball.getLayoutX();
        double ballLayoutY = ball.getLayoutY();
        double ballRadius = ball.getRadius();

//        System.out.printf("%.0f|%.0f|%.0f|%.0f\n", ballLayoutX, bounds.getMaxX(),ballLayoutY,bounds.getMaxY());

        if (Double.compare(ballLayoutX, (bounds.getMinX() + ballRadius)) <= 0 ||
                Double.compare(ballLayoutX, (bounds.getMaxX() - ballRadius)) >= 0) {
            dx = -dx;
        }

        if (Double.compare(ballLayoutY, (bounds.getMaxY() - ballRadius)) >= 0 ||
                Double.compare(ballLayoutY, (bounds.getMinY() + ballRadius)) <= 0) {
            dy = -dy;
        }
    }
}
