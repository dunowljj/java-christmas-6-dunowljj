package christmas.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.validation.StringValidator.*;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringValidatorTest {

    public static final String DELIMITER = ",";

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\n"})
    public void 공백문자이면_IllegalArgumentException을_던진다(String empty) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                StringValidator.that(empty).shouldNotBlank())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "ac", "#@"})
    public void 문자이면_아무일도_일어나지_않는다(String string) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() ->
                StringValidator.that(string).shouldNotBlank());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a c", "a\nn", "n\t", "디저트-1 식사-1", " bc", "티본 스테이크-1"})
    public void 문자사이에_공백이_있다면_IllegalArgumentException을_던진다(String string) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                StringValidator.that(string).shouldNotIncludeSpace())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCLUDE_SPACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"rㄹㅇㅁ", "aㅠc129", "티본스테이크-1"})
    public void 문자사이에_공백이_없다면_정상(String string) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() ->
                StringValidator.that(string).shouldNotIncludeSpace());
    }

    @ParameterizedTest
    @ValueSource(strings = {",티본스테이크-1", ",티본스테이크-1,", ", ", ","})
    public void 문자_맨_앞에_특정_구분자가_있다면_IllegalArgumentException을_던진다(String string) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                StringValidator.that(string).shouldNotStartWith(DELIMITER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BAD_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,", " ,", DELIMITER})
    public void 문자_맨_뒤에_특정_구분자가_있다면_IllegalArgumentException을_던진다(String string) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                StringValidator.that(string).shouldNotEndWith(DELIMITER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BAD_SUFFIX);
    }


    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,", ",티본스테이크-1,", ",티본스테이크-1,", ","})
    public void 문자_양끝중_어디든_특정_구분자가_있다면_IllegalArgumentException을_던진다(String string) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                StringValidator.that(string)
                        .shouldNotStartWith(DELIMITER)
                        .shouldNotEndWith(DELIMITER)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
