package api.test;

import api.utils.BaseTest;
import api.utils.TestData;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("KorobovS")
public class AuthTest extends BaseTest {

    @Test
    @Description("Получаем токен Guest")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testGetAccessToken() {
        Response response = getAuthService().getAccessToken();

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
