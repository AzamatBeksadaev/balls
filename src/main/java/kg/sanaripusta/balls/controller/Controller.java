package kg.sanaripusta.balls.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import kg.sanaripusta.balls.constant.ApplicationProperties;
import kg.sanaripusta.balls.service.CircleService;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Pane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CircleService circleService = new CircleService();
        ApplicationProperties properties = ApplicationProperties.getInstance();
        Circle[] circles = circleService.createCircles(properties.getBallsCount());
        circleService.launchBalls(circles, mainPane, properties.getDurationMillis());
    }
}