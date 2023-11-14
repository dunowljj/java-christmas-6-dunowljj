package christmas.domain.order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1","0","50001","50002"})
    public void MenuCount_생성_숫자_범위를_넘어서면__IllegalArgumentException을_던진다(String outRangeNumber) throws Exception {
        //when, then
        assertThatThrownBy(() -> new MenuCount(outRangeNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","10","5000","50000"})
    public void MenuCount_생성_숫자_범위안이라면_성공(String inRangeNumber) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() -> new MenuCount(inRangeNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"fas","a131","@#1"," ","1 3"})
    public void MenuCount_생성_숫자_변환_실패_시_IllegalArgumentException을_던진다(String cannotBeNumber) throws Exception {
        //when, then
        assertThatThrownBy(() -> new MenuCount(cannotBeNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123","10","59","100"})
    public void MenuCount_생성_숫자_변환_성공(String canBeNumber) throws Exception {
        //when, then
        assertThatNoException().isThrownBy(() -> new MenuCount(canBeNumber));
    }
}
