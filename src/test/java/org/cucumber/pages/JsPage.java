package org.cucumber.pages;

import org.cucumber.framework.Log4j2Manager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JsPage extends BasicPage {

    @FindBy(id = TOP_TEXT_FIELD_ID)
    private WebElement top;
    @FindBy(id = LEFT_TEXT_FIELD_ID)
    private WebElement left;
//    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private Alert message;

//    public void enterCoordinates() {
//        Log4j2Manager.info("===============" + "enterCoordinates method: Start" + "===============");
//        String sTop = (String)js.executeScript("return $(\"div.flash\").css(\"top\" );");
//        String sLeft = (String) js.executeScript("return $(\"div.flash\").css(\"left\" );");
//
//        top.sendKeys(Long.toString(Math.round(Double.parseDouble(sTop.replace("px", "")))));
//        left.sendKeys(Long.toString(Math.round(Double.parseDouble(sLeft.replace("px", "")))));
//        Log4j2Manager.info("===============" + "enterCoordinates method: End" + "===============");
//    }

//    public void isAlertDisplayed() {
//        Log4j2Manager.info("===============" + "isAlertDisplayed method: Start" + "===============");
//        js.executeScript("process();");
//        message = driver.switchTo().alert();
//        if (message.getText().equals("Whoo Hoooo! Correct!")) {
//            message.accept();
//        }
//        Log4j2Manager.info("===============" + "isAlertDisplayed method: End" + "===============");
//    }

    private static final String TOP_TEXT_FIELD_ID = "top";
    private static final String LEFT_TEXT_FIELD_ID = "left";

    public JsPage(WebDriver driver) {
        super(driver);
    }
}
