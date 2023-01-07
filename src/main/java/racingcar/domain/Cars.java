package racingcar.domain;

import racingcar.CarDto;
import racingcar.util.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars getWinners() {
        int maxMoveCount = getMaxMoveCount();
        List<Car> list = cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList());
        return new Cars(list);
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

    public void move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<CarDto> toDto() {
        return cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    public boolean containsByName(String name){
        long count = cars.stream()
                .filter(car -> car.getName().equals(name))
                .count();
        return count > 0;
    }
}
