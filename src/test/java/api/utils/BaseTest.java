package api.utils;

import api.controllers.AuthController;
import api.controllers.BagController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.utils.LoggerUtil;

import java.lang.reflect.Method;

public abstract class BaseTest {

    public BagController getBagService() {
        return new BagController();
    }

    public AuthController getAuthService() {
        return new AuthController();
    }

    @BeforeMethod
    protected void beforeMethod(Method method) {

        LoggerUtil.info(String.format("Run %s.%s", this.getClass().getName(), method.getName()));
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {

        LoggerUtil.info(String.format("Execution time is %.3f sec%n", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000.0));
    }
}
