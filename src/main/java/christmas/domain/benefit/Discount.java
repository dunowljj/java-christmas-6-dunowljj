package christmas.domain.benefit;

import java.util.Objects;

public record Discount(String name, long amount) {

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
        return String.format("%s: -%d원", name, amount);
    }

    public boolean isApplied() {
        return amount != 0L;
    }

}
