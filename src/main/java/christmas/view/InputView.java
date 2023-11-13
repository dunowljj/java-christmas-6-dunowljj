package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.validation.StringValidator;

import static christmas.constants.Planner23_12Config.THIS_MONTH;

public class InputView {

    private static final String WELCOME_WOOWA_RESTAURANT_PLANNER = String.format("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.", THIS_MONTH.getValue());
    public static final String ASK_VISIT_DAY_IN_MONTH = String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)", THIS_MONTH.getValue());

    public static Day readVisitDay() {
        System.out.println(WELCOME_WOOWA_RESTAURANT_PLANNER);
        System.out.println(ASK_VISIT_DAY_IN_MONTH);
        int inputNum = readInt();
        return new Day(inputNum);
    }

    private static int readInt() {
        String input = readExistLine();
        StringValidator.that(input).shouldBeNumberFormat();
        return Integer.parseInt(input);
    }


    private static String readExistLine() {
        String input = Console.readLine();
        StringValidator.that(input).shouldNotBlank();
        return input;
    }
}
