package blackjack.dto;

public class Report {
    private final String name;
    private final int profit;

    public Report(String name, int profit) {
        this.name = name;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + profit;
    }
}
