package christmas.domain.policy;

import java.util.ArrayList;
import java.util.List;

public class EventPolicyManager<T extends EventMarketingPolicy> {

    protected List<T> eventPolicies;

    public EventPolicyManager(List<T> eventPolicies) {
        this.eventPolicies = eventPolicies;
    }

    public void addPolicy(T eventPolicy) {
        List<T> eventPolicies = new ArrayList<>(this.eventPolicies);
        eventPolicies.add(eventPolicy);
        this.eventPolicies = eventPolicies;
    }

    public void addAllPolicy(List<T> eventPolicies) {
        this.eventPolicies.addAll(eventPolicies);
    }
}
