package christmas.view;

import static christmas.constants.Planner23_12Config.THIS_MONTH;

public class OutputView {

    private static final String WELCOME_WOOWA_RESTAURANT_PLANNER = String.format("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.", THIS_MONTH.getValue());

    public static void printWelcome() {
        System.out.println(WELCOME_WOOWA_RESTAURANT_PLANNER);
    }
}
