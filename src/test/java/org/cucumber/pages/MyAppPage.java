package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyAppPage extends BasicPage {
    private WebElement addNewApp;
    private WebDriver driver;

    public MyAppPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewAppPage getNewAppPage(String link) {
        addNewApp = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        addNewApp.click();
        return new NewAppPage(driver);
    }
}
