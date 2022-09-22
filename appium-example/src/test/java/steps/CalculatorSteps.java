package steps;

import helpers.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class CalculatorSteps extends BaseSteps{
    public CalculatorSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @When("user clicks number {int}")
    public void userClicksNumber(int number) {
        scenarioContext.pagesProvider.getCalculatorPage().clickNumber(number);
    }

    @When("user clicks button plus")
    public void userClicksButtonPlus() {
        scenarioContext.pagesProvider.getCalculatorPage().clickButtonPlus();
    }

    @Then("verify number {int} is displayed in result field")
    public void verifyNumberIsDisplayedInResultField(int number) {
        assertEquals(scenarioContext.pagesProvider.getCalculatorPage().getResult().getText(), number + "");
    }
}
