package ui.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.LoggerUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ProjectUtils {

    public static WebDriver createDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver;
        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");

        LoggerUtil.info(String.format("SELENIUM_REMOTE_URL = %s", remoteUrl));
        if (remoteUrl != null) {
            Allure.addAttachment("RemoteUrl", remoteUrl);
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), chromeOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Malformed URL for Selenium Remote WebDriver", e);
            }
        } else {
            Allure.addAttachment("Local run", "No remote driver");
            chromeOptions.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(chromeOptions);
        }

        return driver;
    }
}
