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

import static api.utils.TestData.BagData;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("KorobovS")
public class BagTest extends BaseTest {

    @Test
    @Description("Добавляем товар в корзину")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testAddItemToCart() {
        TestData.getAccessToken();

        Response response = getBagService().addItemToCart(BagData.ITEM);

        BagData.cartId = response.body().jsonPath().getString("cartId");

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 202);
    }

    @Test(dependsOnMethods = "testAddItemToCart")
    @Description("Получаем все товары из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testGetAllItemsInCart() {
        Response response = getBagService().getAllItemsInCart();

        BagData.itemId = response.body().jsonPath().getString("data.items[0].itemId");

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = "testGetAllItemsInCart")
    @Description("Обновляем данные одного товара из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testUpdateItemInCart() {
        Response response = getBagService().updateItemInCart(BagData.ITEM);

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 202);
    }

    @Test(dependsOnMethods = "testUpdateItemInCart")
    @Description("Удаляем товар из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testRemoveItemFromCart() {
        Response response = getBagService().removeItemFromCart(BagData.itemId);

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 202);
    }
}
