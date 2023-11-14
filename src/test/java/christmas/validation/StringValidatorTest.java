package christmas.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\n"})
    public void 공백문자이면_IllegalArgumentException을_던진다(String empty) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                StringValidator.that(empty).shouldNotBlank());
    }

    @ParameterizedTest
    @ValueSource(strings = {"r","ac","#@"})
    public void 문자이면_아무일도_일어나지_않는다(String string) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() ->
                StringValidator.that(string).shouldNotBlank());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a c","a\nn","n\t","디저트-1 식사-1"," bc","티본 스테이크-1"})
    public void 문자사이에_공백이_있다면_IllegalArgumentException을_던진다(String string) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                StringValidator.that(string).shouldNotIncludeSpace());
    }

    @ParameterizedTest
    @ValueSource(strings = {"rㄹㅇㅁ","aㅠc129","티본스테이크-1"})
    public void 문자사이에_공백이_없다면_정상(String string) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() ->
                StringValidator.that(string).shouldNotIncludeSpace());
    }
}
