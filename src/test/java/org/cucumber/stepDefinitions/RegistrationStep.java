package org.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.cucumber.models.User;
import org.cucumber.pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;

public class RegistrationStep {

    WebDriver driver;
    User user = new User();
    LoginPage loginPage;
    HeaderPage headerPage;
    BasicPage basicPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    MyAppPage myAppPage;
    NewAppPage newAppPage;


    @Before
    public void setUp() {
//        driver = settings.getDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        driver.navigate().to(settings.getUrl());
        driver = Hooks.getDriver();
        headerPage = new HeaderPage(driver);
        basicPage = new BasicPage(driver);
        loginPage = basicPage.forceLogout(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        myAppPage = new MyAppPage(driver);
        newAppPage = new NewAppPage(driver);
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }

    @Given("^we create user$")
    public void createUser(DataTable dataTable) {
        user.createUser(dataTable, user);
        System.out.println(user);
    }

    @And("user is on login page clicks on {string} link")
    public void userClicksOnRegisterLink(String registerLink) {
        loginPage.getRegistrationPage(registerLink);
        System.out.println("user clicks on register link");
    }

    @When("the user enters his data")
    public void userEntersUsernameFNameLNamePasswordAndConfirmPassword() {
        registrationPage.registerUser(user);
        System.out.println("the user enters his data");
    }

    @When("user clicks on register button")
    public void userClicksOnRegisterButton() {
        registrationPage.clickOnRegister();
        System.out.println("user clicks on register button");
    }

    @Then("verify that the user is logged in")
    public void verifyThatTheUserIsLoggedIn() {
        Assert.assertTrue(headerPage.getWelcomeMessage().equals(headerPage.getWelcomeUserName(user.getFname(), user.getLname())));
        System.out.println("user is navigated to the Home page");
    }

    @When("user logout")
    public void userLogout() {
        basicPage.forceLogout(driver);
        System.out.println("user logout");
    }

    @Then("verify that the user can login")
    public void verifyThatTheUserCanLogin() {
        loginPage.enterLogin(user.getUsername());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue(headerPage.getWelcomeMessage().equals(headerPage.getWelcomeUserName(user.getFname(), user.getLname())));
        System.out.println("user is navigated to the Home page");
    }

    @Then("click on {string} and verify upload {string}")
    public void verifyThatTheDeveloperCanOpenThePageToUploadAnApp(String myApp, String newApp) {
        headerPage.getMyAppPage(myApp);
        myAppPage.getNewAppPage();
        Assert.assertTrue(newAppPage.getTitleName().getText().equals(newApp));
        System.out.println("verify that the developer can open the page to upload");
    }

    @Then("verify that the user can see the app but cannot upload them")
    public void verifyThatTheUserCanSeeTheAppButCannotUploadThem() {
        Assert.assertFalse(basicPage.isElementDisplayed(headerPage.getMyAppLink()));
        System.out.println("verify that the user can see the app but cannot upload them");
    }
}
