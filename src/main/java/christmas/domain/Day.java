package christmas.domain;

import christmas.validation.IntValidator;

import static christmas.constants.Planner23_12Config.MONTH_END_DAY;
import static christmas.constants.Planner23_12Config.MONTH_START_DAY;

public class Day {

    private final int day;

    public Day(int day) {
        IntValidator.that(day).shouldInRange(MONTH_START_DAY.getValue(), MONTH_END_DAY.getValue());
        this.day = day;
    }
}
