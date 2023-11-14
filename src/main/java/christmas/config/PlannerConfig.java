package christmas.config;

import christmas.domain.planner.EventPlanner;
import christmas.domain.planner.Planner23_12;
import christmas.domain.policy.DiscountPolicy;
import christmas.domain.policy.PresentPolicy;
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
                discountPolicies(), presentPolicies(),
                outputView23_12(), inputView23_12()
        );
    }

    private List<DiscountPolicy> discountPolicies() {
        return List.of();
    }

    private List<PresentPolicy> presentPolicies() {
        return List.of();
    }


    private InputView inputView23_12() {
        return new InputView23_12();
    }

    private OutputView outputView23_12() {
        return new OutputView23_12();
    }

    public EventPlanner injectPlanner() {
        return eventPlanner;
    }
}
