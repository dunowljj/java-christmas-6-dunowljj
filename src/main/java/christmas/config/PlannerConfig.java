package christmas.config;

import christmas.domain.planner.EventPlanner;
import christmas.domain.planner.Planner23_12;
import christmas.domain.policy.EventPolicyManager;
import christmas.domain.policy.badge.EventBadgePolicy;
import christmas.domain.policy.discount.EventDateDiscountPolicy;
import christmas.domain.policy.discount.EventOrderDiscountPolicy;
import christmas.domain.policy.present.EventPresentPolicy;
import christmas.view.InputView;
import christmas.view.InputView23_12;
import christmas.view.OutputView;
import christmas.view.OutputView23_12;

import java.util.List;

public class PlannerConfig {
    private final EventPlanner eventPlanner;

    public PlannerConfig() {
        this.eventPlanner = Planner23_12();
    }

    private Planner23_12 Planner23_12() {
        return new Planner23_12(
                outputView23_12(), inputView23_12(),
                eventOrderPolicyManager(), eventDateDiscountManger(),
                eventPresentPolicyManger(), eventBadgePolicyManger()
        );
    }

    private InputView inputView23_12() {
        return new InputView23_12();
    }

    private OutputView outputView23_12() {
        return new OutputView23_12();
    }

    private EventPolicyManager<EventOrderDiscountPolicy> eventOrderPolicyManager() {
        return new EventPolicyManager<>(eventOrderPolicies());
    }

    private EventPolicyManager<EventDateDiscountPolicy> eventDateDiscountManger() {
        return new EventPolicyManager<>(eventDateDiscountPolicies());
    }

    private EventPolicyManager<EventPresentPolicy> eventPresentPolicyManger() {
        return new EventPolicyManager<>(eventPresentPolicies());
    }

    private EventPolicyManager<EventBadgePolicy> eventBadgePolicyManger() {
        return new EventPolicyManager<>(eventBadgePolicies());
    }

    private List<EventOrderDiscountPolicy> eventOrderPolicies() {
        return List.of();
    }

    private List<EventDateDiscountPolicy> eventDateDiscountPolicies() {
        return List.of();
    }

    private List<EventPresentPolicy> eventPresentPolicies() {
        return List.of();
    }

    private List<EventBadgePolicy> eventBadgePolicies() {
        return List.of();
    }

    public EventPlanner injectPlanner() {
        return eventPlanner;
    }
}
