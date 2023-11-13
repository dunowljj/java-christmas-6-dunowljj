package christmas.controller;

import christmas.config.PlannerConfig;
import christmas.domain.planner.EventPlanner;

public class PlannerController {

    private final EventPlanner eventPlanner;

    public PlannerController(PlannerConfig plannerConfig) {
        this.eventPlanner = plannerConfig.getEventPlanner();
    }

    public void execute() {
        eventPlanner.makePlan();
    }
}
