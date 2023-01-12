package coordinate;

import coordinate.domain.Point;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateCalculator {

    public static void main(String[] args) {
        List<Point> points = InputView.requestPoints();
        OutputView.printMap(points);
    }
}
