package ui.utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LoggerUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

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

//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            String destination = "screenshots/" + testResult.getName() + "_" + System.currentTimeMillis() + ".png";
//            try {
//                FileUtils.copyFile(source, new File(destination));
//                System.out.println("Скриншот сохранен в: " + destination);
//            } catch (IOException e) {
//                System.err.println("Ошибка при сохранении скриншота: " + e.getMessage());
//            }
//        }
        if (!testResult.isSuccess()) {
            Allure.addAttachment(
                    "screenshot.png",
                    "image/png",
                    new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)),
                    "png");
        }

        closeDriver();

        LoggerUtil.info(String.format("Execution time is %.3f sec%n", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000.0));
    }
}
