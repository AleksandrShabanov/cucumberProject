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
    private WebElement addButton;
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

    public void add(String name) {
        addButton = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_BUTTON_NAME.getText(), name)));
        addButton.sendKeys(file.getAbsolutePath());
    }

    private static final String TITLE_NAME_TAG_NAME = "h1";
    private static final String TITLE_TEXT_FIELD_XPATH = "//input[@name='title']";
    private static final String TEXT_AREA_XPATH = "//textarea[@name='description']";

}
