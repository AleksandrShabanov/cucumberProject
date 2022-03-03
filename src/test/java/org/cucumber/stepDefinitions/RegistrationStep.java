package org.cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.framework.Settings;
import org.cucumber.models.UserBuilder;
import org.cucumber.pages.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationStep {

    WebDriver driver = null;
    Settings settings = new Settings();
    LoginPage loginPage;
    HeaderPage headerPage;
    BasicPage basicPage;
    HomePage homePage;
    RegistrationPage registrationPage;


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
        registrationPage = new RegistrationPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @And("user clicks on register link")
    public void userClicksOnRegisterLink() {
        System.out.println("user clicks on register link");
        loginPage.getRegistrationPage();
    }
    @When("user enters username {string}, fName {string}, lName {string}, password {string} and confirmPassword {string}")
    public void userEntersUsernameFNameLNamePasswordAndConfirmPassword(String string, String string2, String string3, String string4, String string5) {

    }

//    @And("^create user$")
//    public void createUser(UserBuilder user) {
//
//    }


    @When("user clicks on register button")
    public void userClicksOnRegisterButton() {

    }
    @Then("verify that the user is logged in")
    public void verifyThatTheUserIsLoggedIn() {

    }
}
