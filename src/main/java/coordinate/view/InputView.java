package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    private static final String INPUT_REQUEST = "죄표를 입력하세요.";
    private static final String INVALID_INPUT = "잘못된 입력입니다.";


    public static Points requestPoints(){
        System.out.println(INPUT_REQUEST);
        return parseInput(sc.nextLine());
    }

    private static Points parseInput(String input){
        String[] positions = input.split("-");

        List<Point> list = Arrays.stream(positions)
                .map(InputView::toPoint)
                .collect(Collectors.toList());

        return new Points(list.toArray(new Point[0]));
    }

    private static Point toPoint(String str){
        if(!(str.startsWith("(") && str.endsWith(")")))
            throw new IllegalArgumentException(INVALID_INPUT);

        List<Integer> nums = Arrays.stream(str.substring(1, str.length() - 1).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if(nums.size()!=2)
            throw new IllegalArgumentException(INVALID_INPUT);

        return new Point(nums.get(0),nums.get(1));
    }
}
