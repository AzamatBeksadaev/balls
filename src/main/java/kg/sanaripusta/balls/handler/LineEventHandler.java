package kg.sanaripusta.balls.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class LineEventHandler implements EventHandler<ActionEvent> {

    Circle ball0, ball1;
    Line line;

    public LineEventHandler(Circle ball0, Circle ball1, Line line) {
        this.ball0 = ball0;
        this.ball1 = ball1;
        this.line = line;
    }

    @Override
    public void handle(ActionEvent event) {

        line.setVisible(Double.compare(getHypotenuse(), 120 + ball0.getRadius() + ball1.getRadius()) < 0);
        line.setStartX(ball0.getLayoutX());
        line.setStartY(ball0.getLayoutY());
        line.setEndX(ball1.getLayoutX());
        line.setEndY(ball1.getLayoutY());
    }

    private Double getHypotenuse() {
        return sqrt(pow(ball0.getLayoutY() - ball1.getLayoutY(), 2) + pow(ball0.getLayoutX() - ball1.getLayoutX(), 2));
    }
}
