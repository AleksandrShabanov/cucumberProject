package org.cucumber.stepDefinitions;

import io.cucumber.java.*;
import org.cucumber.framework.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private static RemoteWebDriver driver;
    private static Settings settings = new Settings();

    public static RemoteWebDriver getDriver() {
        return driver;
    }

    @Before(order = 10)
    public static void openBrowser() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "98.0");
        Map<String, Object> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", false);
        options.put("enableLog", true);
        capabilities.setCapability("selenoid:options", options);
        driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
        driver.setFileDetector(new LocalFileDetector());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(settings.getUrl());
    }

    @After
    public static void closeBrowser() {
        if (driver != null ) {
            driver.quit();
        }
    }
}
