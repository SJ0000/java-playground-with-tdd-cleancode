package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Shape;

import java.util.List;

public class OutputView {

    public static void printMap(Shape shape) {
        printVerticalWithPoints(shape.getPoints());
        printHorizontal();
        System.out.println(shape.getReport());
    }

    private static void printHorizontal() {
        printHorizontalBar();
        printHorizontalNumber();
        System.out.println();
    }

    private static void printHorizontalNumber() {
        System.out.print("   0");
        for (int i = Point.LIMIT_MIN; i <= Point.LIMIT_MAX; i++) {
            if(i%2 == 0){
                System.out.printf("%4d",i);
                continue;
            }
            System.out.print("    ");
        }
    }

    private static void printHorizontalBar() {
        System.out.print("    +");
        for (int i = Point.LIMIT_MIN; i <= Point.LIMIT_MAX; i++) {
            System.out.print("----");
        }
        System.out.println();
    }

    private static void printVerticalWithPoints(List<Point> points) {
        for (int y = Point.LIMIT_MAX; y >= Point.LIMIT_MIN; y--) {
            printYAxis(y);
            printArea(points, y);
            System.out.println();
        }
    }

    private static void printArea(List<Point> points, int y) {
        for(int x=Point.LIMIT_MIN;x<=Point.LIMIT_MAX;x++){
            if(points.contains(new Point(x,y))){
                System.out.print("*   ");
                continue;
            }
            System.out.print("    ");
        }
    }

    private static void printYAxis(int value){
        if (value % 2 == 0) {
            System.out.printf("%4d|", value);
            return;
        }
        System.out.print("    |");
    }
}
