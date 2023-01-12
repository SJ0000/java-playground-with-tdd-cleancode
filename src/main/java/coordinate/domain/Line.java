package coordinate.domain;

import java.util.List;

public class Line extends AbstractShape {

    public Line(List<Point> points) {
        super(points);
    }

    public double getDistance(){
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        return p1.distance(p2);
    }

    @Override
    public String getReport(){
        return "두 점 사이 거리는 " + getDistance();
    }
}
