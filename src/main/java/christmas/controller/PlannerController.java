package christmas.controller;

import christmas.config.PlannerConfig;
import christmas.domain.planner.EventPlanner;

public class PlannerController {

    private final EventPlanner eventPlanner;
    public PlannerController(PlannerConfig config) {
        this.eventPlanner = config.injectPlanner();
    }

    public void execute() {
        eventPlanner.makePlan();
    }
}
