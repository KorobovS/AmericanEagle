package api.test;

import api.utils.BaseTest;
import api.utils.Constants;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static api.utils.Constants.BagData.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("KorobovS")
public class BagUserTest extends BaseTest {

    @Test
    @Description("Добавляем товар в корзину")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testAddItemToCart() {
        Constants.createAccessTokenUser();

        Response response = getBagUserController().addItemToCartUser(SKUID_WOMEN, 1);

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 202);
    }

    @Test(dependsOnMethods = "testAddItemToCart")
    @Description("Получаем все товары из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testGetAllItemsInCart() {
        Response response = getBagUserController().getAllItemsInCartUser();

        Allure.step("Проверка статус кода");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.asString());
    }

//    @Test(dependsOnMethods = "testGetAllItemsInCart")
//    @Description("Обновляем данные одного товара из корзины")
//    @Severity(CRITICAL)
//    @Tag("Smoke")
//    public void testUpdateItemInCart() {
//        String skuId = (String) items.get(0).get("sku");
//        String itemId = (String) items.get(0).get("itemId");
//        int quantity = 2;
//
//        Response response = getBagController().updateItemInCart(skuId, quantity, itemId);
//
//        Allure.step("Проверка статус кода");
//        Assert.assertEquals(response.getStatusCode(), 202);
//    }
//
//    @Test(dependsOnMethods = "testUpdateItemInCart")
//    @Description("Удаляем товар из корзины")
//    @Severity(CRITICAL)
//    @Tag("Smoke")
//    public void testRemoveItemFromCart() {
//        String itemId = (String) items.get(0).get("itemId");
//
//        Response response = getBagController().removeItemFromCart(itemId);
//
//        Allure.step("Проверка статус кода");
//        Assert.assertEquals(response.getStatusCode(), 202);
//    }
//
//    @Test(priority = 1)
//    @Description("Ложим 2 товара в корзину, изменяем у одного товара количество и удаляем другой товар из корзины")
//    @Severity(CRITICAL)
//    @Tag("EndToEnd")
//    public void testE2EFromCartGuest() {
//
//        Constants.createAccessTokenGuest();
//
//        int quantity = 1;
//        getBagController().addItemToCart(SKUID_WOMEN, quantity);
//        getBagController().addItemToCart(SKUID_MEN, quantity);
//
//        items = getBagController().getAllItemsInCart().body().jsonPath().getList("data.items");
//        List<String> skuIds = new ArrayList<>(items.size());
//        for (Map<String, Object> item : items) {
//            skuIds.add(item.get("sku").toString());
//        }
//
//        Assert.assertEquals(items.size(), 2);
//        Assert.assertTrue(skuIds.contains(SKUID_WOMEN));
//        Assert.assertTrue(skuIds.contains(SKUID_WOMEN));
//
//        int quantityNew = 9;
//        String itemId = "";
//        for (Map<String, Object> item : items) {
//            if (item.get("sku").toString().equals(SKUID_WOMEN)) {
//                itemId = item.get("itemId").toString();
//            }
//        }
//        getBagController().updateItemInCart(SKUID_WOMEN, quantityNew, itemId);
//
//        items = getBagController().getAllItemsInCart().body().jsonPath().getList("data.items");
//        for (Map<String, Object> item : items) {
//            if (item.get("sku").toString().equals(SKUID_WOMEN)) {
//                Assert.assertEquals(item.get("quantity"), quantityNew);
//            }
//        }
//
//        getBagController().removeItemFromCart(itemId);
//        items = getBagController().getAllItemsInCart().body().jsonPath().getList("data.items");
//
//        Assert.assertEquals(items.size(), 1);
//        Assert.assertEquals(items.get(0).get("sku"), SKUID_MEN);
//    }
}
