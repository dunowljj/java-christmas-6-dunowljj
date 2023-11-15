package christmas.domain.planner;

import christmas.constants.ErrorMessage;
import christmas.domain.Day;
import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Presents;
import christmas.domain.order.Orders;
import christmas.domain.policy.badge.EventTotalAmountBadgePolicyManager;
import christmas.domain.policy.discount.date.EventDateDiscountPolicyManager;
import christmas.domain.policy.discount.order.EventOrderDiscountPolicyManager;
import christmas.domain.policy.present.ChristmasChampagnePresentPolicy;
import christmas.domain.policy.present.EventTotalAmountPresentPolicy;
import christmas.domain.policy.present.EventTotalAmountPresentPolicyManager;
import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.util.Catcher;

public class Planner23_12 implements EventPlanner {

    private final OutputView outputView;
    private final InputView inputView;
    private final EventOrderDiscountPolicyManager eventOrderDiscountPolicyManager;
    private final EventDateDiscountPolicyManager eventDateDiscountPolicyManager;
    private final EventTotalAmountPresentPolicyManager eventTotalAmountPresentPolicyManager;
    private final EventTotalAmountBadgePolicyManager eventTotalAmountBadgePolicyManager;

    public Planner23_12(
            OutputView outputView,
            InputView inputView,
            EventOrderDiscountPolicyManager eventOrderDiscountPolicyManager,
            EventDateDiscountPolicyManager eventDateDiscountPolicyManager,
            EventTotalAmountPresentPolicyManager eventTotalAmountPresentPolicyManager,
            EventTotalAmountBadgePolicyManager eventTotalAmountBadgePolicyManager
    ) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.eventOrderDiscountPolicyManager = eventOrderDiscountPolicyManager;
        this.eventDateDiscountPolicyManager = eventDateDiscountPolicyManager;
        this.eventTotalAmountPresentPolicyManager = eventTotalAmountPresentPolicyManager;
        this.eventTotalAmountBadgePolicyManager = eventTotalAmountBadgePolicyManager;
    }

    @Override
    public void makePlan() {
        Day visitDay = getVisitDay();
        Orders orders = getOrders();

        outputView.announceCanPreviewBenefits(DayResponse.of(visitDay));
        outputView.pintOrderMenus(OrdersResponse.from(orders));

        TotalOrderAmount totalOrderAmount = orders.makeTotal();
        outputView.printOrderAmount(totalOrderAmount);
        EventTotalAmountPresentPolicy presentPolicy = new ChristmasChampagnePresentPolicy();
        Presents presents = presentPolicy.findPresents(totalOrderAmount);
        outputView.printPresents(presents);
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
