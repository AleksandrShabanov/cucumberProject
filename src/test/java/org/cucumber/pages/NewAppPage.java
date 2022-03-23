package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class NewAppPage extends BasicPage {

    @FindBy(tagName = TITLE_NAME_TAG_NAME)
    private WebElement titleName;
    @FindBy(xpath = TITLE_TEXT_FIELD_XPATH)
    private WebElement titleTextField;
    @FindBy(xpath = TEXT_AREA_XPATH)
    private WebElement textAreaDescription;
    private WebElement createButton;
    @FindBy(xpath = ADD_IMAGE_BUTTON_XPATH)
    private WebElement addImageButton;
    @FindBy(xpath = ADD_ICON_BUTTON_XPATH)
    private WebElement addIconButton;
    private File file = new File("src/test/resources/files/XwingHeroHome-SW.jpg");
    WebDriver driver;

    public WebElement getTitleName() {
        return titleName;
    }

    public NewAppPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void assertTitle() {
//        (titleName.equals("New application"));
//    }

    public void createNewApp(String name, String descr) {
        Log4j2Manager.info("===============" + "createNewApp method: Start" + "===============");
        titleTextField.sendKeys(name);
        textAreaDescription.sendKeys(descr);
        Log4j2Manager.info("===============" + "createNewApp method: End" + "===============");
    }

    public HomePage clickCreateButton(String button) {
        createButton = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_BUTTON.getText(), button)));
        createButton.click();
        return new HomePage(driver);
    }

    public void addImage() {
        addImageButton.sendKeys(file.getAbsolutePath());
    }

    public void addIcon() {
        addIconButton.sendKeys(file.getAbsolutePath());
    }

//    public MyAppPage createNewAppWithImage() {
//        Log4j2Manager.info("===============" + "createNewAppWithImage method: Start" + "===============");
//        titleTextField.sendKeys("newAppWithImage_AVS");
//        textAreaDescription.sendKeys("This is a new application with image and icon");
//        addImageButton.sendKeys(file.getAbsolutePath());
//        addIconButton.sendKeys(file.getAbsolutePath());
//        createButton.click();
//        Log4j2Manager.info("===============" + "createNewAppWithImage method: End" + "===============");
//        return initPage(MyAppPage.class);
//    }

    private static final String TITLE_NAME_TAG_NAME = "h1";
    private static final String TITLE_TEXT_FIELD_XPATH = "//input[@name='title']";
    private static final String TEXT_AREA_XPATH = "//textarea[@name='description']";
//    private static final String CREATE_BUTTON_XPATH = "//input[@type='submit']";
    private static final String ADD_IMAGE_BUTTON_XPATH = "//input[@name='image']";
    private static final String ADD_ICON_BUTTON_XPATH = "//input[@name='icon']";

}
