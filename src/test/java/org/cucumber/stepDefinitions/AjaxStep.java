package org.cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.framework.Settings;
import org.cucumber.pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AjaxStep {

    WebDriver driver;
    Settings settings = new Settings();
    LoginPage loginPage;
    HeaderPage headerPage;
    BasicPage basicPage;
    HomePage homePage;
    AjaxPage ajaxPage;

    @Before()
    public void setUp() {
        driver = Hooks.getDriver();
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver);
        headerPage = new HeaderPage(driver);
        homePage = new HomePage(driver);
        ajaxPage = new AjaxPage(driver);
    }

    @Given("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }
    @And("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }
    @When("user at Home Page clicks on ajax test page link")
    public void user_at_home_page_clicks_on_ajax_test_page_link() {
        headerPage.getAjaxPage();
    }
    @And("user at Ajax Page enters X {string} and Y {string}")
    public void user_at_ajax_page_enters_x_and_y(String x, String y) {
        ajaxPage.enterData(x, y);
    }
    @And("user clicks on Sum button")
    public void user_clicks_on_sum_button() {
        ajaxPage.clickSum();
    }
    @Then("check if the result is correct if X {string} and Y {string}")
    public void check_if_the_result_is_correct_if_x_and_y(String x, String y) {
        Assert.assertTrue(ajaxPage.isSumCorrect(x, y));
    }

    @Then("check if the result is incorrect. Incorrect result field equals {string}")
    public void checkIfResultIsIncorrect(String incorrectFiled) {
        Assert.assertEquals(ajaxPage.getIncorrectResultField(), incorrectFiled);
    }
}
