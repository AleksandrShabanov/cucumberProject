package org.cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.framework.Settings;
import org.cucumber.framework.Utils;
import org.cucumber.pages.BasicPage;
import org.cucumber.pages.HeaderPage;
import org.cucumber.pages.HomePage;
import org.cucumber.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;


public class LoginStep {

    WebDriver driver = null;
    Settings settings = new Settings();
    LoginPage loginPage;
    HeaderPage headerPage;
    BasicPage basicPage;
    HomePage homePage;


    @Before
    public void setUp() {
        driver = settings.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().to(settings.getUrl());
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        basicPage = new BasicPage(driver);
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        System.out.println("user is on login page");
    }

    @When("^user enters username '(.*)' and password '(.*)'$")
    public void entersAdminAndAdmin(String username, String password) {
        System.out.println("user enters username and password");

        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void clicksOnLoginButton() {
        System.out.println("user clicks on login button");
        loginPage.clickLoginButton();
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
