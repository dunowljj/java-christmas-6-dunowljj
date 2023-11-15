package christmas.domain.order;

import christmas.constants.KindOfMenu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static christmas.constants.KindOfMenu.*;

public enum Menu23_12 implements Menu {

    BUTTON_MUSHROOM_SOUP("양송이수프", "6,000", APPETIZER),
    TAPAS("타파스", "5,500", APPETIZER),
    CAESAR_SALAD("시저샐러드","8,000", APPETIZER),

    T_BORN_STEAK("티본스테이크","55,000",MAIN),
    BARBECUE_RIPS("바비큐립", "54,000", MAIN),
    SEAFOOD_PASTA("해산물파스타", "35,000", MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", "25,000", MAIN),

    CHOCOLATE_CAKE("초코케이크","15,000", DESSERT),
    ICE_CREAM("아이스크림","5,000", DESSERT),

    ZERO_COKE("제로콜라","3,000", DRINK),
    RED_WINE("레드와인","60,000",DRINK),
    CHAMPAGNE("샴페인","25,000",DRINK),
    ;

    private static final String DELIMITER = ",";
    private static final String EMPTY = "";
    private static final String IS_NOT_EXIST_MENU = "존재하지 않는 메뉴입니다.";

    private final String name;
    private final String price;
    private final KindOfMenu kindOfMenu;

    private static final Map<String, Menu> NAME_DICTIONARY = new HashMap<>();

    static {
        Arrays.stream(values())
                .forEach((menu) -> NAME_DICTIONARY.put(menu.name, menu));
    }

    Menu23_12(String name, String price, KindOfMenu kindOfMenu) {
        this.name = name;
        this.price = price;
        this.kindOfMenu = kindOfMenu;
    }

    public static Menu from(String name) {
        if (NAME_DICTIONARY.containsKey(name)) {
            return NAME_DICTIONARY.get(name);
        }

        throw new IllegalArgumentException(IS_NOT_EXIST_MENU);
    }

    @Override
    public boolean isDessert() {
        return this.kindOfMenu == DESSERT;
    }

    @Override
    public boolean isMainMenu() {
        return this.kindOfMenu == MAIN;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumericPrice() {
        return Integer.parseInt(price.replace(DELIMITER, EMPTY));
    }

    @Override
    public String getPrice() {
        return price;
    }
    @Override
    public KindOfMenu getKindOfMenu() {
        return kindOfMenu;
    }

}
