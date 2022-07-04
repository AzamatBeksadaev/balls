package kg.sanaripusta.balls.utilities;

import java.util.Random;

public class NumberUtility {
    public static double getRandomDouble() {
        Random random = new Random();
        return random.nextDouble() / 20;
    }

    public static int getRandomInt(int min, int max) {
        int rand = new Random().nextInt(max);
        return rand >= min ? rand : min + rand;
    }
}
