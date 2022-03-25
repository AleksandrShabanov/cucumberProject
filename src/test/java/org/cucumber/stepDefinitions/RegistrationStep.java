package org.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegistrationStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private BasicPage basicPage;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private MyAppPage myAppPage;
    private NewAppPage newAppPage;

    @Before
    public void setUp() {
        driver = Hooks.getDriver();
        headerPage = new HeaderPage(driver);
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver, "Logout");
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        myAppPage = new MyAppPage(driver);
        newAppPage = new NewAppPage(driver);
    }

    @Given("user is on login page clicks on {string} link")
    public void userClicksOnRegisterLink(String registerLink) {
        loginPage.getRegistrationPage(registerLink);
    }

    @And("^user enters his data to ([^\"]*) and type([^\"]*)$")
    public void theUserEntersHisDataToTextFieldAndTypeText(String textFiled, String text, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            registrationPage.enterTextData(entry.getKey(), entry.getValue());
        }
    }

    @When("set {string} role")
    public void setUserRole(String role) {
        registrationPage.setUserRoleSelector(role);
    }

    @When("user clicks on {string}")
    public void userClicksOnRegisterButton(String button) {
        registrationPage.clickOnRegister(button);
        System.out.println("user clicks on register button");
    }

    @Then("verify that the user with name {string} and last name {string} is logged in")
    public void verifyThatTheUserIsLoggedIn(String fName, String lName) {
        Assert.assertEquals(headerPage.getWelcomeMessage(), headerPage.getWelcomeUserName(fName, lName));
    }

    @When("user {string}")
    public void userLogout(String logout) {
        basicPage.forceLogout(driver, logout);
    }

    @Then("click on {string} and {string} and verify upload {string}")
    public void verifyThatTheDeveloperCanOpenThePageToUploadAnApp(String myAppLink, String newAppLink, String string) throws InterruptedException {
        headerPage.getMyAppPage(myAppLink);
        myAppPage.getNewAppPage(newAppLink);
        Assert.assertEquals(newAppPage.getTitleName().getText(), string);
    }

    @Then("verify that the user can see the app but cannot upload them")
    public void verifyThatTheUserCanSeeTheAppButCannotUploadThem() {
        Assert.assertFalse(basicPage.isElementDisplayed(headerPage.getMyAppLink()));
    }
}
