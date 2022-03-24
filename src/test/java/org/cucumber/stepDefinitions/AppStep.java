package org.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.assertj.core.api.SoftAssertions;
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
        loginPage = basicPage.forceLogout(driver, "Logout");
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

    @When("at Details Page click on {string} link")
    public void atDetailsPageClickDownloadLink(String string) {
        detailsPage.downloadFile(string);
    }

    @Then("check the user can download new app")
    public void checkTheUserCanDownloadNewApp() {
        Assert.assertTrue(detailsPage.getJsonResponse().isDisplayed());
    }

    @And("at Home Page click on {string} link")
    public void atHomePageClickOnLink(String detailsLink) {
            homePage.getDetailsPage(detailsLink);
    }

    @And("at Home Page click on details new app link")
    public void atHomePageClickOnDetailsNewAppLink() {
        homePage.getNewAppDetailsPage();
    }

    @When("at Details Page click on {string}")
    public void atDetailsPageClickOnLink(String editLink) {
        detailsPage.editFile(editLink);
    }

    @Then("verify that the changes were applied and we see {string}")
    public void verifyThatTheChangesWereApplied(String string) {
        Assert.assertEquals(basicPage.getFlashMessage(), string);
    }

    @When("press choose file for add image")
    public void pressChooseFileForAddImage() {
        newAppPage.addImage();
    }

    @And("press choose file for add icon")
    public void pressChooseFileForAddIcon() {
    }

    @Then("verify that app was create")
    public void verifyThatAppWasCreate() {
        Assert.assertTrue(basicPage.isElementDisplayed(homePage.getNewAppWithImage()));
    }

    @And("at Details page click on {string}")
    public void atDetailsPageDeleteApp(String string) {
        detailsPage.deleteFile(string);
    }

    @Then("confirm text after {string}")
    public void confirmTextOnPage(String string) {
        SoftAssertions softAssertions = new SoftAssertions();
        DetailsPage detailsPageInfo = detailsPage.getDetailsPageInfo();
        detailsPage.downloadFile(string);
        DetailsPage detailsPageJson = detailsPage.getJson();

        softAssertions.assertThat(detailsPageInfo.getTitleOfApp()).isEqualTo(detailsPageJson.getTitleOfApp());
        softAssertions.assertThat(detailsPageInfo.getDescriptionOfApp()).isEqualTo(detailsPageJson.getDescriptionOfApp());
        softAssertions.assertThat(detailsPageInfo.getAuthorOfApp()).isEqualTo(detailsPageJson.getAuthorOfApp());
        softAssertions.assertThat(detailsPageInfo.getCategoryOfApp()).isEqualTo(detailsPageJson.getCategoryOfApp());
        softAssertions.assertThat(detailsPageInfo.getNumberOfDownloadsOfApp()).isEqualTo(detailsPageJson.getNumberOfDownloadsOfApp());
        softAssertions.assertAll();
    }

    @When("{string} file many times")
    public void downloadFileManyTimes(String string) {
        for (int i = 0; i < 10; i++) {
            detailsPage.downloadFile(string);
            driver.navigate().back();
        }
    }

    @Then("verify that my app in popular section")
    public void verifyThatMyAppInPopularSection() {
        homePage.isMyAppPopular();
    }
}
