package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasicPage {

    private static final String DROPDOWN_XPATH = "//select[@name='role']";
    private WebElement textFiled;
    @FindBy(xpath = DROPDOWN_XPATH)
    private WebElement userRoleSelector;
    private WebElement registerButton;

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTextData(String fieldName, String text) {
        textFiled = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_TEXT_FIELD_NAME.getText(), fieldName)));
        textFiled.sendKeys(text);
    }

    public void setUserRoleSelector(String role) {
        new Select(userRoleSelector).selectByVisibleText(role);
    }

    public HomePage clickOnRegister(String button) {
        Log4j2Manager.info("===============" + "clickOnRegister method: Start" + "===============");
        registerButton = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_BUTTON.getText(), button)));
        registerButton.click();
        Log4j2Manager.info("===============" + "clickOnRegister method: End" + "===============");
        return new HomePage(driver);
    }
}
