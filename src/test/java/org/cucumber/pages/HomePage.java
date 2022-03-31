package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.cucumber.framework.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasicPage {

    @FindBy(xpath = MY_APP_POPULAR_XPATH)
    private WebElement myAppPopular;
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

    public WebElement isMyAppPopular() {
        Utils.waitForElementVisible(driver, myAppPopular);
        myAppPopular.click();
        return myAppPopular;
    }

    public DetailsPage getDetailsPage(String link) {
        detailsLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        detailsLink.click();
        return new DetailsPage(driver);
    }

    public DetailsPage getNewAppDetailsPage() {
        newAppDetailsLink.click();
        return new DetailsPage(driver);
    }

    private static final String MY_APP_POPULAR_XPATH = "//div[@class=\"popular-app\"]//child::a[@href=\"/app?title=newAppAVS123\"]";
    private static final String NEW_APP_DETAILS_LINK = "//a[@href='/app?title=newAppAVS123']";
    private static final String NEW_APP_ELEMENT_XPATH = "//div[@class='name' and contains(text(),'newAppAVS')]";
    private static final String NEW_APP_ELEMENT_WITH_IMAGE_XPATH = "//div[@class='name' and contains(text(),'newAppWithImage_AVS')]";

}
