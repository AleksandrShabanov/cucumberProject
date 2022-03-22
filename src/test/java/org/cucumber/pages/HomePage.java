package org.cucumber.pages;

import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasicPage {

    @FindBy(xpath = MY_APP_POPULAR_XPATH)
    private WebElement myAppPopular;
    @FindBy(linkText = DETAILS_LINK)
    private WebElement detailsLink;
    @FindBy(xpath = NEW_APP_DETAILS_LINK)
    private WebElement newAppDetailsLink;
    @FindBy(xpath = NEW_APP_ELEMENT_XPATH)
    private WebElement newAppElement;
    @FindBy(xpath = NEW_APP_ELEMENT_WITH_IMAGE_XPATH)
    private WebElement newAppWithImage;
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getNewAppElement() {
        return newAppElement;
    }
    public WebElement getNewAppWithImage() {
        return newAppWithImage;
    }

//    public HeaderPage getHeader() {
//        return initPage(HeaderPage.class);
//    }
//
//    public WebElement isMyAppPopular() {
//        Log4j2Manager.info("===============" + "isMyAppPopular method: Start" + "===============");
//        myAppPopular.click();
//        Log4j2Manager.info("===============" + "isMyAppPopular method: End" + "===============");
//        return myAppPopular;
//    }
//
    public DetailsPage getDetailsPage() {
        Log4j2Manager.info("===============" + "getDetailsPage method: Start" + "===============");
        detailsLink.click();
        Log4j2Manager.info("===============" + "getDetailsPage method: End" + "===============");
        return new DetailsPage(driver);
    }
//
//    public DetailsPage getNewAppDetailsPage() {
//        Log4j2Manager.info("===============" + "getNewAppDetailsPage method: Start" + "===============");
//        newAppDetailsLink.click();
//        Log4j2Manager.info("===============" + "getNewAppDetailsPage method: End" + "===============");
//        return initPage(DetailsPage.class);
//    }

    private static final String MY_APP_POPULAR_XPATH = "//div[@class=\"popular-app\"]//child::a[@href=\"/app?title=newAppAVS123\"]";
    private static final String DETAILS_LINK = "Details";
    private static final String NEW_APP_DETAILS_LINK = "//a[@href='/app?title=newAppAVS123']";
    private static final String NEW_APP_ELEMENT_XPATH = "//div[@class='name' and contains(text(),'newAppAVS')]";
    private static final String NEW_APP_ELEMENT_WITH_IMAGE_XPATH = "//div[@class='name' and contains(text(),'newAppWithImage_AVS')]";

}
