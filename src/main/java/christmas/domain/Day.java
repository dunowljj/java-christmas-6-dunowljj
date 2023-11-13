package christmas.domain;

import christmas.validation.IntValidator;

public class Day {

    private final int day;

    public Day(int day) {
        IntValidator.that(day).shouldInRange(1, 31);
        this.day = day;
    }
}
