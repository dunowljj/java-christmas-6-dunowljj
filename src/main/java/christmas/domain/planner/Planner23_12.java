package christmas.domain.planner;

import christmas.constants.ErrorMessage;
import christmas.domain.Day;
import christmas.domain.TotalOrderAmount;
import christmas.domain.order.Orders;
import christmas.domain.policy.EventPolicyManager;
import christmas.domain.policy.badge.EventBadgePolicy;
import christmas.domain.policy.discount.EventDateDiscountPolicy;
import christmas.domain.policy.discount.EventOrderDiscountPolicy;
import christmas.domain.policy.present.EventPresentPolicy;
import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.util.Catcher;

public class Planner23_12 implements EventPlanner {

    private final OutputView outputView;
    private final InputView inputView;
    private final EventPolicyManager<EventOrderDiscountPolicy> eventOrderDiscountPolicyManager;
    private final EventPolicyManager<EventDateDiscountPolicy> eventDateDiscountPolicyManager;
    private final EventPolicyManager<EventPresentPolicy> eventPresentPolicyManager;
    private final EventPolicyManager<EventBadgePolicy> eventBadgePolicyManager;

    public Planner23_12(
            OutputView outputView,
            InputView inputView,
            EventPolicyManager<EventOrderDiscountPolicy> eventOrderDiscountPolicyManager,
            EventPolicyManager<EventDateDiscountPolicy> eventDateDiscountPolicyManager,
            EventPolicyManager<EventPresentPolicy> eventPresentPolicyManager,
            EventPolicyManager<EventBadgePolicy> eventBadgePolicyManager
    ) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.eventOrderDiscountPolicyManager = eventOrderDiscountPolicyManager;
        this.eventDateDiscountPolicyManager = eventDateDiscountPolicyManager;
        this.eventPresentPolicyManager = eventPresentPolicyManager;
        this.eventBadgePolicyManager = eventBadgePolicyManager;
    }

    @Override
    public void makePlan() {
        Day visitDay = getVisitDay();
        Orders orders = getOrders();

        outputView.announceCanPreviewBenefits(DayResponse.of(visitDay));
        outputView.pintOrderMenus(OrdersResponse.from(orders));

        TotalOrderAmount totalOrderAmount = orders.makeTotal();
    }

    private Day getVisitDay() {
        outputView.printWelcome();
        return Catcher.retryWhenException(
                ErrorMessage.INVALID_DATE, inputView::readVisitDay
        );
    }

    private Orders getOrders() {
        return Catcher.retryWhenException(
                ErrorMessage.INVALID_ORDER, inputView::readOrders
        );
    }
}
