package org.cucumber.pages;

import org.cucumber.framework.LocatorsEnum;
import org.cucumber.framework.Log4j2Manager;
import org.cucumber.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasicPage {

//    @FindBy(name = NAME_TEXT_FIELD_NAME)
//    private WebElement nameTextField;
//    @FindBy(name = FIRST_NAME_TEXT_FIELD_NAME)
//    private WebElement firstNameTextField;
//    @FindBy(name = LAST_NAME_TEXT_FIELD_NAME)
//    private WebElement lastNameTextField;
//    @FindBy(name = PASSWORD_TEXT_FIELD_NAME)
//    private WebElement passwordTextFiled;
//    @FindBy(name = CONFIRM_PASSWORD_TEXT_FIELD_NAME)
//    private WebElement confirmPasswordTextField;
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
//    public void registerUser(User user) {
//        Log4j2Manager.info("===============" + "registerUser method: Start" + "===============");
//        nameTextField.sendKeys(user.getUsername());
//        firstNameTextField.sendKeys(user.getFname());
//        lastNameTextField.sendKeys(user.getLname());
//        passwordTextFiled.sendKeys(user.getPassword());
//        confirmPasswordTextField.sendKeys(user.getPassword());
//        new Select(userRoleSelector).selectByVisibleText(user.getRole());
//        Log4j2Manager.info("===============" + "registerUser method: End" + "===============");
//    }

    public HomePage clickOnRegister(String button) {
        Log4j2Manager.info("===============" + "clickOnRegister method: Start" + "===============");
        registerButton = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_BUTTON.getText(), button)));
        registerButton.click();
        Log4j2Manager.info("===============" + "clickOnRegister method: End" + "===============");
        return new HomePage(driver);
    }

//    private static final String NAME_TEXT_FIELD_NAME = "name";
//    private static final String FIRST_NAME_TEXT_FIELD_NAME = "fname";
//    private static final String LAST_NAME_TEXT_FIELD_NAME = "lname";
//    private static final String PASSWORD_TEXT_FIELD_NAME = "password";
//    private static final String CONFIRM_PASSWORD_TEXT_FIELD_NAME = "passwordConfirm";
    private static final String DROPDOWN_XPATH = "//select[@name='role']";
//    private static final String REGISTER_BUTTON_XPATH = "//input[@value='Register']";

}
