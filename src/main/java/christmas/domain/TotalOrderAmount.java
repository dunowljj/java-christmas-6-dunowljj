package christmas.domain;

import static christmas.view.util.FormatUtils.toKoreaMoneyFormat;

public class TotalOrderAmount {

    private final long totalPrice;

    public TotalOrderAmount(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isMoreThan(long price) {
        return totalPrice >= price;
    }

    @Override
    public String toString() {
        String moneyFormat = toKoreaMoneyFormat(totalPrice);
        return String.format("%s원", moneyFormat);
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}
