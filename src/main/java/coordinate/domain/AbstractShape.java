package coordinate.domain;

import java.util.List;
import java.util.Set;

public abstract class AbstractShape implements Shape{

    protected List<Point> points;

    public AbstractShape(List<Point> points) {
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    protected boolean contains(int x, int y){
        Point point = new Point(x,y);
        return points.contains(point);
    }
}
