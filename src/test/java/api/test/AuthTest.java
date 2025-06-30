package api.test;

import api.utils.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("KorobovS")
public class AuthTest extends BaseTest {

    @Test
    @Description("Получаем токен Guest")
    @Severity(BLOCKER)
    @Tag("Smoke")
    public void testGetAccessTokenGuest() {
        Response response = getAuthController().getAccessTokenGuest();

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    @Description("Получаем токен User")
    @Severity(BLOCKER)
    @Tag("Smoke")
    public void testGetAccessTokenUser() {
        Response response = getAuthController().getAccessTokenUser();

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
