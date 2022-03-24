package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyAppPage extends BasicPage {
    private WebElement addNewApp;

    WebDriver driver;

    public MyAppPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewAppPage getNewAppPage(String link) {
        Log4j2Manager.info("===============" + "newAppPage method: Start" + "===============");
        addNewApp = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        addNewApp.click();
        Log4j2Manager.info("===============" + "newAppPage method: End" + "===============");
        return new NewAppPage(driver);
    }

}
