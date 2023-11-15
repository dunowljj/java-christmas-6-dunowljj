package christmas.policy;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Present;
import christmas.domain.benefit.Presents;
import christmas.domain.order.Menu;
import christmas.domain.order.Menu23_12;
import christmas.domain.policy.present.ChristmasChampagnePresentPolicy;
import christmas.domain.policy.present.EventTotalAmountPresentPolicyManager;
import christmas.testutil.Reflector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EventPresentPolicyManagerTest {

    private EventTotalAmountPresentPolicyManager presentPolicyManager;

    @BeforeEach
    public void setUp() {
        presentPolicyManager = new EventTotalAmountPresentPolicyManager(List.of());
    }

    @Test
    public void 샴페인_정책_실행시_금액에_도달하면_샴페인이_선물에_담긴다() throws Exception {
        //given
        TotalOrderAmount totalOrderAmount = new TotalOrderAmount(12_0000);
        ChristmasChampagnePresentPolicy policy = new ChristmasChampagnePresentPolicy();

        // when
        Presents presents = policy.findPresents(totalOrderAmount);

        List<Present> values = (List<Present>) (Reflector.getValue(presents, 0));
        Present present = values.get(0);
        Menu menu = (Menu) (Reflector.getValue(present, 0));

        //then
        assertThat(menu).isEqualTo(Menu23_12.CHAMPAGNE);
    }

    @Test
    public void 샴페인_정책_실행시_샴페인이_담기지_않는다() throws Exception {
        //given
        TotalOrderAmount totalOrderAmount = new TotalOrderAmount(119_999);
        ChristmasChampagnePresentPolicy policy = new ChristmasChampagnePresentPolicy();

        // when
        Presents presents = policy.findPresents(totalOrderAmount);
        List<Present> values = (List<Present>) (Reflector.getValue(presents, 0));

        //then
        assertThat(values).isEmpty();
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
