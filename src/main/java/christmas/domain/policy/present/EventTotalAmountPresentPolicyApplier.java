package christmas.domain.policy.present;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Presents;
import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventTotalAmountPresentPolicyApplier extends EventPolicyManager<EventTotalAmountPresentPolicy> {

    public EventTotalAmountPresentPolicyApplier(List<EventTotalAmountPresentPolicy> eventPolicies) {
        super(eventPolicies);
    }

    public Presents applyAll(TotalOrderAmount totalOrderAmount) {
        return new Presents(
                eventPolicies.stream()
                        .map((policy) -> policy.findPresents(totalOrderAmount))
                        .filter((presents -> !presents.isEmpty()))
                        .flatMap((presents -> presents.stream()))
                        .toList()
        );
    }

}
