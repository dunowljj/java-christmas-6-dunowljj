package christmas.domain.benefit;

public class Discount {
    private final String name;
    private final long amount;

    public Discount(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s: -%d원", name, amount);
    }
}
