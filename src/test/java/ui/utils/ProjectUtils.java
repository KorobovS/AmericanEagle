package ui.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.LoggerUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ProjectUtils {

    private static final ChromeOptions CHROME_OPTIONS;

    public static WebDriver createDriver() {

        WebDriver driver;
        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");

        LoggerUtil.info(String.format("SELENIUM_REMOTE_URL = %s", remoteUrl));
        if ((remoteUrl != null) || !remoteUrl.isEmpty()) {
            Allure.addAttachment("RemoteUrl", remoteUrl);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Malformed URL for Selenium Remote WebDriver", e);
            }
        } else {
            Allure.addAttachment("Local run", "No remote driver");
            driver = new ChromeDriver(CHROME_OPTIONS);
        }

        return driver;
    }

    static {
        CHROME_OPTIONS = new ChromeOptions();
        CHROME_OPTIONS.addArguments("--window-size=1920,1080");
        CHROME_OPTIONS.setPageLoadStrategy(PageLoadStrategy.EAGER);
    }
}
