package christmas.domain.policy.discount.date;

import christmas.domain.order.Orders;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static christmas.constants.Planner23_12Config.THIS_MONTH;
import static christmas.constants.Planner23_12Config.THIS_YEAR;
import static christmas.domain.policy.discount.date.ChristmasWeekDayDiscountPolicy.DISCOUNT_PER_DESSERT_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

public class ChristmasWeekDayDiscountPolicyTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7})
    public void 크리스마스_평일이면_할인_적용으로_디저트당_2023원_할인_금액_반환(int weekDay) throws Exception {
        //given
        LocalDate date = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), weekDay);

        // 디저트 2개
        long actualResult = DISCOUNT_PER_DESSERT_COUNT * 2;
        Orders orders = new Orders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        //when
        ChristmasWeekDayDiscountPolicy discountPolicy = new ChristmasWeekDayDiscountPolicy();
        Long result = discountPolicy.calculateDiscount(orders, date);

        // then
        assertThat(result).isEqualTo(actualResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 29, 30})
    public void 크리스마스_주말이면_할인_적용안되므로_디저트당_0원_반환(int weekend) throws Exception {
        //given
        LocalDate date = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), weekend);

        // 디저트 2개
        long actualResult = DISCOUNT_PER_DESSERT_COUNT * 2;
        Orders orders = new Orders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        //when
        ChristmasWeekDayDiscountPolicy discountPolicy = new ChristmasWeekDayDiscountPolicy();
        Long result = discountPolicy.calculateDiscount(orders, date);

        // then
        assertThat(result).isEqualTo(0);
    }
}
