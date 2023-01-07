package racingcar.domain;

public class Car {

    private final String name;
    private int moveCount;

    private Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public static Car create(String name){
        if(name.length() > 5){
            throw new RuntimeException("Car name length must less than 6");
        }
        return new Car(name);
    }

    public void move(MovingStrategy movingStrategy){
        if(movingStrategy.movable())
            moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
