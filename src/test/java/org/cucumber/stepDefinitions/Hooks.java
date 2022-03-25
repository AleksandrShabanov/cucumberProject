package org.cucumber.stepDefinitions;

import io.cucumber.java.*;
import org.cucumber.framework.Settings;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private  static WebDriver driver;
    private static Settings settings = new Settings();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before(order = 10)
    public static void openBrowser() {
        driver = settings.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.navigate().to(settings.getUrl());
    }

    @After
    public static void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
