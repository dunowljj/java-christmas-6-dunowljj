package christmas.view;

import christmas.domain.TotalBenefitAmount;
import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Badges;
import christmas.domain.benefit.Discounts;
import christmas.domain.benefit.Presents;
import christmas.dto.response.DayResponse;
import christmas.dto.response.OrdersResponse;

import static christmas.constants.Planner23_12Config.THIS_MONTH;
import static christmas.view.util.FormatUtils.toKoreaMoneyFormat;

public class OutputView23_12 implements OutputView {

    private static final String WELCOME_WOOWA_RESTAURANT_PLANNER = String.format("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.", THIS_MONTH.getValue());
    public static final String OPEN_BRACKET = "<";
    public static final String CLOSE_BRACKET = ">";
    public static final String TITLE_OF_ORDER_MENU = "주문 메뉴";
    public static final String TITLE_OF_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT = "할인 전 총주문 금액";
    public static final String TITLE_OF_PRESENT_MENU = "증정 메뉴";

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
        System.out.println(title(TITLE_OF_ORDER_MENU));
        System.out.println(buildOrdersResponseMessage(ordersResponse));
    }

    private StringBuilder buildOrdersResponseMessage(OrdersResponse ordersResponse) {
        StringBuilder result = new StringBuilder();
        ordersResponse.stream()
                .forEach(((order) -> result.append(order).append("\n")));
        return result;
    }

    @Override
    public void printPriceBeforeDiscount(TotalOrderAmount totalOrderAmount) {
        System.out.println(title(TITLE_OF_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT));
        System.out.println(totalOrderAmount);
        System.out.println();
    }

    @Override
    public void printPresents(Presents presents) {
        System.out.println(title(TITLE_OF_PRESENT_MENU));
        System.out.print(buildPresentsMessage(presents));
        System.out.println();
    }

    @Override
    public void printBenefitDetails(Discounts totalDiscount) {
        System.out.println(title("혜택 내역"));
        System.out.print(buildTotalDetails(totalDiscount));
        System.out.println();
    }

    @Override
    public void printTotalBenefitAmount(TotalBenefitAmount totalBenefitAmount) {
        System.out.println(title("총혜택 금액"));
        System.out.println(String.format("-%s원", toKoreaMoneyFormat(totalBenefitAmount.getValue())));
        System.out.println();
    }
    @Override
    public void printPriceAfterDiscount(TotalOrderAmount totalOrderPriceAmount, long totalDiscountPrice) {
        System.out.println(title("할인 후 예상 결제 금액"));
        long expect = totalOrderPriceAmount.getTotalPrice() - totalDiscountPrice;
        System.out.println(String.format("%s원", toKoreaMoneyFormat(expect)));
        System.out.println();
    }

    @Override
    public void printEventBadges(Badges Badges) {
        System.out.println(title("12월 이벤트 배지"));
        System.out.println(buildBadgesMessage(Badges));
    }

    private StringBuilder buildPresentsMessage(Presents presents) {
        StringBuilder result = new StringBuilder();
        presents.stream()
                .forEach(((present) -> result.append(present).append("\n")));
        return result;
    }

    private StringBuilder buildTotalDetails(Discounts discounts) {
        StringBuilder result = new StringBuilder();
        discounts.stream()
                .forEach(((discount) -> result.append(discount).append("\n")));
        return result;
    }

    private StringBuilder buildBadgesMessage(Badges Badges) {
        StringBuilder result = new StringBuilder();
        Badges.stream()
                .forEach(((badgeRank) -> result.append(badgeRank).append("\n")));
        return result;
    }

    private String title(String message) {
        return OPEN_BRACKET + message + CLOSE_BRACKET;
    }
}
