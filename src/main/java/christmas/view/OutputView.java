package christmas.view;

import christmas.domain.TotalBenefitAmount;
import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Discount;
import christmas.domain.benefit.Presents;
import christmas.domain.policy.badge.BadgeRank;
import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;

import java.util.List;

public interface OutputView {

    void printWelcome();

    void pintOrderMenus(OrdersResponse ordersResponse);

    void announceCanPreviewBenefits(DayResponse dayResponse);

    void printOrderPriceAmount(TotalOrderAmount totalOrderAmount);

    void printPresents(Presents presents);

    void printTotalDetails(List<Discount> totalDiscount);

    void printAfterDiscount(TotalOrderAmount totalOrderPriceAmount, long totalDiscountPrice);

    void printEventBadge(List<BadgeRank> badges);

    void printTotalBenefitAmount(TotalBenefitAmount totalBenefitAmount);
}
