package christmas.domain.policy.badge;

public enum Badge {

    STAR("별", 20_000),
    TREE("트리",10_000),
    SANTA("산타", 5_000),
    NONE("없음", 0),
    ;

    private final long threshold;
    private final String name;

    Badge(String name, long threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public long getThreshold() {
        return threshold;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
