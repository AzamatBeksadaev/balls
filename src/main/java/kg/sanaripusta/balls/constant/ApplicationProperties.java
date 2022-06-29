package kg.sanaripusta.balls.constant;

import javafx.util.Duration;
import java.util.Objects;

public class ApplicationProperties {
    private static ApplicationProperties properties;
    private final Duration duration = Duration.millis(0.1);
    private final int ballsCount = 5;
    private ApplicationProperties() {}

    public static ApplicationProperties getInstance() {
        if (Objects.isNull(properties))
            properties = new ApplicationProperties();
        return properties;
    }

    /**
     * Duration getter
     */
    public Duration getDurationMillis() {
        return duration;
    }

    public int getBallsCount() {
        return ballsCount;
    }
}
