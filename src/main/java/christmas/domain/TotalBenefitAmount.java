package christmas.domain;

public class TotalBenefitAmount {

    private final long totalPrice;

    public TotalBenefitAmount(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isMoreThan(long price) {
        return totalPrice >= price;
    }

    public long getValue() {
        return totalPrice;
    }
}
