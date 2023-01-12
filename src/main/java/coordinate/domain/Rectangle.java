package coordinate.domain;

import java.util.List;

public class Rectangle extends AbstractShape {

    private static final String INVALID_RECTANGLE = "직사각형이 아닙니다.";

    public Rectangle(List<Point> points) {
        super(points);
        validate(points);
    }

    public int getArea() {
        Point p = points.get(0);
        double width = p.distance(findHorizontal(p));
        double height = p.distance(findVertical(p));
        return (int) (width * height);
    }

    private void validate(List<Point> points) {
        Point p = points.get(0);

        int x2 = findHorizontal(p).getX();
        int y2 = findVertical(p).getY();

        if (!points.contains(new Point(x2, y2)))
            throw new IllegalArgumentException(INVALID_RECTANGLE);
    }

    private Point findHorizontal(Point p) {
        return points.stream().filter(p::isHorizontal)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RECTANGLE));
    }

    private Point findVertical(Point p) {
        return points.stream().filter(p::isVertical)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RECTANGLE));
    }

    @Override
    public String getReport() {
        return "사각형 넓이는 " + getArea();
    }
}
