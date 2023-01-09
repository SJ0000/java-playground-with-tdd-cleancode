package coordinate.study.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private List<Car> cars;

    public RentCompany() {
        cars = new ArrayList<>();

    }

    public void addCar(Car car){
        cars.add(car);
    }


    public static RentCompany create(){
        return new RentCompany();
    }

    public String generateReport(){
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName() + " : " + (int)car.getChargeQuantity() + "리터" + System.lineSeparator());
        }
        return sb.toString();
    }
}
