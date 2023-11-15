package christmas.domain.policy;

import java.util.List;

public class EventPolicyManager<T extends EventMarketingPolicy> {

    private final List<T> eventPolicies;

    public EventPolicyManager(List<T> eventPolicies) {
        this.eventPolicies = eventPolicies;
    }

    public void addPolicy(T eventPolicy) {
        eventPolicies.add(eventPolicy);
    }

    public void addAllPolicy(List<T> eventPolicies) {
        this.eventPolicies.addAll(eventPolicies);
    }
}
