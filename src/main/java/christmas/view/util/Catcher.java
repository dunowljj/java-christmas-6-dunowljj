package christmas.view.util;

import christmas.constants.ErrorMessage;

import java.util.function.Supplier;

public class Catcher {

    public static <T> T retryWhenException(ErrorMessage errorMessage, Supplier<T> supplier) {

        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage.getMessage());
                System.out.println();
            }
        }
    }
}
