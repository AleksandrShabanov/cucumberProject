package org.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.framework.Log4j2Manager;
import org.cucumber.framework.Settings;
import org.cucumber.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsStep {

    WebDriver driver;
    Settings settings = new Settings();
    LoginPage loginPage;
    HeaderPage headerPage;
    BasicPage basicPage;
    JsPage jsPage;

    @Before()
    public void setUp() {
        driver = Hooks.getDriver();
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver);
        headerPage = new HeaderPage(driver);
        jsPage = new JsPage(driver);
    }

    @Given("enter username {string} and password {string}")
    public void enterUsernameAndPassword(String login, String password) {
        System.out.println("enter login and password");
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("user at Home Page clicks on {string}")
    public void userAtHomePageClicksOnJsLink(String jsLink) {
        headerPage.getJsPage(jsLink);
    }

    @Then("enter coordinates")
    public void enterCoordinates() {
        jsPage.enterCoordinates((JavascriptExecutor)driver);
    }

    @And("check is {string} displayed")
    public void checkIsAlertDisplayed(String alert) {
        System.out.println("check is Alert displayed");
        jsPage.isAlertDisplayed((JavascriptExecutor)driver, alert);
    }
}
