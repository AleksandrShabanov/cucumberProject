package org.cucumber.pages;


import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAppPage extends BasicPage {

    @FindBy(linkText = ADD_NEW_APP_LINK)
    private WebElement addNewApp;

//    public NewAppPage newAppPage() {
//        Log4j2Manager.info("===============" + "newAppPage method: Start" + "===============");
//        addNewApp.click();
//        Log4j2Manager.info("===============" + "newAppPage method: End" + "===============");
//        return initPage(NewAppPage.class);
//    }

    public static final String ADD_NEW_APP_LINK = "Click to add new application";

    public MyAppPage(WebDriver driver) {
        super(driver);
    }
}
