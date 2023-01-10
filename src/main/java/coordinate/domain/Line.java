package coordinate.domain;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getLength() {
        double xDiff = Math.abs(p1.getX() - p2.getX());
        double yDiff = Math.abs(p1.getY() - p2.getY());
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }
}
