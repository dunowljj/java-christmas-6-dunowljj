package christmas.constants;

public enum Planner23_12Config {
    MONTH_START_DAY(1),
    MONTH_END_DAY(31),
    THIS_MONTH(12),
    THIS_YEAR(2023),
    ;

    private final int value;

    Planner23_12Config(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
