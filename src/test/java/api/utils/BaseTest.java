package api.utils;

import api.services.AuthService;
import api.services.BagService;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.utils.LoggerUtil;

import java.lang.reflect.Method;

public abstract class BaseTest {

    private final BagService bagService = new BagService();
    private final AuthService authService = new AuthService();

    public BagService getBagService() {
        return bagService;
    }

    public AuthService getAuthService() {
        return authService;
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
