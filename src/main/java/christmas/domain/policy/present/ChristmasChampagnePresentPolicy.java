package christmas.domain.policy.present;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Presents;

public class ChristmasChampagnePresentPolicy implements EventPresentPolicy {

    @Override
    public Presents findPresents(TotalOrderAmount totalOrderAmount) {
        return null;
    }
}
