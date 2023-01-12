package coordinate.domain;

import java.util.List;

public class ShapeFactory {

    public static Shape create(List<Point> points){
        if(points.size() == 2)
            return new Line(points);

        if(points.size() == 4)
            return new Rectangle(points);

        throw new IllegalArgumentException("지원하지 않는 도형입니다.");
    }
}
