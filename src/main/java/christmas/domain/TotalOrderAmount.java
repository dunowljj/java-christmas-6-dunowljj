package christmas.domain;

public class TotalOrderAmount {

    private final long totalPrice;

    public TotalOrderAmount(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isMoreThan(long price) {
        return totalPrice >= price;
    }
}
