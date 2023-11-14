package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.domain.order.Orders;
import christmas.validation.StringValidator;

import static christmas.constants.Planner23_12Config.THIS_MONTH;

public class InputView23_12 implements InputView {

    public static final String ASK_VISIT_DAY_IN_MONTH = String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)", THIS_MONTH.getValue());
    public static final String ASK_MENU_AND_MENU_COUNT_TO_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    @Override
    public Day readVisitDay() {
        System.out.println(ASK_VISIT_DAY_IN_MONTH);
        return new Day(readInt());
    }

    @Override
    public Orders readOrders() {
        System.out.println(ASK_MENU_AND_MENU_COUNT_TO_ORDER);
        return new Orders(readExistLine());
    }

    private int readInt() {
        String input = readExistLine();
        StringValidator.that(input).shouldBeNumberFormat();
        return Integer.parseInt(input);
    }

    private String readExistLine() {
        String input = Console.readLine();
        StringValidator.that(input).shouldNotBlank();
        return input;
    }
}
