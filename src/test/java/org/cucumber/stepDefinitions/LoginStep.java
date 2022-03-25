package org.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.pages.BasicPage;
import org.cucumber.pages.HeaderPage;
import org.cucumber.pages.HomePage;
import org.cucumber.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    private WebDriver driver;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private BasicPage basicPage;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = Hooks.getDriver();
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver, "Logout");
        headerPage = new HeaderPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("type to input with name {string} text: {string}")
    public void enterData(String id, String data) {
        loginPage.enterData(id, data);
    }

    @When("user clicks on {string} button")
    public void clicksOnLoginButton(String button) {
        loginPage.clickLoginButton(button);
    }

    @Then("^check valid login using fName '(.*)' and lName '(.*)'$")
    public void userIsNavigatedToTheHomePage(String fName, String lName) {
        Assert.assertTrue(headerPage.getWelcomeMessage().equals(headerPage.getWelcomeUserName(fName, lName)));
    }

    @Then("^check invalid login using string '(.*)'$")
    public void checkInvalidLogin(String string) {
        Assert.assertTrue(basicPage.getFlashMessage().equals(string));
    }
}
