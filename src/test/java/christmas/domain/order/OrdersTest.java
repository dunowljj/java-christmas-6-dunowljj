package christmas.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrdersTest {

    @Test
    public void Orders_생성_및_getter() throws Exception {
        //given
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        List<Order> givenOrders = List.of(new Order("티본스테이크-1"), new Order("바비큐립-1"), new Order("초코케이크-2"), new Order("제로콜라-1"));

        //when
        Orders orders = new Orders(input);

        //then
        assertThat(orders.getOrders()).containsAll(givenOrders);
    }

    @DisplayName("Orders 생성 예외 : 공백 불가, 공백 포함 불가, 양 끝 쉼표 불가, 메뉴 중복 불가")
    @ParameterizedTest
    @ValueSource(strings = {" \n", "티본스테이 크-1", ",티본스테이크-1", "티본스테이크-1,", "티본스테이크-1"})
    public void Orders_생성_예외(String wrongOrder) throws Exception {
        //given
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1" + wrongOrder;

        //when, then
        assertThatThrownBy(() -> new Orders(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
