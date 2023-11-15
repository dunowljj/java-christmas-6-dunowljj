package christmas.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class dateUtils {

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public static boolean isWeekday(LocalDate date) {
        return !isWeekend(date);
    }
}
