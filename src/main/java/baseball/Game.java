package baseball;

public class Game {

    private View view = new View();

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        String number = generateNumber();
        System.out.println("generated number = " + number);

        while(true){
            String input = view.inputNumber();
            Judgment judgment = judge(input, number);
            view.printResult(judgment);
            if(judgment.isCompleted()){
                view.printComplete();
                int continueOrExit = view.askContinueOrExit();
                if(continueOrExit == 2)
                    break;
            }
        }
    }

    private String generateNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(createRandomInt(1, 9));
        }
        return sb.toString();
    }

    private int createRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private Judgment judge(String input, String answer) {
        Judgment judgment = new Judgment(answer);

        for(int i=0;i<3;i++){
            judgment.pitch(i, input.charAt(i));
        }
        return judgment;
    }
}
