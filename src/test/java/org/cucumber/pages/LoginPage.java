package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasicPage {

    @FindBy(id = USER_NAME_TEXT_FIELD_ID)
    private WebElement userNameTextField;
    @FindBy(id = USER_PASSWORD_TEXT_FIELD_ID)
    private WebElement passwordTextField;
    private WebElement loginButton;
    private WebElement registerLink;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLogin(String username) { userNameTextField.sendKeys(username); }

    public void enterPassword(String password) {
        passwordTextField.sendKeys(password);
    }

    public HomePage clickLoginButton(String button) {
        loginButton = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_BUTTON.getText(), button)));
        loginButton.click();
        return new HomePage(driver);
    }

    public RegistrationPage getRegistrationPage(String link) {
        Log4j2Manager.info("===============" + "getRegistrationPage method: Start" + "===============");
        registerLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        registerLink.click();
        Log4j2Manager.info("===============" + "getRegistrationPage method: End" + "===============");
        return new RegistrationPage(driver);
    }

    private static final String USER_NAME_TEXT_FIELD_ID = "j_username";
    private static final String USER_PASSWORD_TEXT_FIELD_ID = "j_password";
}
