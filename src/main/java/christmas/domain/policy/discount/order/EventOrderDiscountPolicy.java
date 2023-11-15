package christmas.domain.policy.discount.order;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Benefit;
import christmas.domain.order.Orders;
import christmas.domain.policy.discount.EventDiscountBiPolicy;

public interface EventOrderDiscountPolicy extends EventDiscountBiPolicy<Orders, TotalOrderAmount, Benefit> {

    @Override
    Benefit calculateDiscount(Orders orders, TotalOrderAmount totalOrderAmount);
}
