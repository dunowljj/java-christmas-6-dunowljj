package christmas.domain.benefit;

import christmas.domain.policy.present.EventTotalAmountPresentPolicy;

import java.util.Objects;

import static christmas.view.util.FormatUtils.toKoreaMoneyFormat;

public record Discount(String name, long amount) {

    public boolean isApplied() {
        return amount != 0L;
    }

    public boolean isPresentEvent() {
        return this.name.equals(EventTotalAmountPresentPolicy.NAME);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount discount)) return false;

        if (amount != discount.amount) return false;
        return Objects.equals(name, discount.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: -%s원", name, toKoreaMoneyFormat(amount));
    }
}
