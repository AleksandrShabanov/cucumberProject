package org.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private BasicPage basicPage;
    private JsPage jsPage;

    @Before()
    public void setUp() {
        driver = Hooks.getDriver();
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver, "Logout");
        headerPage = new HeaderPage(driver);
        jsPage = new JsPage(driver);
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
