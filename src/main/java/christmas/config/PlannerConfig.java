package christmas.config;

import christmas.domain.planner.Planner23_12;
import christmas.domain.planner.EventPlanner;
import christmas.domain.policy.DiscountPolicy;
import christmas.domain.policy.PresentPolicy;

import java.util.List;

public class PlannerConfig {
    private final EventPlanner eventPlanner;

    public PlannerConfig() {
        this.eventPlanner = december2023Planner();
    }

    private Planner23_12 december2023Planner() {
        return new Planner23_12(discountPolicies(), presentPolicies());
    }

    private List<DiscountPolicy> discountPolicies() {
        return List.of();
    }

    private List<PresentPolicy> presentPolicies() {
        return List.of();
    }

    public EventPlanner getEventPlanner() {
        return eventPlanner;
    }
}
