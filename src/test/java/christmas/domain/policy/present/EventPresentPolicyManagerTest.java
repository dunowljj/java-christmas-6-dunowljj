package christmas.domain.policy.present;

import christmas.domain.TotalOrderAmount;
import christmas.domain.benefit.Present;
import christmas.domain.benefit.Presents;
import christmas.domain.order.Menu;
import christmas.domain.order.Menu23_12;
import christmas.testutil.Reflector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventPresentPolicyManagerTest {

    private EventTotalAmountPresentPolicyManager presentPolicyManager;

    @BeforeEach
    public void setUp() {
        presentPolicyManager = new EventTotalAmountPresentPolicyManager(List.of());
    }

    @Test
    public void 샴페인_선물매니저_주입_후_실행시_샴페인이_선물에_담긴다() throws Exception {
        //given
        TotalOrderAmount totalOrderAmount = new TotalOrderAmount(12_0000);
        presentPolicyManager.addPolicy(new ChristmasChampagnePresentPolicy());

        //when
        Presents presents = presentPolicyManager.applyAll(totalOrderAmount);
        List<Present> list = (List<Present>) (Reflector.getValue(presents, 0));

        Menu menu = (Menu) (Reflector.getValue(list.get(0), 0));

        //then
        assertThat(menu).isEqualTo(Menu23_12.CHAMPAGNE);
    }
}
