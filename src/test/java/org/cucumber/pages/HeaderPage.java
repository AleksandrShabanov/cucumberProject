package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasicPage {

    private WebElement myAppLink;
    private WebElement ajaxLink;
    private WebElement jsLink;
    private WebDriver driver;

    public HeaderPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.cssSelector(".welcome")).getText();
    }

    public String getWelcomeUserName(String fName, String lName) {
        return "Welcome " + fName + " " + lName;
    }

    public WebElement getMyAppLink() {
        return myAppLink;
    }

    public MyAppPage getMyAppPage(String link) {
        Log4j2Manager.info("===============" + "getMyAppPage method: Start" + "===============");
        myAppLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        myAppLink.click();
        Log4j2Manager.info("===============" + "getMyAppPage method: End" + "===============");
        return new MyAppPage(driver);
    }

    public AjaxPage getAjaxPage(String link) {
        Log4j2Manager.info("===============" + "getAjaxPage method: Start" + "===============");
        ajaxLink =  driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        ajaxLink.click();
        Log4j2Manager.info("===============" + "getAjaxPage method: End" + "===============");
        return new AjaxPage(driver);
    }

    public JsPage getJsPage(String link) {
        Log4j2Manager.info("===============" + "getJsPage method: Start" + "===============");
        jsLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        jsLink.click();
        Log4j2Manager.info("===============" + "getJsPage method: End" + "===============");
        return new JsPage(driver);
    }
}