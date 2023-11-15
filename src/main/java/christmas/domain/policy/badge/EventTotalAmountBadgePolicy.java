package christmas.domain.policy.badge;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Presents;

public interface EventTotalAmountBadgePolicy extends EventBadgePolicy<TotalOrderAmount, Presents> {

    @Override
    Presents findBadges(TotalOrderAmount totalOrderAmount);
}
