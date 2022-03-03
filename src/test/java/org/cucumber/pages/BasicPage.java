package org.cucumber.pages;

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

    public BasicPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasicPage() {

    }

    //    public LoginPage forceLogout() {
//        driver.get(settings.getUrl());
//        if (isElementPresent(logoutBy)) {
//            driver.findElement(logoutBy).click();
//        }
//        return initPage(LoginPage.class);
//    }
//
    public String getFlashMessage() {
        if (isElementPresent(flash)) {
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
