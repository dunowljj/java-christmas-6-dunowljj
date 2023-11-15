package christmas.domain.policy.badge;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Badges;

public class ChristmasEventBadgePolicy implements EventBadgePolicy<TotalOrderAmount, Badges> {

    @Override
    public Badges findBadges(TotalOrderAmount totalOrderAmount) {
        return null;
    }
}
