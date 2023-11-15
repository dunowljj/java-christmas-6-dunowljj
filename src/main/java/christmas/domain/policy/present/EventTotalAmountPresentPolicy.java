package christmas.domain.policy.present;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Presents;

public interface EventTotalAmountPresentPolicy extends EventPresentPolicy<TotalOrderAmount, Presents> {

    @Override
    Presents findPresents(TotalOrderAmount totalOrderAmount);
}
