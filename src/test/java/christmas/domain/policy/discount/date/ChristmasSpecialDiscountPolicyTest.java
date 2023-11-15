package christmas.domain.policy.discount.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static christmas.domain.policy.discount.date.ChristmasSpecialDiscountPolicy.DISCOUNT_AMOUNT;
import static christmas.domain.policy.discount.date.ChristmasSpecialDiscountPolicy.SPECIAL_DATES;
import static org.assertj.core.api.Assertions.assertThat;

public class ChristmasSpecialDiscountPolicyTest {

    @Test
    public void 크리스마스_특별할인_적용되면_할인_금액_반환() throws Exception {
        //given
        ChristmasSpecialDiscountPolicy discountPolicy = new ChristmasSpecialDiscountPolicy();

        //when, then
        SPECIAL_DATES.stream()
                .map(discountPolicy::calculateDiscount)
                .forEach((result) -> assertThat(result).isEqualTo(DISCOUNT_AMOUNT));
    }

    @Test
    public void 크리스마스_특별할인_적용안되면_0_반환() throws Exception {
        //given
        ChristmasSpecialDiscountPolicy discountPolicy = new ChristmasSpecialDiscountPolicy();
        List<LocalDate> normalDates = List.of(2, 11, 18, 23, 30)
                .stream()
                .map(ChristmasSpecialDiscountPolicy::dateOf)
                .toList();

        //when, then
        normalDates.stream()
                .map(discountPolicy::calculateDiscount)
                .forEach((result) -> assertThat(result).isEqualTo(0));
    }
}
