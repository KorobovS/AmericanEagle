package api.steps;

import io.qameta.allure.Step;

import java.util.Map;

import static api.utils.Constants.BagData.items;

public class BagGuestSteps {

    @Step("Получаем itemId товара по skuId {skuId}")
    public static String getItemIdBySkuId(String skuId) {
        for (Map<String, Object> item : items) {
            if (item.get("sku").toString().equals(skuId)) {
                return item.get("itemId").toString();
            }
        }
        return "";
    }
}
