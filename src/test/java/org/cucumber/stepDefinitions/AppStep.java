package org.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.models.User;
import org.cucumber.pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AppStep {

    WebDriver driver;
    User user = new User();
    LoginPage loginPage;
    HeaderPage headerPage;
    BasicPage basicPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    MyAppPage myAppPage;
    NewAppPage newAppPage;
    DetailsPage detailsPage;

    @Before
    public void setUp() {
        driver = Hooks.getDriver();
        headerPage = new HeaderPage(driver);
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        myAppPage = new MyAppPage(driver);
        newAppPage = new NewAppPage(driver);
        detailsPage = new DetailsPage(driver);
    }

    @And("at Home Page click on {string}")
    public void atHomePageClickOn(String myAppLink) {
        headerPage.getMyAppPage(myAppLink);
    }

    @And("at My applications page {string}")
    public void atMyApplicationsPage(String newAppLink) {
        myAppPage.getNewAppPage(newAppLink);
    }

    @When("create new app with name {string} and description {string}")
    public void createNewAppWithNameAndDescription(String name, String descr) {
        newAppPage.createNewApp(name, descr);
    }

    @And("click on {string}")
    public void clickOn(String createButton) {
        newAppPage.clickCreateButton(createButton);
    }

    @When("Verify that it is displayed")
    public void verifyThatItIsDisplayed() {
        Assert.assertTrue(basicPage.isElementDisplayed(homePage.getNewAppElement()));
    }

    @Then("check the user can download new app")
    public void checkTheUserCanDownloadNewApp() {
        homePage.getDetailsPage();
        detailsPage.downloadFile();
        Assert.assertTrue(detailsPage.getJsonResponse().isDisplayed());
    }
}
