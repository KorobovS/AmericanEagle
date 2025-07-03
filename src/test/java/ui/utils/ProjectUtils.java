package ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.LoggerUtil;

import java.time.Duration;

public class ProjectUtils {

    private static final ChromeOptions CHROME_OPTIONS;

    public static WebDriver createDriver() {

        WebDriver driver = new ChromeDriver(CHROME_OPTIONS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LoggerUtil.info("Created driver");

        return driver;
    }

    static {
        CHROME_OPTIONS = new ChromeOptions();
        CHROME_OPTIONS.addArguments("--window-size=1920,1080");
    }
}
