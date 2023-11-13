package christmas.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.constants.Planner23_12Config.MONTH_END_DAY;
import static christmas.constants.Planner23_12Config.MONTH_START_DAY;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32, 33})
    public void 숫자_범위_벗어나면_IllegalArgumentException을_던진다(int outRangeNum) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                IntValidator.that(outRangeNum).shouldInRange(MONTH_START_DAY.getValue(), MONTH_END_DAY.getValue()));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 30, 31})
    public void 숫자_범위_안이면_아무일도_일어나지_않는다(int outRangeNum) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() ->
                IntValidator.that(outRangeNum).shouldInRange(MONTH_START_DAY.getValue(), MONTH_END_DAY.getValue()));
    }
}
