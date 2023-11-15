package christmas.domain.policy.present;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class EventPresentPolicyManagerTest {

    private EventTotalAmountPresentPolicyManager presentPolicyManager;

    @BeforeEach
    public void setUp() {
        presentPolicyManager = new EventTotalAmountPresentPolicyManager(List.of());
    }

//    @Test
//    public void 샴페인_선물매니저_주입_후_실행시_샴페인이_선물에_담긴다() throws Exception {
//        //given
//        TotalOrderAmount totalOrderAmount = new TotalOrderAmount(12_0000);
//        presentPolicyManager.addPolicy(new ChristmasChampagnePresentPolicy());
//
//        //when
//        Presents bunchOfPresents = presentPolicyManager.applyAll(totalOrderAmount);
//        Present present = bunchOfPresents.getPresents().get(0);
//
//        Menu menu = (Menu) (Reflector.getValue(present, 0));
//
//        //then
//        assertThat(menu).isEqualTo(Menu23_12.CHAMPAGNE);
//    }
}
