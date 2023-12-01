package christmas.domain.benefit;

import christmas.domain.TotalBenefitAmount;
import christmas.domain.policy.present.EventPresentPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Discounts {
    private final List<Discount> discounts;

    public Discounts() {
        this.discounts = new ArrayList<>();
    }

    public Stream<Discount> stream() {
        return discounts.stream();
    }

    public void addAll(List<Discount> discounts) {
        this.discounts.addAll(discounts);
    }

    public void addPresentDiscount(Presents presents) {
        if (presents.isEmpty()) {
            return;
        }

        discounts.add(new Discount(EventPresentPolicy.NAME, presents.getBenefitPrice()));
    }

    /**
     * 증정 이벤트를 제외한 총 할인 혜택 금액
     */
    public Long getTotalDiscountPrice() {
        return discounts.stream()
                .filter((discount) -> !discount.isPresentEvent())
                .map((Discount::amount))
                .reduce(Long::sum)
                .orElse(0L);
    }

    public TotalBenefitAmount getTotalBenefitAmount() {
        return new TotalBenefitAmount(
                discounts.stream()
                        .map((Discount::amount))
                        .reduce(Long::sum)
                        .orElse(0L)
        );
    }
}
