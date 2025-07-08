package api.test;

import api.utils.BaseTest;
import api.utils.TestData;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.steps.BagGuestSteps.getItemIdBySkuId;
import static api.utils.Assert.assertItemIsInCart;
import static api.utils.Constants.BagData.*;
import static api.utils.Constants.createAccessTokenGuest;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.testng.Assert.assertEquals;

@Owner("KorobovS")
@Feature("API")
public class BagGuestTest extends BaseTest {

    @Test
    @Description("Добавляем товар в корзину")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testAddItemToCart() {
        createAccessTokenGuest();

        Response response = getBagGuestController().addItemToCart(SKUID_WOMEN, 1);

        Allure.step("Проверка статус кода");
        assertEquals(response.getStatusCode(), 202);
    }

    @Test(dependsOnMethods = "testAddItemToCart")
    @Description("Получаем все товары из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testGetAllItemsInCart() {
        Response response = getBagGuestController().getAllItemsInCart();

        Allure.step("Проверка статус кода");
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = "testGetAllItemsInCart")
    @Description("Обновляем данные одного товара из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testUpdateItemInCart() {
        String skuId = (String) items.get(0).get("sku");
        String itemId = (String) items.get(0).get("itemId");
        int quantity = 2;

        Response response = getBagGuestController().updateItemInCart(skuId, quantity, itemId);

        Allure.step("Проверка статус кода");
        assertEquals(response.getStatusCode(), 202);
    }

    @Test(dependsOnMethods = "testUpdateItemInCart")
    @Description("Удаляем товар из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testRemoveItemFromCart() {
        String itemId = (String) items.get(0).get("itemId");

        Response response = getBagGuestController().removeItemFromCart(itemId);

        Allure.step("Проверка статус кода");
        assertEquals(response.getStatusCode(), 202);
    }

    @Test(priority = 1)
    @Description("Ложим 2 товара в корзину, изменяем у одного товара количество и удаляем другой товар из корзины")
    @Severity(CRITICAL)
    @Tag("EndToEnd")
    public void testCRUDCartGuest() {

        createAccessTokenGuest();

        int quantity = 1;
        getBagGuestController().addItemToCart(SKUID_WOMEN, quantity);
        getBagGuestController().addItemToCart(SKUID_MEN, quantity);

        getBagGuestController().getAllItemsInCart();
        Allure.step("Проверяю количество товаров в корзине");
        assertEquals(items.size(), 2);
        assertItemIsInCart(SKUID_WOMEN, quantity);
        assertItemIsInCart(SKUID_MEN, quantity);

        int quantityNew = 9;
        String itemId = getItemIdBySkuId(SKUID_WOMEN);
        getBagGuestController().updateItemInCart(SKUID_WOMEN, quantityNew, itemId);

        getBagGuestController().getAllItemsInCart();
        assertItemIsInCart(SKUID_WOMEN, quantityNew);

        getBagGuestController().removeItemFromCart(itemId);

        getBagGuestController().getAllItemsInCart();
        Allure.step("Проверяю количество товаров в корзине");
        assertEquals(items.size(), 1);
        assertItemIsInCart(SKUID_MEN, quantity);
    }

    @Test(priority = 1, dataProvider = "dataShipping", dataProviderClass = TestData.class)
    @Description("Проверка стоимости досавки в зависимости от суммы товаров в корзине")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testShipping(int quantity, double expected) {
        createAccessTokenGuest();

        getBagGuestController().addItemToCart(SKUID_WOMEN, quantity);
        double actual = getBagGuestController().getAllItemsInCart().body().jsonPath().getDouble("data.summary.shipping");

        assertEquals(actual, expected);
    }

    @Test(priority = 1, dataProvider = "dataUpdate", dataProviderClass = TestData.class)
    @Description("При обновлении данных товара пытаемся изменить сам товар или задать колличесво одного товара больше 10")
    @Severity(CRITICAL)
    @Tags({@Tag("Smoke"), @Tag("Bag")})
    public void testUpdateItemInCartNegative(String skuId, int quantity) {
        createAccessTokenGuest();

        getBagGuestController().addItemToCart(SKUID_WOMEN, 1);
        getBagGuestController().getAllItemsInCart();
        String itemId = (String) items.get(0).get("itemId");

        Response response = getBagGuestController().updateItemInCart(skuId, quantity, itemId);

        Assert.assertNotEquals(response.getStatusCode(), 202);
    }
}
