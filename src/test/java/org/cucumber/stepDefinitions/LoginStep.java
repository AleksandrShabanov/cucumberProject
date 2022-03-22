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
    WebDriver driver;
    LoginPage loginPage;
    HeaderPage headerPage;
    BasicPage basicPage;
    HomePage homePage;

    @Before
    public void setUp() {
        driver = Hooks.getDriver();
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver);
        headerPage = new HeaderPage(driver);
        homePage = new HomePage(driver);
    }


    @Given("^user enters username '(.*)' and password '(.*)'$")
    public void entersAdminAndAdmin(String username, String password) {
        System.out.println("user enters username and password");

        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks on {string} button")
    public void clicksOnLoginButton(String button) {
        System.out.println("user clicks on login button");
        loginPage.clickLoginButton(button);
    }

    @Then("^check valid login using fName '(.*)' and lName '(.*)'$")
    public void userIsNavigatedToTheHomePage(String fName, String lName) {
        Assert.assertTrue(headerPage.getWelcomeMessage().equals(headerPage.getWelcomeUserName(fName, lName)));
        System.out.println("user is navigated to the Home page");
    }

    @Then("^check invalid login using string '(.*)'$")
    public void checkInvalidLogin(String string) {
        Assert.assertTrue(basicPage.getFlashMessage().equals(string));
        System.out.println("You have entered an invalid username or password!");
    }
}
