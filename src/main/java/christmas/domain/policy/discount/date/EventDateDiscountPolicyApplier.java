package christmas.domain.policy.discount.date;

import christmas.domain.benefit.Discount;
import christmas.domain.policy.EventPolicyManager;

import java.time.LocalDate;
import java.util.List;

public class EventDateDiscountPolicyApplier extends EventPolicyManager<EventDateDiscountPolicy> {

    public EventDateDiscountPolicyApplier(List<EventDateDiscountPolicy> eventPolicies) {
        super(eventPolicies);
    }

    public List<Discount> applyAll(LocalDate nowDate) {
        return eventPolicies.stream()
                .map((policy) -> policy.calculateDiscount(nowDate))
                .filter((discount -> discount.isApplied()))
                .toList();
    }
}