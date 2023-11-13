package christmas;

import christmas.config.PlannerConfig;
import christmas.controller.PlannerController;

public class Application {
    public static void main(String[] args) {
        PlannerConfig plannerConfig = new PlannerConfig();
        PlannerController controller = new PlannerController(plannerConfig);
        controller.execute();
    }
}
