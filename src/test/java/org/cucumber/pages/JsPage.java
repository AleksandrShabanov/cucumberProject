package org.cucumber.pages;

import org.cucumber.framework.Settings;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsPage extends BasicPage {

    @FindBy(id = TOP_TEXT_FIELD_ID)
    private WebElement top;
    @FindBy(id = LEFT_TEXT_FIELD_ID)
    private WebElement left;
    private WebDriver driver;
    private Settings settings = new Settings();
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private Alert message;

    public JsPage(WebDriver driver) {
        super(driver);
    }

    public void enterCoordinates(JavascriptExecutor js) {
        String sTop = (String)js.executeScript("return $(\"div.flash\").css(\"top\" );");
        String sLeft = (String) js.executeScript("return $(\"div.flash\").css(\"left\" );");

        top.sendKeys(Long.toString(Math.round(Double.parseDouble(sTop.replace("px", "")))));
        left.sendKeys(Long.toString(Math.round(Double.parseDouble(sLeft.replace("px", "")))));
    }

    public void isAlertDisplayed(JavascriptExecutor js, String alert) {
        js.executeScript("process();");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            message = driver.switchTo().alert();
            if (message.getText().equals(alert)) {
                message.accept();
                System.out.println(message.getText());
            }
        } catch (Exception e) {

        }
    }

    private static final String TOP_TEXT_FIELD_ID = "top";
    private static final String LEFT_TEXT_FIELD_ID = "left";
}
