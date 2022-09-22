package pages;

import helpers.DriverHelpers;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.fail;


public class CalculatorPage {
    DriverHelpers driverHelpers;

    public CalculatorPage(DriverHelpers driverHelpers) {
        this.driverHelpers = driverHelpers;
    }

    // locators
    String number1 = "com.android.calculator2:id/digit_1";
    String number2 = "com.android.calculator2:id/digit_2";
    String buttonPlus = "com.android.calculator2:id/op_add";
    String result = "com.android.calculator2:id/result";

    public WebElement getNumber(int number) {
        switch (number) {
            case 1 -> {
                return driverHelpers.getElement(number1);
            }
            case 2 -> {
                return driverHelpers.getElement(number2);
            }
            default -> {
                fail("Number " + number + " does not exist");
                return null;
            }
        }
    }

    public WebElement getButtonPlus() {
        return driverHelpers.getElement(buttonPlus);
    }

    public WebElement getResult() {
        return driverHelpers.getElement(result);
    }

    public void clickNumber(int number) {
        switch (number) {
            case 1 -> driverHelpers.clickElement(number1);
            case 2 -> driverHelpers.clickElement(number2);
        }
    }

    public void clickButtonPlus() {
        driverHelpers.clickElement(buttonPlus);
    }
}
