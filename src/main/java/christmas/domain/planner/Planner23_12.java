package christmas.domain.planner;

import christmas.constants.ErrorMessage;
import christmas.domain.Day;
import christmas.domain.policy.DiscountPolicy;
import christmas.domain.policy.PresentPolicy;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.util.Catcher;

import java.util.List;

public class Planner23_12 implements EventPlanner {

    private final List<DiscountPolicy> discountPolicies;
    private final List<PresentPolicy> presentPolicies;
    private final OutputView outputView;
    private final InputView inputView;

    public Planner23_12(
            List<DiscountPolicy> discountPolicies, List<PresentPolicy> presentPolicies,
            OutputView outputView, InputView inputView
    ) {
        this.discountPolicies = discountPolicies;
        this.presentPolicies = presentPolicies;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    public void makePlan() {
        Day visitDay = getVisitDay();
    }

    private Day getVisitDay() {
        outputView.printWelcome();

        return Catcher.retryWhenException(ErrorMessage.INVALID_DATE, () -> {
            int value = inputView.readVisitDay();
            return new Day(value);
        });
    }
}
