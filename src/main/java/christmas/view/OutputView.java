package christmas.view;

import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;

public interface OutputView {

    void printWelcome();

    void pintOrderMenus(OrdersResponse ordersResponse);

    void announceCanPreviewBenefits(DayResponse dayResponse);
}
