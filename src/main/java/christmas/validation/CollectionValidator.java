package christmas.validation;

import java.util.Collection;
import java.util.HashSet;

public class CollectionValidator {

    public static final String DUPLICATED_ELEMENT_EXIST = "중복된 요소가 존재합니다.";
    private final Collection<?> collection;

    public CollectionValidator(Collection<?> collection) {
        this.collection = collection;
    }

    public static CollectionValidator that(Collection<?> value) {
        return new CollectionValidator(value);
    }

    public CollectionValidator shouldNotHasDuplicatedElement() {
        if (collection.size() != new HashSet<>(collection).size()) {
            throw new IllegalArgumentException(DUPLICATED_ELEMENT_EXIST);
        }
        return this;
    }
}
