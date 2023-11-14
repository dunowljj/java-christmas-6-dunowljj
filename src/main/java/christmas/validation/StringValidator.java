package christmas.validation;

public class StringValidator {

    public static final String EMPTY_INPUT = "빈 값이 입력되었습니다.";
    public static final String CANNOT_CONVERT_TO_NUMBER = "숫자로 변환할 수 없습니다.";

    private final String value;

    public StringValidator(String value) {
        this.value = value;
    }

    public static StringValidator that(String value) {
        return new StringValidator(value);
    }

    public void shouldNotBlank() {
        if (value.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    public void shouldBeNumberFormat() {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_TO_NUMBER);
        }
    }

    public void shouldNotIncludeSpace() {
        if (value.chars().anyMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }
}
