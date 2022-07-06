package kg.sanaripusta.balls.handler;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

@ExtendWith(MockitoExtension.class)
class LineEventHandlerTest {

    Circle ball0 = new Circle();
    Circle ball1 = new Circle();
    Line line;

    @Test
    void testHypotenuse1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ball0.setLayoutX(3);
        ball0.setLayoutY(4);
        ball1.setLayoutX(6);
        ball1.setLayoutY(2);

        LineEventHandler handler = new LineEventHandler(ball0, ball1, line);

        Method method = LineEventHandler.class.getDeclaredMethod("getHypotenuse");
        method.setAccessible(true);

        Double invoke = (Double) method.invoke(handler);
        BigDecimal actual = new BigDecimal(invoke).setScale(1, RoundingMode.DOWN);
        BigDecimal expected = new BigDecimal(3.6).setScale(1, RoundingMode.DOWN);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHypotenuse2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ball0.setLayoutX(6);
        ball0.setLayoutY(8);
        ball1.setLayoutX(3);
        ball1.setLayoutY(10);

        LineEventHandler handler = new LineEventHandler(ball0, ball1, line);

        Method method = LineEventHandler.class.getDeclaredMethod("getHypotenuse");
        method.setAccessible(true);

        Double invoke = (Double) method.invoke(handler);
        BigDecimal actual = new BigDecimal(invoke).setScale(1, RoundingMode.DOWN);
        BigDecimal expected = new BigDecimal(3.6).setScale(1, RoundingMode.DOWN);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHypotenuse3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ball0.setLayoutX(2);
        ball0.setLayoutY(13);
        ball1.setLayoutX(7);
        ball1.setLayoutY(19);

        LineEventHandler handler = new LineEventHandler(ball0, ball1, line);

        Method method = LineEventHandler.class.getDeclaredMethod("getHypotenuse");
        method.setAccessible(true);

        Double invoke = (Double) method.invoke(handler);
        BigDecimal actual = new BigDecimal(invoke).setScale(1, RoundingMode.DOWN);
        BigDecimal expected = new BigDecimal("7.8").setScale(1, RoundingMode.DOWN);
        Assertions.assertEquals(expected, actual);
    }
}