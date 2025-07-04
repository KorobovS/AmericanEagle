package ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LoggerUtil;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait10;

    protected WebDriver getDriver() {
        return driver;
    }

    private void startDriver() {
        LoggerUtil.info("Открываю браузер");
        driver = ProjectUtils.createDriver();
    }

    private void closeDriver() {

        LoggerUtil.info("Закрываю браузер");
        if (driver != null) {
            driver.quit();
            driver = null;
            wait10 = null;
        }
    }

    @BeforeMethod
    protected void beforeMethod(Method method) {
        startDriver();
        getDriver().get("https://www.ae.com/us/en");

        LoggerUtil.info(String.format("Run %s.%s", this.getClass().getName(), method.getName()));
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {
        closeDriver();

        LoggerUtil.info(String.format("Execution time is %.3f sec%n", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000.0));
    }

    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }

        return wait10;
    }
}
