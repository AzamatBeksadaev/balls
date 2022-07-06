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
        double ball0LayoutX = ball0.getLayoutX();
        double ball0LayoutY = ball0.getLayoutY();
        double ball1LayoutX = ball1.getLayoutX();
        double ball1LayoutY = ball1.getLayoutY();
        if (Double.compare(getHypotenuse(), 30) > 0) {
            line.setVisible(false);
        } else {
            line.setVisible(true);
            line.setStartX(ball0LayoutX);
            line.setStartY(ball0LayoutY);
            line.setEndX(ball1LayoutX);
            line.setEndY(ball1LayoutY);
        }
    }

    private Double getHypotenuse() {
        return sqrt(pow(ball0.getLayoutY() - ball1.getLayoutY(), 2) + pow(ball0.getLayoutX() - ball1.getLayoutX(), 2));
    }
}
