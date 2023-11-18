package christmas.domain.benefit;

import java.util.List;

public class Discounts {
    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
