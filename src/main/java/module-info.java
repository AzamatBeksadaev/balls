module kg.balls.balls {
    requires javafx.controls;
    requires javafx.fxml;


    opens kg.sanaripusta.balls to javafx.fxml;
    exports kg.sanaripusta.balls;
    exports kg.sanaripusta.balls.controller;
    opens kg.sanaripusta.balls.controller to javafx.fxml;
    exports kg.sanaripusta.balls.examples;
    opens kg.sanaripusta.balls.examples to javafx.fxml;
    exports kg.sanaripusta.balls.constant;
    opens kg.sanaripusta.balls.constant to javafx.fxml;
    exports kg.sanaripusta.balls.service;
    opens kg.sanaripusta.balls.service to javafx.fxml;
}