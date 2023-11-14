package christmas.validation;

public class StringValidator {

    public static final String EMPTY_INPUT = "빈 값이 입력되었습니다.";
    public static final String CANNOT_CONVERT_TO_NUMBER = "숫자로 변환할 수 없습니다.";
    public static final String INCLUDE_SPACE = "공백이 포함되었습니다.";
    public static final String BAD_PREFIX = "해당 문자로 시작해선 안됩니다.";
    public static final String BAD_SUFFIX = "해당 문자로 끝나서는 안됩니다.";

    private final String value;

    public StringValidator(String value) {
        this.value = value;
    }

    public static StringValidator that(String value) {
        return new StringValidator(value);
    }

    public StringValidator shouldNotBlank() {
        if (value.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
        return this;
    }

    public StringValidator shouldBeNumberFormat() {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_TO_NUMBER);
        }
        return this;
    }

    public StringValidator shouldNotIncludeSpace() {
        if (value.chars().anyMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException(INCLUDE_SPACE);
        }
        return this;
    }

    public StringValidator shouldNotStartWith(String prefix) {
        if (value.startsWith(prefix)) {
            throw new IllegalArgumentException(BAD_PREFIX);
        }
        return this;
    }

    public StringValidator shouldNotEndWith(String suffix) {
        if (value.endsWith(suffix)) {
            throw new IllegalArgumentException(BAD_SUFFIX);
        }
        return this;
    }
}
