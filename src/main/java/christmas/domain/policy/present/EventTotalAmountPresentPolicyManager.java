package christmas.domain.policy.present;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Presents;
import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventTotalAmountPresentPolicyManager extends EventPolicyManager<EventTotalAmountPresentPolicy> {

    public EventTotalAmountPresentPolicyManager(List<EventTotalAmountPresentPolicy> eventPolicies) {
        super(eventPolicies);
    }

    public Presents applyAll(TotalOrderAmount totalOrderAmount) {
        return new Presents(
                eventPolicies.stream()
                .flatMap((policy) -> policy.findPresents(totalOrderAmount).stream())
                .toList()
        );
    }
}
