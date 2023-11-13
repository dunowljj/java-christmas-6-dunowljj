package christmas.domain.planner;

import christmas.domain.policy.DiscountPolicy;
import christmas.domain.policy.PresentPolicy;

import java.util.List;

public class Planner23_12 implements EventPlanner {

    private final List<DiscountPolicy> discountPolicies;
    private final List<PresentPolicy> presentPolicies;

    public Planner23_12(List<DiscountPolicy> discountPolicies, List<PresentPolicy> presentPolicies) {
        this.discountPolicies = discountPolicies;
        this.presentPolicies = presentPolicies;
    }

    @Override
    public void makePlan() {

    }
}
