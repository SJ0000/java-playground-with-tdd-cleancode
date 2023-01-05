package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(String s) {
        return Arrays.stream(s.split(","))
                .map(Car::create)
                .collect(Collectors.toList());
    }
}
