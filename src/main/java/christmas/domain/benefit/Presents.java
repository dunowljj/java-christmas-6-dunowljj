package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Presents {

    private final List<Present> presents;

    public Presents() {
        this.presents = new ArrayList<>();
    }

    public Presents(List<Present> presents) {
        this.presents = presents;
    }

    public void add(Present present) {
        presents.add(present);
    }

    public Stream<Present> stream() {
        return presents.stream();
    }

    public long getBenefitPrice() {
        return presents.stream()
                .map(present -> present.getBenefitPrice())
                .reduce(Long::sum)
                .orElse(0L);
    }

    public boolean isEmpty() {
        return presents.isEmpty();
    }


//    public List<Present> getPresents() {
//        return presents;
//    }
}
