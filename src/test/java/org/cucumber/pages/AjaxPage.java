package org.cucumber.pages;

import org.cucumber.framework.Log4j2Manager;
import org.cucumber.framework.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AjaxPage extends BasicPage {

    @FindBy(id = X_TEXT_FIELD_ID)
    private WebElement xTextField;
    @FindBy(id = Y_TEXT_FIELD_ID)
    private WebElement yTextField;
    @FindBy(id = SUM_BUTTON_ID)
    private WebElement sumButton;
    @FindBy(xpath = RESULT_FILED_ID)
    private WebElement correctResultField;
    @FindBy(xpath = INCORRECT_RESULT_XPATH)
    private WebElement incorrectResultField;

    public AjaxPage(WebDriver driver) {
        super(driver);
    }

    public String getIncorrectResultField() {
        Utils.waitForElementVisible(incorrectResultField);
        return incorrectResultField.getText();
    }

    public void enterData(String x, String y) {
        xTextField.sendKeys(x);
        yTextField.sendKeys(y);
    }

    public void clickSum(){
        sumButton.click();
    }

    public boolean isSumCorrect(String x, String y) {
        Utils.waitForElementVisible(correctResultField);
        String string = correctResultField.getText();
        String regexString = "\\d+(\\.\\d+)?";
        Double sumDouble = 0.0;
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(string);
        double xField = Double.valueOf(x);
        double yField = Double.valueOf(y);

        while (matcher.find()) {
            sumDouble = Double.valueOf(matcher.group());
            if (sumDouble == (xField + yField)) {
                System.out.println(xField + " + " + yField + " = " + sumDouble);
                return true;
            } else {
                System.out.println("the sum of the numbers is not correct");
            }
        }
        Log4j2Manager.info("===============" + "sumTwoNumbers method: End" + "===============");
        return false;
    }

    private static final String X_TEXT_FIELD_ID = "x";
    private static final String Y_TEXT_FIELD_ID = "y";
    private static final String SUM_BUTTON_ID = "calc";
    private static final String RESULT_FILED_ID = "//div[@id='result' and contains(text(),'Result is:')]";
    private static final String INCORRECT_RESULT_XPATH = "//div[@id='result' and contains(text(),'Result is: Incorrect')]";

}
