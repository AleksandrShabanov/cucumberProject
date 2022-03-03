package org.cucumber.pages;

import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasicPage {

    @FindBy(id = USER_NAME_TEXT_FIELD_ID)
    private WebElement userNameTextField;
    @FindBy(id = USER_PASSWORD_TEXT_FIELD_ID)
    private WebElement passwordTextField;
    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;
    @FindBy(xpath = REGISTER_TEXT)
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

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }

//    public HomePage loginAs(User user) {
//        Log4j2Manager.info("===============" + "loginAs method: Start" + "===============");
//        if (settings.getUrl().equals(false)) {
//            driver.get(settings.getUrl());
//        } else {
//            userNameTextField.clear();
//            passwordTextField.clear();
//            userNameTextField.sendKeys(user.getUsername());
//            passwordTextField.sendKeys(user.getPassword());
//            loginButton.click();
//        }
//        Log4j2Manager.info("===============" + "loginAs method: End" + "===============");
//        return initPage(HomePage.class);
//    }
//
//
    public RegistrationPage getRegistrationPage() {
        Log4j2Manager.info("===============" + "getRegistrationPage method: Start" + "===============");
        registerLink.click();
        Log4j2Manager.info("===============" + "getRegistrationPage method: End" + "===============");
        return new RegistrationPage(driver);
    }

    private static final String USER_NAME_TEXT_FIELD_ID = "j_username";
    private static final String USER_PASSWORD_TEXT_FIELD_ID = "j_password";
    private static final String LOGIN_BUTTON_XPATH = "//input[@value='Login']";
    private static final String REGISTER_TEXT = "//a[text()[contains(.,\"Register\")]]";
}
