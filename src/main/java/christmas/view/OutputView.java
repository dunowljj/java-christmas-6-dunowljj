package christmas.view;

import christmas.domain.TotalBenefitAmount;
import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Badges;
import christmas.domain.benefit.Discounts;
import christmas.domain.benefit.Presents;
import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;

public interface OutputView {

    void printWelcome();

    void pintOrderMenus(OrdersResponse ordersResponse);

    void announceCanPreviewBenefits(DayResponse dayResponse);

    void printPriceBeforeDiscount(TotalOrderAmount totalOrderAmount);

    void printPresents(Presents presents);

    void printBenefitDetails(Discounts totalDiscount);

    void printPriceAfterDiscount(TotalOrderAmount totalOrderPriceAmount, long totalDiscountPrice);

    void printEventBadges(Badges Badges);

    void printTotalBenefitAmount(TotalBenefitAmount totalBenefitAmount);
}
