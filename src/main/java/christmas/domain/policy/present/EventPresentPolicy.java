package christmas.domain.policy.present;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Presents;
import christmas.domain.policy.EventMarketingPolicy;

public interface EventPresentPolicy extends EventMarketingPolicy {

    Presents findPresents(TotalOrderAmount totalOrderAmount);
}
