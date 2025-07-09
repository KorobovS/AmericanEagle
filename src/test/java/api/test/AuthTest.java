package api.test;

import api.utils.BaseTest;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("KorobovS")
@Feature("API")
public class AuthTest extends BaseTest {

    @Test(groups = "smoke")
    @Description("Получаем токен Guest")
    @Severity(BLOCKER)
    @Tag("Smoke")
    public void testGetAccessTokenGuest() {
        Response response = getAuthController().getAccessTokenGuest();

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(groups = {"smoke", "defect"})
    @Description("Получаем токен User")
    @Severity(BLOCKER)
    @Tags({@Tag("Smoke"), @Tag("Defect")})
    public void testGetAccessTokenUser() {
        Response response = getAuthController().getAccessTokenUser();

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
