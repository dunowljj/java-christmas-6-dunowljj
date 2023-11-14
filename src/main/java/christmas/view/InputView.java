package christmas.view;

import christmas.domain.Day;
import christmas.domain.order.Orders;

public interface InputView {

    Day readVisitDay();

    Orders readOrders();
}
