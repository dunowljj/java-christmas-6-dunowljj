package christmas.validation;

public class IntValidator {

    public static final String OUT_OF_RANGE = "숫자 범위를 벗어났습니다.";
    public static final String NOT_SAME_NUMBER = "숫자가 일치하지 않습니다.";

    private final int value;

    public IntValidator(int value) {
        this.value = value;
    }

    public static IntValidator that(int num) {
        return new IntValidator(num);
    }

    public void shouldInRange(int includeStart, int includeEnd) {
        if (!isInRange(includeStart, includeEnd)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    private boolean isInRange(int includeStart, int includeEnd) {
        return includeStart <= value && value <= includeEnd;
    }

    public IntValidator shouldSameWith(int num) {
        if (value != num) {
            throw new IllegalArgumentException(NOT_SAME_NUMBER);
        }
        return this;
    }
}
