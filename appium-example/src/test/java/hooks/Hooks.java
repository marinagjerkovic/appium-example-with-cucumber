package hooks;

import helpers.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Optional;

public class Hooks extends BaseSteps {

    public Hooks(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @BeforeAll
    public static void beforeAll() {
        CommonProperties.env = Optional.ofNullable(System.getProperty("env")).orElse("dev");
        CommonProperties.platform = Optional.ofNullable(System.getProperty("platform")).orElse("android");

        LocalDateTime date = LocalDateTime.now();
        CommonProperties.buildName = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        scenarioContext.driver = DriverInitializer.initializeDriver(scenario.getName());
        scenarioContext.wait = new WebDriverWait(scenarioContext.driver, Duration.ofSeconds(5));
        scenarioContext.driverHelpers = new DriverHelpers(scenarioContext.driver, scenarioContext.wait);
        scenarioContext.pagesProvider = new PagesProvider(scenarioContext.driverHelpers);
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenarioContext.driver != null) {
            if (scenario.isFailed()) {
                scenarioContext.driverHelpers.saveScreenshotAllure(scenario.getName());
            }
            scenarioContext.driver.quit();
        }
    }
}
