package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasicPage {

    private WebElement textField;
    private WebElement loginButton;
    private WebElement registerLink;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterData(String id, String data) {
        textField = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_TEXT_FIELD_ID.getText(), id)));
        textField.sendKeys(data);
    }

    public HomePage clickLoginButton(String button) {
        loginButton = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_BUTTON.getText(), button)));
        loginButton.click();
        return new HomePage(driver);
    }

    public RegistrationPage getRegistrationPage(String link) {
        registerLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        registerLink.click();
        return new RegistrationPage(driver);
    }
}
