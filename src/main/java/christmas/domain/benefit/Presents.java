package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.List;

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

//    public List<Present> getPresents() {
//        return presents;
//    }
}
