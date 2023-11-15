package christmas.domain.benefit;

import java.util.Map;

public class Presents {

    private final Map<String, Long> presents;

    public Presents(Map<String, Long> presents) {
        this.presents = presents;
    }
}
