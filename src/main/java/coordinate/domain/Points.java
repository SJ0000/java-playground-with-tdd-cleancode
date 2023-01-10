package coordinate.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Points {

    private Set<Point> points;

    public Points(Point... points) {
        this.points = new HashSet<>();
        this.points.addAll(Arrays.asList(points));
    }

    public boolean contains(int x, int y){
        Point point = new Point(x,y);
        return points.contains(point);
    }
}
