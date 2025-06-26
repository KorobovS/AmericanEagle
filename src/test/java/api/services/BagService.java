package api.services;

import api.utils.TestData;
import api.utils.TestData.BagData;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BagService extends BaseService {

    @Step("Получаем товар {item} из корзины")
    public Response addItemToCart(String item) {
        requestSpecification.header("Authorization", "Bearer " + TestData.accessToken)
                .contentType(ContentType.JSON)
                .body(String.format("{\"items\": [{\"skuId\": \"%s\", \"quantity\": 3}]}", item));

        Response response = apiClient.post("bag/v1/items", requestSpecification);
        initRequestSpecification();

        return response;
    }

    @Step("Получаем все товары из корзины")
    public Response getAllItemsInCart() {
        requestSpecification.header("Authorization", "Bearer " + TestData.accessToken);

        Response response = apiClient.get("bag/v1", requestSpecification);
        initRequestSpecification();

        return response;
    }

    @Step("Обновляем данные товара {item} из корзины")
    public Response updateItemInCart(String item) {
        requestSpecification.header("Authorization", "Bearer " + TestData.accessToken)
                .contentType(ContentType.JSON)
                .body(String.format("{\"items\":[{\"skuId\": \"%s\",\"quantity\":2,\"itemId\":\"%s\"}]}", item, BagData.itemId));

        Response response = apiClient.patch("bag/v1/items", requestSpecification);
        initRequestSpecification();

        return response;
    }

    @Step("Удаляем товар {item} из корзины")
    public Response removeItemFromCart(String item) {
        requestSpecification.header("Authorization", "Bearer " + TestData.accessToken)
                .queryParam("itemIds", item);

        Response response = apiClient.delete("bag/v1/items", requestSpecification);
        initRequestSpecification();

        return response;
    }
}
