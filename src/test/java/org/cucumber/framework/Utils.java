package org.cucumber.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    private static Settings settings = new Settings();

    public static void waitForElementVisible(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static boolean isElementPresent(String xpath, WebDriver driver) {
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public static boolean isElementPresent(By by, WebDriver driver) {
        return driver.findElements(by).size() > 0;
    }

    public static String getText(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

}

