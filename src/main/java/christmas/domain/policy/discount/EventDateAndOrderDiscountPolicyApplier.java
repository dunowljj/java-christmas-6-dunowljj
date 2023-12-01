package christmas.domain.policy.discount;

import christmas.domain.benefit.Discount;
import christmas.domain.order.Orders;
import christmas.domain.policy.EventPolicyManager;
import christmas.domain.policy.discount.date.EventDateAndOrderDiscountPolicy;

import java.time.LocalDate;
import java.util.List;

public class EventDateAndOrderDiscountPolicyApplier extends EventPolicyManager<EventDateAndOrderDiscountPolicy> {

    public EventDateAndOrderDiscountPolicyApplier(List<EventDateAndOrderDiscountPolicy> eventPolicies) {
        super(eventPolicies);
    }

    public List<Discount> applyAll(Orders orders, LocalDate nowDate) {
        return eventPolicies.stream()
                .map((policy) -> policy.calculateDiscount(orders, nowDate))
                .filter((discount -> discount.isApplied()))
                .toList();
    }
}
