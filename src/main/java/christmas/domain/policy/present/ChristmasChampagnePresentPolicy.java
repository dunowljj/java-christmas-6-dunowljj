package christmas.domain.policy.present;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Present;
import christmas.domain.benefit.Presents;

import static christmas.domain.order.Menu23_12.CHAMPAGNE;

public class ChristmasChampagnePresentPolicy implements EventTotalAmountPresentPolicy {

    private static final long PRESENT_THRESHOLD_PRICE = 120_000;

    @Override
    public Presents findPresents(TotalOrderAmount totalOrderAmount) {
        Presents presents = new Presents();

        if (totalOrderAmount.isMoreThan(PRESENT_THRESHOLD_PRICE)) {
            presents.add(new Present(CHAMPAGNE, 1));
        }

        return presents;
    }
}
