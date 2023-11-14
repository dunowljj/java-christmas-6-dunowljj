package christmas.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static christmas.domain.order.Menu23_12.BARBECUE_RIPS;
import static christmas.domain.order.Menu23_12.CAESAR_SALAD;
import static org.assertj.core.api.Assertions.assertThat;

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
}
