package christmas.domain.policy.discount.date;

import christmas.domain.benefit.Discount;
import christmas.domain.order.Orders;
import christmas.domain.policy.discount.EventDiscountBiPolicy;

import java.time.LocalDate;

public interface EventDateAndOrderDiscountPolicy extends EventDiscountBiPolicy<Orders, LocalDate, Discount> {

    @Override
    Discount calculateDiscount(Orders orders, LocalDate localDate);
}
