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
    }

    private String generateNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(RandomUtils.createRandomInt(1, 9));
        }
        return sb.toString();
    }
}
