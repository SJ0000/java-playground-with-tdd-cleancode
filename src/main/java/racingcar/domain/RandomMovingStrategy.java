package racingcar.domain;

import racingcar.util.RandomUtils;

public class RandomMovingStrategy implements MovingStrategy{

    @Override
    public boolean movable() {
        int randomValue = RandomUtils.createRandomInt(0,9);
        return randomValue >= 4;
    }
}