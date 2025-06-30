package api.utils;

import api.controllers.AuthController;
import api.controllers.BagGuestController;
import api.controllers.BagUserController;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.utils.LoggerUtil;

import java.lang.reflect.Method;

public abstract class BaseTest {

    public BagGuestController getBagGuestController() {
        return new BagGuestController();
    }

    public AuthController getAuthController() {
        return new AuthController();
    }

    public BagUserController getBagUserController() {
        return new BagUserController();
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
