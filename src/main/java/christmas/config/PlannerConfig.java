package christmas.config;

import christmas.domain.planner.EventPlanner;
import christmas.domain.planner.Planner23_12;
import christmas.domain.policy.badge.EventTotalAmountBadgePolicy;
import christmas.domain.policy.badge.EventTotalAmountBadgePolicyManager;
import christmas.domain.policy.discount.date.EventDateDiscountPolicy;
import christmas.domain.policy.discount.date.EventDateDiscountPolicyManager;
import christmas.domain.policy.discount.order.EventOrderDiscountPolicy;
import christmas.domain.policy.discount.order.EventOrderDiscountPolicyManager;
import christmas.domain.policy.present.EventTotalAmountPresentPolicy;
import christmas.domain.policy.present.EventTotalAmountPresentPolicyManager;
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

    private EventOrderDiscountPolicyManager eventOrderPolicyManager() {
        return new EventOrderDiscountPolicyManager(eventOrderPolicies());
    }

    private EventDateDiscountPolicyManager eventDateDiscountManger() {
        return new EventDateDiscountPolicyManager(eventDateDiscountPolicies());
    }

    private EventTotalAmountPresentPolicyManager eventPresentPolicyManger() {
        return new EventTotalAmountPresentPolicyManager(eventPresentPolicies());
    }

    private EventTotalAmountBadgePolicyManager eventBadgePolicyManger() {
        return new EventTotalAmountBadgePolicyManager(eventBadgePolicies());
    }

    private List<EventOrderDiscountPolicy> eventOrderPolicies() {
        return List.of();
    }

    private List<EventDateDiscountPolicy> eventDateDiscountPolicies() {
        return List.of();
    }

    private List<EventTotalAmountPresentPolicy> eventPresentPolicies() {
        return List.of();
    }

    private List<EventTotalAmountBadgePolicy> eventBadgePolicies() {
        return List.of();
    }

    public EventPlanner injectPlanner() {
        return eventPlanner;
    }
}
