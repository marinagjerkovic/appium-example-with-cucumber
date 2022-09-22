package helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInitializer {

    public static AppiumDriver initializeDriver(String scenarioName) throws MalformedURLException {
        AppiumDriver appiumDriver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", CommonProperties.platform);
        capabilities.setCapability("platformVersion", ""); // add statically some value or if parameter is passed, then it should be System.getProperty("platformVersion")
        capabilities.setCapability("deviceName", ""); // // add statically some value or if parameter is passed, then it should be System.getProperty("deviceName")
        if (CommonProperties.platform.equals("android")) {
            capabilities.setCapability("automationName", "UiAutomator2");

            if (!Boolean.getBoolean("onBrowserstack")) {
                capabilities.setCapability("appPackage", ""); // add app package
                capabilities.setCapability("appActivity", ""); // add app activity

                appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } else {
                capabilities.setCapability("project", "Browserstack Appium");
                capabilities.setCapability("build", CommonProperties.buildName);
                capabilities.setCapability("name", scenarioName);
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", ""); // add url to app which is uploaded to browserstack
                appiumDriver = new AndroidDriver(new URL("http://"+"username"+":"+"accessKey"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities); // add username and access key
            }
        } else {
            capabilities.setCapability("automationName", "XCUITest");

            if (!Boolean.getBoolean("onBrowserstack")) {
                capabilities.setCapability("bundleId", "");
                capabilities.setCapability("udid", "");
            } else {
                // add capability for getting app from browserstack
            }
        }
        return appiumDriver;
    }
}
