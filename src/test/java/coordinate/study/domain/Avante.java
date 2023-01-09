package coordinate.study.domain;

public class Avante implements Car{

    private int tripDistance;

    public Avante(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return 15;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "Avante";
    }
}
