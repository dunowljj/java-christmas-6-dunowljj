package christmas.dto.response;

import christmas.domain.Day;

public class DayResponse {
    private final int day;

    public DayResponse(int day) {
        this.day = day;
    }

    public static DayResponse of(Day day) {
        return new DayResponse(day.getDay());
    }

    @Override
    public String toString() {
        return String.valueOf(day);
    }
}
