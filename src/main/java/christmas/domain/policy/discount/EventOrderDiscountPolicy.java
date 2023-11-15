package christmas.domain.policy.discount;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Benefit;
import christmas.domain.order.Orders;
import christmas.domain.policy.EventMarketingPolicy;

public interface EventOrderDiscountPolicy extends EventMarketingPolicy {

    Benefit calculateBenefits(Orders orders, TotalOrderAmount totalOrderAmount);
}
