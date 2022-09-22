package steps;

import helpers.ScenarioContext;

public abstract class BaseSteps {
    public ScenarioContext scenarioContext;

    public BaseSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }
}
