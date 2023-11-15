package christmas.view.util;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatUtils {

    public static String toKoreaMoneyFormat(long money) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(money);
    }
}
