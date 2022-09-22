package helpers;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.testng.Assert.fail;

public class DriverHelpers {

    AppiumDriver driver;
    WebDriverWait wait;

    public DriverHelpers(AppiumDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getElement(String locator) {
        try {
            return driver.findElement(By.id(locator));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean waitUntilElementDisplayed(String locator) {
        boolean isDisplayed = false;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
            if (element.isDisplayed()) isDisplayed = true;
        } catch (Exception e) {

        }
        return isDisplayed;
    }

    public void clickElement(String locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
            element.click();
        } catch (Exception e) {
            fail("Element with locator " + locator + " is not clickable");
        }
    }

    public void saveScreenshotAllure(String scenarioName) throws IOException {
        Allure.addAttachment(scenarioName, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }

}
