package racingcar.util;

public class RandomUtils {
    public static int createRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
