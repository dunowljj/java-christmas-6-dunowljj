package christmas.domain.order;

public interface MenuFinder {

    static Menu findMenuBy(String key) {
        return Menu23_12.from(key);
    }
}
