package ui.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LoggerUtil;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Objects;

public abstract class BaseTest {

    private WebDriver driver;

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

        if (!testResult.isSuccess()) {
            Allure.addAttachment(
                    "screenshot.png",
                    "image/png",
                    new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)),
                    "png");

            Allure.addAttachment(
                    "Page HTML",
                    "text/html",
                    Objects.requireNonNull(getDriver().getPageSource()),
                    ".html");
        }

        closeDriver();

        LoggerUtil.info(String.format("Execution time is %.3f sec%n", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000.0));
    }
}
