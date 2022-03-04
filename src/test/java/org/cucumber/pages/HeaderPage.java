package org.cucumber.pages;

import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasicPage {

    @FindBy(linkText = MY_APP_LINK)
    private WebElement myAppLink;
    @FindBy(linkText = AJAX_LINK)
    private WebElement ajaxLink;
    @FindBy(linkText = JS_LINK)
    private WebElement jsLink;
    @FindBy(linkText = HOME_LINK)
    private WebElement homeLink;

    WebDriver driver;

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

    public MyAppPage getMyAppPage() {
        Log4j2Manager.info("===============" + "getMyAppPage method: Start" + "===============");
        myAppLink.click();
        Log4j2Manager.info("===============" + "getMyAppPage method: End" + "===============");
        return new MyAppPage(driver);
    }
//
//    public AjaxPage getAjaxPage() {
//        Log4j2Manager.info("===============" + "getAjaxPage method: Start" + "===============");
//        ajaxLink.click();
//        Log4j2Manager.info("===============" + "getAjaxPage method: End" + "===============");
//        return initPage(AjaxPage.class);
//    }
//
//    public JsPage getJsPage() {
//        Log4j2Manager.info("===============" + "getJsPage method: Start" + "===============");
//        jsLink.click();
//        Log4j2Manager.info("===============" + "getJsPage method: End" + "===============");
//        return initPage(JsPage.class);
//    }

    private static final String MY_APP_LINK = "My applications";
    private static final String AJAX_LINK = "Ajax test page";
    private static final String JS_LINK = "JS test page";
    private static final String HOME_LINK = "Home";
}