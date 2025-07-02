package api.utils;

import io.qameta.allure.Step;

import java.util.Map;

import static api.utils.Constants.BagData.items;

public class Assert {

    @Step("Проверка В корзине находится товар {skuId} в количестве {quantity}")
    public static void assertItemIsInCart(String skuId, int quantity) {

        for (Map<String, Object> item : items) {
            if (item.get("sku").toString().equals(skuId)) {
                org.testng.Assert.assertEquals(item.get("sku").toString(), skuId);
                org.testng.Assert.assertEquals(item.get("quantity"), quantity);
            }
        }
    }
}
