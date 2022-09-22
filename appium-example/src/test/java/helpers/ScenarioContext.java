package helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScenarioContext {
    public AppiumDriver driver;
    public WebDriverWait wait;
    public PagesProvider pagesProvider;
    public DriverHelpers driverHelpers;
}
