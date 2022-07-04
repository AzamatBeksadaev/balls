package kg.sanaripusta.balls.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

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
        line.setStartX(ball0.getLayoutX());
        line.setStartY(ball0.getLayoutY());
        line.setEndX(ball1.getLayoutX());
        line.setEndY(ball1.getLayoutY());
    }
}
