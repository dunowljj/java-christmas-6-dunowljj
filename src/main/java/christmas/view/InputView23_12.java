package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validation.StringValidator;

import static christmas.constants.Planner23_12Config.THIS_MONTH;

public class InputView23_12 implements InputView {

    public static final String ASK_VISIT_DAY_IN_MONTH = String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)", THIS_MONTH.getValue());

    @Override
    public int readVisitDay() {
        System.out.println(ASK_VISIT_DAY_IN_MONTH);
        return readInt();
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
