package org.cucumber.pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cucumber.framework.LocatorsEnum;
import org.cucumber.jsonResponse.Root;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Objects;

public class DetailsPage extends BasicPage {

    private WebElement downloadLink;
    private WebElement editLink;
    @FindBy(xpath = TEXT_AREA_XPATH)
    private WebElement textAreaDescription;
    @FindBy(xpath = UPDATE_BUTTON_XPATH)
    private WebElement updateButton;
    private WebElement deleteLink;
    private Alert alertConfirmDelete;

    @FindBy(xpath = DESCRIPTION_TEXT_XPATH)
    private WebElement descriptionText;
    @FindBy(xpath = CATEGORY_TEXT_XPATH)
    private WebElement categoryText;
    @FindBy(xpath = AUTHOR_TEXT_XPATH)
    private WebElement authorText;
    @FindBy(xpath = NUMBER_OF_DOWNLOADS_TEXT_XPATH)
    private WebElement numberOfDownloads;
    @FindBy(xpath = TITLE_TEXT_XPATH)
    private WebElement titleText;
    @FindBy(xpath = "/html/body/pre")
    WebElement jsonResponse;

    private String titleOfApp;
    private String descriptionOfApp;
    private String categoryOfApp;
    private String authorOfApp;
    private int numberOfDownloadsOfApp;
    private WebDriver driver;

    public DetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getJsonResponse() {
        return jsonResponse;
    }
    public String getTitleOfApp() { return titleOfApp; }
    public String getDescriptionOfApp() { return descriptionOfApp; }
    public String getCategoryOfApp() { return categoryOfApp; }
    public String getAuthorOfApp() { return authorOfApp; }
    public int getNumberOfDownloadsOfApp() { return numberOfDownloadsOfApp; }

    public DetailsPage getJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = null;
        DetailsPage detailsPage = new DetailsPage(driver);

        try {
            root = objectMapper.readValue(jsonResponse.getText(), Root.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        detailsPage.titleOfApp = root.title;
        detailsPage.descriptionOfApp = "Description: " + root.description;
        detailsPage.categoryOfApp = "Category: " + root.category.title;
        detailsPage.authorOfApp = "Author: " + root.author.name;
        detailsPage.numberOfDownloadsOfApp = root.numberOfDownloads -= 1;
        System.out.println("Json method: " + detailsPage);
        return detailsPage;
    }

    public DetailsPage getDetailsPageInfo() {
        DetailsPage detailsPage = new DetailsPage(driver);
        detailsPage.titleOfApp = titleText.getText();
        detailsPage.descriptionOfApp = descriptionText.getText();
        detailsPage.categoryOfApp = categoryText.getText();
        detailsPage.authorOfApp = authorText.getText();
        detailsPage.numberOfDownloadsOfApp = Integer.parseInt(numberOfDownloads.getText().substring(16));
        System.out.println("Details method: " + detailsPage);
        return detailsPage;
    }

    public DetailsPage downloadFile(String link) {
        downloadLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        try {
            downloadLink.click();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return new DetailsPage(driver);
    }

    public void deleteFile(String link) {
        deleteLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        deleteLink.click();
        alertConfirmDelete = driver.switchTo().alert();
        alertConfirmDelete.accept();
    }

    public void editFile(String link) {
        editLink = driver.findElement(By.xpath(String.format(LocatorsEnum.BASE_LINK.getText(), link)));
        editLink.click();
        textAreaDescription.sendKeys(" and My name's Luke");
        updateButton.click();
    }

    @Override
    public String toString() {
        return "DetailsPage{" +
                "title='" + titleOfApp + '\'' +
                ", description='" + descriptionOfApp + '\'' +
                ", category='" + categoryOfApp + '\'' +
                ", author='" + authorOfApp + '\'' +
                ", numberOfDownloads=" + numberOfDownloadsOfApp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailsPage that = (DetailsPage) o;
        return numberOfDownloadsOfApp == that.numberOfDownloadsOfApp && Objects.equals(titleOfApp, that.titleOfApp) && Objects.equals(descriptionOfApp, that.descriptionOfApp) && Objects.equals(categoryOfApp, that.categoryOfApp) && Objects.equals(authorOfApp, that.authorOfApp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfApp, descriptionOfApp, categoryOfApp, authorOfApp, numberOfDownloadsOfApp);
    }

    private static final String TEXT_AREA_XPATH = "//textarea[@name='description']";
    private static final String UPDATE_BUTTON_XPATH = "//input[@type='submit']";

    private static final String DESCRIPTION_TEXT_XPATH = "//div[@class='description' and contains(text(), 'Description')]";
    private static final String CATEGORY_TEXT_XPATH = "//div[@class='description' and contains(text(), 'Category')]";
    private static final String AUTHOR_TEXT_XPATH = "//div[@class='description' and contains(text(), 'Author')]";
    private static final String NUMBER_OF_DOWNLOADS_TEXT_XPATH = "//div[@class='downloads']";
    private static final String TITLE_TEXT_XPATH = "//div[@class='name']";

}
