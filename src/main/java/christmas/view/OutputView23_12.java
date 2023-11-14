package christmas.view;

import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;

import static christmas.constants.Planner23_12Config.THIS_MONTH;

public class OutputView23_12 implements OutputView {

    private static final String WELCOME_WOOWA_RESTAURANT_PLANNER = String.format("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.", THIS_MONTH.getValue());
    public static final String OPEN_BRACKET = "<";
    public static final String CLOSE_BRACKET = ">";
    public static final String ORDER_MENU = "주문 메뉴";

    @Override
    public void printWelcome() {
        System.out.println(WELCOME_WOOWA_RESTAURANT_PLANNER);
    }

    @Override
    public void announceCanPreviewBenefits(DayResponse dayResponse) {
        System.out.println(String.format("%d월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", THIS_MONTH.getValue(), dayResponse));
    }

    @Override
    public void pintOrderMenus(OrdersResponse ordersResponse) {
        System.out.println(resultFormat(ORDER_MENU));

        StringBuilder result = buildOrdersResponseMessage(ordersResponse);
        System.out.println(result);
    }

    private StringBuilder buildOrdersResponseMessage(OrdersResponse ordersResponse) {
        StringBuilder result = new StringBuilder();
        ordersResponse.stream()
                .forEach(((order) -> result.append(order).append("\n")));
        return result;
    }

    private String resultFormat(String message) {
        return OPEN_BRACKET + message + CLOSE_BRACKET;
    }
}
