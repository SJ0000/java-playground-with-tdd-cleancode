package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static Cars createCars(String s) {
        List<Car> list = Arrays.stream(s.split(","))
                .map(Car::create)
                .collect(Collectors.toList());
        return new Cars(list);
    }
}
