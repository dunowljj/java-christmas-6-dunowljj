package christmas.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.domain.order.Menu23_12.BARBECUE_RIPS;
import static christmas.domain.order.Menu23_12.CAESAR_SALAD;
import static christmas.validation.IntValidator.NOT_SAME_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {

    private Order 바베큐1개;
    private Order 바베큐2개;
    private Order 시저샐러드2개;

    @BeforeEach
    public void setFixture() {
        바베큐1개 = new Order(BARBECUE_RIPS.getName() + Order.MENU_AND_COUNT_SPLITTER + 1);
        바베큐2개 = new Order(BARBECUE_RIPS.getName() + Order.MENU_AND_COUNT_SPLITTER + 2);
        시저샐러드2개 = new Order(CAESAR_SALAD.getName() + Order.MENU_AND_COUNT_SPLITTER + 2);
    }

    @Test
    public void equals_Menu_종류가_같으면_true_반환() throws Exception {
        //when, then
        assertThat(바베큐1개.equals(바베큐2개)).isTrue();
    }

    @Test
    public void equals_Menu_종류가_다르면_false_반환() throws Exception {
        //given
        Order 바베큐_2개_주문 = new Order(BARBECUE_RIPS.getName() + Order.MENU_AND_COUNT_SPLITTER + 2);
        Order 시저샐러드_2개_주문 = new Order(CAESAR_SALAD.getName() + Order.MENU_AND_COUNT_SPLITTER + 2);

        //when, then
        assertThat(바베큐2개.equals(시저샐러드2개)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2", "레드와인-1", "초코케이크-1"})
    public void Order_생성_및_getter_확인(String correctOrder) throws Exception {
        //given
        Order order = new Order(correctOrder);

        //when
        String menuName = order.getMenuName();
        int count = order.getCount();
        String format = String.format("%s-%d", menuName, count);

        //then
        assertThat(format).isEqualTo(correctOrder);
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파-스타-2", "레-드-와인-1", "초코케이크1"})
    public void Order_생성_split한_길이가_2가_아니면_IllegalArgumentException(String correctOrder) throws Exception {
        //given
        assertThatThrownBy(() -> new Order(correctOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SAME_NUMBER);
    }
}
