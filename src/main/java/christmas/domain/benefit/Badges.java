package christmas.domain.benefit;

import christmas.domain.policy.badge.Badge;

import java.util.List;
import java.util.stream.Stream;

public class Badges {

    private final List<Badge> badges;

    public Badges(List<Badge> badges) {
        this.badges = badges;
    }

    public Stream<Badge> stream() {
        return badges.stream();
    }
}
