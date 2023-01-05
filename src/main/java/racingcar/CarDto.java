package racingcar;

public class CarDto {
    private final String name;
    private final int moveCount;

    public CarDto(Car car) {
        this.name = car.getName();
        this.moveCount = car.getMoveCount();
    }

    private String moveBar(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<moveCount;i++){
            sb.append('-');
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + moveBar();
    }
}
