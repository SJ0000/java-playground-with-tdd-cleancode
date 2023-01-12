package coordinate.domain;

import java.util.Objects;

public class Point {

    public static final int LIMIT_MIN = 1;
    public static final int LIMIT_MAX = 24;

    int x;
    int y;

    public Point(int x, int y) {
        validate(x,y);
        this.x = x;
        this.y = y;
    }

    private void validate(int x,int y){
        if(!isInRange(x))
            throw new IllegalArgumentException("입력이 범위에서 벗어났습니다.");
        if(!isInRange(y))
            throw new IllegalArgumentException("입력이 범위에서 벗어났습니다.");
    }

    private boolean isInRange(int value){
        return LIMIT_MIN <= value && value <= LIMIT_MAX;
    }


    public double distance(Point p){
        double xDiff = Math.abs(getX() - p.getX());
        double yDiff = Math.abs(getY() - p.getY());
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVertical(Point p){
        return getX() == p.getX() && getY() != p.getY();
    }

    public boolean isHorizontal(Point p){
        return getX() != p.getX() && getY() == p.getY();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return getX() == point.getX() && getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
