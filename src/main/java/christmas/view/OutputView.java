package christmas.view;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Presents;
import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;

public interface OutputView {

    void printWelcome();

    void pintOrderMenus(OrdersResponse ordersResponse);

    void announceCanPreviewBenefits(DayResponse dayResponse);

    void printOrderAmount(TotalOrderAmount totalOrderAmount);

    void printPresents(Presents presents);
}
