package racingcar;

public class Car {

    private final String name;

    private Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Car create(String name){
        if(name.length() > 5){
            throw new RuntimeException("Car name length must less than 6");
        }
        return new Car(name);
    }
}
