package coordinate;

import coordinate.domain.Point;
import coordinate.domain.Shape;
import coordinate.domain.ShapeFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateCalculator {

    public static void main(String[] args) {
        List<Point> points = InputView.requestPoints();
        Shape shape = ShapeFactory.create(points);
        OutputView.printMap(shape);
    }
}
