package coordinate;

public class Point {

    private static final int POINT_MIN = 0;
    private static final int POINT_MAX = 24;

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
        return POINT_MIN <= value && value <= POINT_MAX;
    }
}
