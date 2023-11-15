package christmas.domain.policy.present;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Present;
import christmas.domain.benefit.Presents;
import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventTotalAmountPresentPolicyManager extends EventPolicyManager<EventTotalAmountPresentPolicy> {

    public EventTotalAmountPresentPolicyManager(List<EventTotalAmountPresentPolicy> eventPolicies) {
        super(eventPolicies);
    }
//
//    // todo : 확장성 있게 고쳐야함
//    public Presents applyAll(TotalOrderAmount totalOrderAmount) {
//        List<Present> presents = eventPolicies.stream()
//                .flatMap((policy) -> policy.findPresents(totalOrderAmount).getPresents().stream())
//                .toList();
//
//        return new Presents(presents);
//    }
}
