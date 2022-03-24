package org.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.framework.Settings;
import org.cucumber.pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AjaxStep {

    WebDriver driver;
    Settings settings = new Settings();
    LoginPage loginPage;
    HeaderPage headerPage;
    BasicPage basicPage;
    AjaxPage ajaxPage;

    @Before()
    public void setUp() {
        driver = Hooks.getDriver();
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver, "Logout");
        headerPage = new HeaderPage(driver);
        ajaxPage = new AjaxPage(driver);
    }

//    @Given("the user enters username {string} and password {string}")
//    public void theUserEntersUsernameAndPassword(String login, String password) {
//        loginPage.enterLogin(login);
//        loginPage.enterPassword(password);
//    }

    @When("user at Home Page clicks on {string} link")
    public void userAtHomePageClicksOnAjaxTestPageLink(String ajaxLink) {
        headerPage.getAjaxPage(ajaxLink);
    }

    @And("user at Ajax Page enters X {string} and Y {string}")
    public void userAtAjaxPageEntersXAndY(String x, String y) {
        ajaxPage.enterData(x, y);
    }

    @And("user clicks on Sum button")
    public void user_clicks_on_sum_button() {
        ajaxPage.clickSum();
    }

    @Then("check if the result is correct if X {string} and Y {string}")
    public void checkIfTheResultIsCorrectIfXAndY(String x, String y) {
        Assert.assertTrue(ajaxPage.isSumCorrect(x, y));
    }

    @Then("check if the result is incorrect. Incorrect result field equals {string}")
    public void checkIfResultIsIncorrect(String incorrectFiled) {
        Assert.assertEquals(ajaxPage.getIncorrectResultField(), incorrectFiled);
    }
}
