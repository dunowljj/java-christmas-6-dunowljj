package christmas.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.constants.Planner23_12Config.MONTH_END_DAY;
import static christmas.constants.Planner23_12Config.MONTH_START_DAY;
import static christmas.validation.IntValidator.NOT_SAME_NUMBER;
import static christmas.validation.IntValidator.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32, 33})
    public void 숫자_범위_벗어나면_IllegalArgumentException을_던진다(int outRangeNum) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                IntValidator.that(outRangeNum).shouldInRange(MONTH_START_DAY.getValue(), MONTH_END_DAY.getValue()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 30, 31})
    public void 숫자_범위_안이면_아무일도_일어나지_않는다(int outRangeNum) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() ->
                IntValidator.that(outRangeNum).shouldInRange(MONTH_START_DAY.getValue(), MONTH_END_DAY.getValue()));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 32, 1_000_000})
    public void 주어진_숫자와_다르면_IllegalArgumentException을_던진다(int differentNumber) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                IntValidator.that(differentNumber).shouldSameWith(differentNumber + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SAME_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 32, 1_000_000})
    public void 주어진_숫자와_같으면_아무일도_일어나지_않는다(int sameNumber) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() ->
                IntValidator.that(sameNumber).shouldSameWith(sameNumber)
        );
    }
}
