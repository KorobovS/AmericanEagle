package api.steps;

import api.models.Product;
import api.models.Sku;
import api.models.Skus;
import io.qameta.allure.Step;

import java.util.List;

public class ProductSteps {

    @Step("Получаем товар с нужными характеристиками")
    public static Sku getSku(Product product, String skuId) {
        List<Skus> skus = product.getSkus();
        for (Skus sku : skus) {
            if (sku.getSkuId().equals(skuId)) {
                return new Sku(sku.getSize(), sku.getSalePrice(), sku.getSkuId(), sku.getListPrice());
            }
        }
        return null;
    }
}
