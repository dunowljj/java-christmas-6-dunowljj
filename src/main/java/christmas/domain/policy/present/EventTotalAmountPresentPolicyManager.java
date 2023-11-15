package christmas.domain.policy.present;

import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventTotalAmountPresentPolicyManager extends EventPolicyManager<EventTotalAmountPresentPolicy> {

    public EventTotalAmountPresentPolicyManager(List<EventTotalAmountPresentPolicy> eventPolicies) {
        super(eventPolicies);
    }
}
