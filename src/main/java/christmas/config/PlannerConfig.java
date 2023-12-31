package christmas.config;

import christmas.domain.planner.EventPlanner;
import christmas.domain.planner.Planner23_12;
import christmas.domain.policy.badge.ChristmasEventBadgePolicy;
import christmas.domain.policy.badge.EventTotalBenefitAmountBadgePolicy;
import christmas.domain.policy.badge.EventTotalBenefitAmountBadgePolicyApplier;
import christmas.domain.policy.discount.EventDateAndOrderDiscountPolicyApplier;
import christmas.domain.policy.discount.date.*;
import christmas.domain.policy.discount.order.EventOrderDiscountPolicy;
import christmas.domain.policy.discount.order.EventOrderDiscountPolicyApplier;
import christmas.domain.policy.present.ChristmasChampagnePresentPolicy;
import christmas.domain.policy.present.EventTotalAmountPresentPolicy;
import christmas.domain.policy.present.EventTotalAmountPresentPolicyApplier;
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
                eventOrderPolicyManager(), eventDateDiscountApplier(),
                eventPresentPolicyApplier(), eventBadgePolicyApplier(),
                eventDateAndOrderDiscountPolicyManager()
        );
    }

    private InputView inputView23_12() {
        return new InputView23_12();
    }

    private OutputView outputView23_12() {
        return new OutputView23_12();
    }

    private EventOrderDiscountPolicyApplier eventOrderPolicyManager() {
        return new EventOrderDiscountPolicyApplier(eventOrderPolicies());
    }

    private EventDateDiscountPolicyApplier eventDateDiscountApplier() {
        return new EventDateDiscountPolicyApplier(eventDateDiscountPolicies());
    }

    private EventTotalAmountPresentPolicyApplier eventPresentPolicyApplier() {
        return new EventTotalAmountPresentPolicyApplier(eventPresentPolicies());
    }

    private EventTotalBenefitAmountBadgePolicyApplier eventBadgePolicyApplier() {
        return new EventTotalBenefitAmountBadgePolicyApplier(eventBadgePolicies());
    }

    private EventDateAndOrderDiscountPolicyApplier eventDateAndOrderDiscountPolicyManager() {
        return new EventDateAndOrderDiscountPolicyApplier(eventDateAndOrderDiscountPolicies());
    }
    private List<EventOrderDiscountPolicy> eventOrderPolicies() {
        return List.of();
    }


    private List<EventDateAndOrderDiscountPolicy> eventDateAndOrderDiscountPolicies() {
        return List.of(new ChristmasWeekendDiscountPolicy(), new ChristmasWeekDayDiscountPolicy());
    }

    private List<EventDateDiscountPolicy> eventDateDiscountPolicies() {
        return List.of(new ChristmasDdayDiscountPolicy(), new ChristmasSpecialDiscountPolicy());
    }

    private List<EventTotalAmountPresentPolicy> eventPresentPolicies() {
        return List.of(new ChristmasChampagnePresentPolicy());
    }

    private List<EventTotalBenefitAmountBadgePolicy> eventBadgePolicies() {
        return List.of(new ChristmasEventBadgePolicy());
    }

    public EventPlanner injectPlanner() {
        return eventPlanner;
    }
}
