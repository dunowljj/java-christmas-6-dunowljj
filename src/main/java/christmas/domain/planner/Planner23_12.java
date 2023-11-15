package christmas.domain.planner;

import christmas.constants.ErrorMessage;
import christmas.domain.Day;
import christmas.domain.TotalBenefitAmount;
import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Discount;
import christmas.domain.benefit.Presents;
import christmas.domain.order.Orders;
import christmas.domain.policy.badge.ChristmasEventBadgePolicy;
import christmas.domain.policy.badge.EventTotalAmountBadgePolicyManager;
import christmas.domain.policy.discount.date.*;
import christmas.domain.policy.discount.order.EventOrderDiscountPolicyManager;
import christmas.domain.policy.present.ChristmasChampagnePresentPolicy;
import christmas.domain.policy.present.EventTotalAmountPresentPolicy;
import christmas.domain.policy.present.EventTotalAmountPresentPolicyManager;
import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.util.Catcher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static christmas.constants.Planner23_12Config.THIS_MONTH;
import static christmas.constants.Planner23_12Config.THIS_YEAR;

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
        LocalDate nowDate = getNowDate(visitDay);
        Orders orders = getOrders();

        outputView.announceCanPreviewBenefits(DayResponse.of(visitDay));
        outputView.pintOrderMenus(OrdersResponse.from(orders));

        TotalOrderAmount totalOrderPriceAmount = orders.makeTotal();
        outputView.printOrderAmount(totalOrderPriceAmount);
        EventTotalAmountPresentPolicy presentPolicy = new ChristmasChampagnePresentPolicy();
        Presents presents = presentPolicy.findPresents(totalOrderPriceAmount);
        outputView.printPresents(presents);

        List<Discount> totalDiscount = getTotalDiscount(orders, nowDate);

        long presentsBenefitPrice = presents.getBenefitPrice();
        if (!presents.isEmpty()) {
            totalDiscount.add(new Discount("증정 이벤트", presentsBenefitPrice));
        }

        long totalDiscountPrice= getTotalDiscountPrice(totalDiscount);
        List<String> benefitNames = getBenefitNames(totalDiscount);

        TotalBenefitAmount totalBenefitAmount = new TotalBenefitAmount(totalDiscountPrice + presentsBenefitPrice);

        outputView.printTotalBenefitAmount(totalBenefitAmount);
        outputView.printTotalDetails(totalDiscount);
        outputView.printAfterDiscount(totalOrderPriceAmount, totalDiscountPrice);
        ChristmasEventBadgePolicy christmasEventBadgePolicy = new ChristmasEventBadgePolicy();
        outputView.printEventBadge(christmasEventBadgePolicy.findBadges(totalBenefitAmount));
    }

    private static List<String> getBenefitNames(List<Discount> totalDiscount) {
        return totalDiscount.stream().map((discount -> discount.getName()))
                .toList();
    }

    private static Long getTotalDiscountPrice(List<Discount> totalDiscount) {
        return totalDiscount.stream().map((discount -> discount.getAmount()))
                .reduce(Long::sum).orElse(0L);
    }

    private LocalDate getNowDate(Day visitDay) {
        return LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), visitDay.getDay());
    }

    private List<Discount> getTotalDiscount(Orders orders, LocalDate nowDate) {
        List<Discount> discounts = new ArrayList<>();

        getDdayDiscount(discounts, nowDate);
        getSpecialDiscount(discounts, nowDate);
        getWeekDayDiscount(discounts, orders, nowDate);
        getWeekendDiscount(discounts, orders, nowDate);

        return discounts;
    }

    private void getDdayDiscount(List<Discount> discounts, LocalDate nowDate) {
        ChristmasDdayDiscountPolicy christmasDdayDiscountPolicy = new ChristmasDdayDiscountPolicy();
        Long discount = christmasDdayDiscountPolicy.calculateDiscount(nowDate);
        if (discount != 0L) {
            discounts.add(new Discount("크리스마스 디데이 할인", discount));
        }
    }

    private void getSpecialDiscount(List<Discount> discounts, LocalDate nowDate) {
        ChristmasSpecialDiscountPolicy christmasSpecialDiscountPolicy = new ChristmasSpecialDiscountPolicy();
        Long discount = christmasSpecialDiscountPolicy.calculateDiscount(nowDate);
        if (discount != 0L) {
            discounts.add(new Discount("특별 할인", discount));
        }
    }

    private void getWeekDayDiscount(List<Discount> discounts, Orders orders, LocalDate nowDate) {
        ChristmasWeekDayDiscountPolicy christmasWeekDayDiscountPolicy = new ChristmasWeekDayDiscountPolicy();
        Long discount = christmasWeekDayDiscountPolicy.calculateDiscount(orders, nowDate);
        if (discount != 0L) {
            discounts.add(new Discount("평일 할인", discount));
        }
    }

    private void getWeekendDiscount(List<Discount> discounts, Orders orders, LocalDate nowDate) {
        ChristmasWeekendDiscountPolicy christmasWeekendDiscountPolicy = new ChristmasWeekendDiscountPolicy();
        Long discount = christmasWeekendDiscountPolicy.calculateDiscount(orders, nowDate);
        if (discount != 0L) {
            discounts.add(new Discount("주말 할인", discount));
        }
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
