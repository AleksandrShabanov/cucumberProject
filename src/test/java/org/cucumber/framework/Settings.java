package org.cucumber.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private static final String SELENIUM_BASEURL = "selenium.baseUrl";
    private static final String SELENIUM_ADDITIONAL_URL = "selenium.additionalUrl";
    private static final String SELENIUM_BROWSER_GC = "selenium.browserGc";
    private static final String SELENIUM_BASIC_AUTH = "selenium.basicAuth";
    private static final String SELENIUM_PROPERTIES = "selenium.properties";

    private String baseUrl;
    private String additionalUrl;
    private BrowserType browser;
    private Properties properties = new Properties();
    boolean getUrl;

    public Settings() {
        loadSettings();
    }

    private void loadSettings() {
        properties = loadPropertiesFile();
        baseUrl = getPropertyOrThrowException(SELENIUM_BASEURL);
        additionalUrl = getPropertyOrThrowException(SELENIUM_ADDITIONAL_URL);
        getUrl = Boolean.parseBoolean(getPropertyOrThrowException(SELENIUM_BASIC_AUTH));
        browser = BrowserType.Browser(getPropertyOrThrowException(SELENIUM_BROWSER_GC));
    }

    public String getUrl() {
        if (getUrl == true) {
            return baseUrl;
        } else {
            return additionalUrl;
        }
    }

    private Properties loadPropertiesFile() {
        try {
            // get specified property file
            String filename = getPropertyOrNull(SELENIUM_PROPERTIES);
            // it is not defined, use default
            if (filename == null) {
                filename = SELENIUM_PROPERTIES;
            }
            // try to load from classpath
            InputStream stream = getClass().getClassLoader().getResourceAsStream(filename);
            // no file in classpath, look on disk
            if (stream == null) {
                stream = new FileInputStream(new File(filename));
            }
            Properties result = new Properties();
            result.load(stream);
            return result;
        } catch (IOException e) {
            throw new UnknownPropertyException("Property file is not found");
        }
    }

    public String getPropertyOrNull(String name) {
        return getProperty(name, false);
    }

    public String getPropertyOrThrowException(String name) {
        return getProperty(name, true);
    }

    private String getProperty(String name, boolean forceExceptionIfNotDefined) {
        String result;
        if ((result = System.getProperty(name, null)) != null && result.length() > 0) {
            return result;
        } else if ((result = getPropertyFromPropertiesFile(name)) != null && result.length() > 0) {
            return result;
        } else if (forceExceptionIfNotDefined) {
            throw new UnknownPropertyException("Unknown property: [" + name + "]");
        }
        return result;
    }

    private String getPropertyFromPropertiesFile(String name) {
        Object result = properties.get(name);
        if (result == null) {
            return null;
        } else {
            return result.toString();
        }
    }

    public WebDriver getDriver() {
        return getDriver(browser);
    }

    private WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case GC:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                return new FirefoxDriver();
            case EDGE:
                System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                return new EdgeDriver();
            default:
                throw new UnknownBrowserException("Cannot create driver for unknown browser type");
        }
    }

    public String getAdditionalUrl() { return additionalUrl; }

    public BrowserType getBrowser() {
        return browser;
    }
}
