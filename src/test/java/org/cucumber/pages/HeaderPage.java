package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
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
        myAppLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        myAppLink.click();
        return new MyAppPage(driver);
    }

    public AjaxPage getAjaxPage(String link) {
        ajaxLink =  driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        ajaxLink.click();
        return new AjaxPage(driver);
    }

    public JsPage getJsPage(String link) {
        jsLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        jsLink.click();
        return new JsPage(driver);
    }
}