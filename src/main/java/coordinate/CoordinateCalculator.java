package coordinate;

import coordinate.domain.Points;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateCalculator {

    public static void main(String[] args) {
        Points points = InputView.requestPoints();
        OutputView.printMap(points);
    }
}
