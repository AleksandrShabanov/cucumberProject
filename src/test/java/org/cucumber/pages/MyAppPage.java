package org.cucumber.pages;


import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAppPage extends BasicPage {

    @FindBy(linkText = ADD_NEW_APP_LINK)
    private WebElement addNewApp;

    WebDriver driver;

    public MyAppPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewAppPage getNewAppPage() {
        Log4j2Manager.info("===============" + "newAppPage method: Start" + "===============");
        addNewApp.click();
        Log4j2Manager.info("===============" + "newAppPage method: End" + "===============");
        return new NewAppPage(driver);
    }

    public static final String ADD_NEW_APP_LINK = "Click to add new application";

}
