package christmas.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DayTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32, 33})
    public void Day생성_숫자_범위_벗어나면_IllegalArgumentException을_던진다(int outRangeNum) throws Exception {
        //when, then
        assertThatThrownBy(() ->
                new Day(outRangeNum));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 30, 31})
    public void Day생성_숫자_범위_안이면_아무일도_일어나지_않는다(int outRangeNum) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() ->
                new Day(outRangeNum));
    }
}
