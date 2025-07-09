package api.test;

import api.models.Sku;
import api.steps.ProductSteps;
import api.utils.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.utils.Constants.ProductData.*;
import static api.utils.Constants.createAccessTokenGuest;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("KorobovS")
@Feature("API")
public class ProductGuestTest extends BaseTest {

    @Test
    @Description("Получаю данные о товаре")
    @Severity(CRITICAL)
    @Tag("smoke")
    public void testGetProduct() {
        createAccessTokenGuest();

        Response response = getProductGuestController().getProduct(CODE_PRODUCT);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    @Description("Проверка характеристик товара до и после помещения в корзину")
    @Severity(CRITICAL)
    @Tag("smoke")
    public void testProductToCart() {
        createAccessTokenGuest();

        getProductGuestController().getProduct(CODE_PRODUCT);

        getBagGuestController().addItemToCart(SCUID_PRODUCT, 1);
        getBagGuestController().getAllItemsInCart();

        Sku expected = ProductSteps.getSku(product, SCUID_PRODUCT);
        Sku received = productToCart;

        Assert.assertEquals(expected, received);
    }
}
