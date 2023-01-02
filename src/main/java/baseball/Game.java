package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private View view = new View();

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        List<Integer> generated = generateNumbers();
        System.out.println("generated number = " + generated);
        Balls computer = new Balls(generated);

        while(true){
            Balls user = new Balls(inputToNumbers(view.inputNumber()));
            PlayResult result = computer.play(user);
            view.printResult(result);
            if(result.isCompleted())
                break;
        }

        if(view.askContinue())
            start();
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(RandomUtils.createRandomInt(1, 9));
        }
        return numbers;
    }

    private List<Integer> inputToNumbers(String input){
        return input.chars()
                .mapToObj(ch -> ch - '0')
                .collect(Collectors.toList());
    }
}
