package ui.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {

    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    private void startDriver() {

        if (driver == null) {
            driver = ProjectUtils.createDriver();
        }

        LoggerUtil.info("Browser open");

    }

    private void closeDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;

            LoggerUtil.info("Browser closed");
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
}
