package christmas.validation;

import christmas.domain.order.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.domain.order.Menu23_12.*;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CollectionValidatorTest {

    @Test
    public void 중복되는_원소가_있으면_IllegalArgumentException을_던진다() throws Exception {
        //given
        List<Order> hasDuplicationCollection = List.of(
                new Order(BARBECUE_RIPS.getName() + Order.MENU_AND_COUNT_SPLITTER + 1),
                new Order(BARBECUE_RIPS.getName() + Order.MENU_AND_COUNT_SPLITTER + 1),
                new Order(CAESAR_SALAD.getName() + Order.MENU_AND_COUNT_SPLITTER + 2),
                new Order(BUTTON_MUSHROOM_SOUP.getName() + Order.MENU_AND_COUNT_SPLITTER + 1)
        );

        //when, then
        assertThatThrownBy(() ->
                CollectionValidator.that(hasDuplicationCollection).shouldNotHasDuplicatedElement()
        );
    }

    @Test
    public void 중복되는_원소가_없으면_통과() throws Exception {
        //given
        List<Order> hasNoDuplicationCollection = List.of(
                new Order(ZERO_COKE.getName() + Order.MENU_AND_COUNT_SPLITTER + 1),
                new Order(BARBECUE_RIPS.getName() + Order.MENU_AND_COUNT_SPLITTER + 1),
                new Order(CAESAR_SALAD.getName() + Order.MENU_AND_COUNT_SPLITTER + 2),
                new Order(BUTTON_MUSHROOM_SOUP.getName() + Order.MENU_AND_COUNT_SPLITTER + 1)
        );

        //when, when
        assertThatNoException().isThrownBy(() ->
                CollectionValidator.that(hasNoDuplicationCollection).shouldNotHasDuplicatedElement()
        );
    }
}
