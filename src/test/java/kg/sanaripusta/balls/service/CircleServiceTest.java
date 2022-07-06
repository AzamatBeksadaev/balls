package kg.sanaripusta.balls.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CircleServiceTest {
    @InjectMocks
    CircleService circleService = new CircleService();

    @Test
    void countLinesTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int testSize = 7;
        Integer[] actualValues = new Integer[testSize];
        Integer[] expectedValues = new Integer[] {0, 0, 1, 3, 6, 10, 15};

        Method method = CircleService.class.getDeclaredMethod("calcLineCount", Integer.class);
        method.setAccessible(true);
        for (int i = 0; i < testSize; i++)
            actualValues[i] = (Integer) method.invoke(circleService, i);

        assertArrayEquals(expectedValues, actualValues);
    }
}