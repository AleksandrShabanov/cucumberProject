package org.cucumber.pages;

import org.cucumber.framework.Settings;
import org.cucumber.framework.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.cucumber.framework.Utils.isElementPresent;

public class BasicPage {

    private final static By logoutBy = By.xpath("//a[contains(text(), 'Logout')]");
    private final static By flash = By.cssSelector("p.flash");

    private WebDriver driver;
    Settings settings = new Settings();

    public BasicPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasicPage() {

    }

        public LoginPage forceLogout() {
        driver.get(settings.getUrl());
        if (isElementPresent(logoutBy, driver)) {
            driver.findElement(logoutBy).click();
        }
        return new LoginPage(driver);
    }

    public String getFlashMessage() {
        if (Utils.isElementPresent(flash, driver)) {
            return driver.findElement(flash).getText();
        }
        return null;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
