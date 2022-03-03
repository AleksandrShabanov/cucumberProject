package org.cucumber.pages;

import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.cucumber.framework.Log4j2Manager;
import org.cucumber.jsonResponse.Root;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class DetailsPage extends BasicPage {

    @FindBy(linkText = DOWNLOAD_BUTTON)
    private WebElement downloadButton;
    @FindBy(linkText = EDIT_BUTTON)
    private WebElement editButton;
    @FindBy(xpath = TEXT_AREA_XPATH)
    private WebElement textAreaDescription;
    @FindBy(xpath = UPDATE_BUTTON_XPATH)
    private WebElement updateButton;
    @FindBy(linkText = DELETE_BUTTON)
    private WebElement deleteButton;
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
    ObjectMapper objectMapper = new ObjectMapper();

    private String titleOfApp;
    private String descriptionOfApp;
    private String categoryOfApp;
    private String authorOfApp;
    private int numberOfDownloadsOfApp;

    public DetailsPage() {
        super();
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
        Log4j2Manager.info("===============" + "getJson method: Start" + "===============");
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = null;
        DetailsPage detailsPage = new DetailsPage();

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
        Log4j2Manager.info("===============" + "getJson method: Start" + "===============");
        return detailsPage;
    }

    public DetailsPage getDetailsPageInfo() {
        Log4j2Manager.info("===============" + "getDetailsPageInfo method: Start" + "===============");
        DetailsPage detailsPage = new DetailsPage();
        detailsPage.titleOfApp = titleText.getText();
        detailsPage.descriptionOfApp = descriptionText.getText();
        detailsPage.categoryOfApp = categoryText.getText();
        detailsPage.authorOfApp = authorText.getText();
        detailsPage.numberOfDownloadsOfApp = Integer.parseInt(numberOfDownloads.getText().substring(16));
        System.out.println("Details method: " + detailsPage);
        Log4j2Manager.info("===============" + "getDetailsPageInfo method: Start" + "===============");
        return detailsPage;
    }

//    public DetailsPage downloadFile() {
//        Log4j2Manager.info("===============" + "downloadFile method: Start" + "===============");
//        try {
//            downloadButton.click();
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        Log4j2Manager.info("===============" + "downloadFile method: Start" + "===============");
//        return initPage(DetailsPage.class);
//    }
//
//    public void deleteFile() {
//        Log4j2Manager.info("===============" + "deleteFile method: Start" + "===============");
//        deleteButton.click();
//        alertConfirmDelete = driver.switchTo().alert();
//        alertConfirmDelete.accept();
//        Log4j2Manager.info("===============" + "deleteFile method: Start" + "===============");
//    }

    public void editFile() {
        Log4j2Manager.info("===============" + "editFile method: Start" + "===============");
        editButton.click();
        textAreaDescription.sendKeys(" and My name's Luke");
        updateButton.click();
        Log4j2Manager.info("===============" + "editFile method: End" + "===============");
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

    private static final String DOWNLOAD_BUTTON = "Download";
    private static final String DELETE_BUTTON = "Delete";
    private static final String EDIT_BUTTON = "Edit";
    private static final String TEXT_AREA_XPATH = "//textarea[@name='description']";
    private static final String UPDATE_BUTTON_XPATH = "//input[@type='submit']";

    private static final String DESCRIPTION_TEXT_XPATH = "//div[@class='description' and contains(text(), 'Description')]";
    private static final String CATEGORY_TEXT_XPATH = "//div[@class='description' and contains(text(), 'Category')]";
    private static final String AUTHOR_TEXT_XPATH = "//div[@class='description' and contains(text(), 'Author')]";
    private static final String NUMBER_OF_DOWNLOADS_TEXT_XPATH = "//div[@class='downloads']";
    private static final String TITLE_TEXT_XPATH = "//div[@class='name']";

}
