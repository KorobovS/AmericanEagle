package api.services;

import api.utils.TestData;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BagService extends BaseService {

    @Step("Добавляю товар {item} в корзину")
    public Response addItemToCart(String item) {
        LOGGER.info("Добавляю товар {} в корзину", item);

        requestSpecification.header("Authorization", "Bearer " + TestData.accessToken)
                .contentType(ContentType.JSON)
                .body(String.format("{\"items\": [{\"skuId\": \"%s\", \"quantity\": 3}]}", item));

        Response response = apiClient.post("bag/v1/items", requestSpecification);
        TestData.BagData.cartId = response.body().jsonPath().getString("cartId");
        initRequestSpecification();

        return response;
    }

    @Step("Получаю все товары из корзины")
    public Response getAllItemsInCart() {
        LOGGER.info("Получаю все товары из корзины");

        requestSpecification.header("Authorization", "Bearer " + TestData.accessToken);

        Response response = apiClient.get("bag/v1", requestSpecification);
        TestData.BagData.itemId = response.body().jsonPath().getString("data.items[0].itemId");
        initRequestSpecification();

        return response;
    }

    @Step("Обновляю данные о товаре {item} в корзине")
    public Response updateItemInCart(String item, String body) {
        LOGGER.info("Обновляю данные о товаре {} в корзине", item);

        requestSpecification.header("Authorization", "Bearer " + TestData.accessToken)
                .contentType(ContentType.JSON)
                .body(body);

        Response response = apiClient.patch("bag/v1/items", requestSpecification);
        initRequestSpecification();

        return response;
    }

    @Step("Удаляю товар {item} из корзины")
    public Response removeItemFromCart(String item) {
        LOGGER.info("Удаляю товар {} из корзины", item);

        requestSpecification.header("Authorization", "Bearer " + TestData.accessToken)
                .queryParam("itemIds", item);

        Response response = apiClient.delete("bag/v1/items", requestSpecification);
        initRequestSpecification();

        return response;
    }
}
