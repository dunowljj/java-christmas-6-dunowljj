package christmas.domain.order;

import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.domain.order.Menu23_12.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuTest {

    @Test
    public void 이름으로_Menu_찾기_이름이_존재한다면_해당메뉴_반환() throws Exception {
        //given
        List<Menu> correctMenus = List.of(CHAMPAGNE, CHOCOLATE_CAKE, ZERO_COKE, BUTTON_MUSHROOM_SOUP, ICE_CREAM);

        //when
        List<Menu> findMenus = correctMenus.stream()
                .map((Menu::getName))
                .map(Menu::findMenuBy)
                .toList();

        //then
        assertThat(findMenus).containsAll(correctMenus);
     }

    @Test
    public void 이름으로_Menu_찾기_존재하지_않는다면_IllegalArgumentException이_발생() throws Exception {
        //given
        List<String> wrongNames = List.of("baba", "h44i", "hi33", "heei", "hi11");

        //when, then
        assertThatThrownBy(() -> wrongNames.stream()
                .map(Menu::findMenuBy)
                .toList()
        );
    }
}
