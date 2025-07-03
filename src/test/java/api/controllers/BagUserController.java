package api.controllers;

import api.utils.Constants;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.LoggerUtil;

import static api.utils.Constants.BASE_URL;
import static api.utils.Constants.BagData.cartId;
import static api.utils.Constants.BagData.items;
import static api.utils.Constants.COOKIES;
import static io.restassured.RestAssured.given;

public class BagUserController {

    private final RequestSpecification requestSpecification = given();

    public BagUserController() {
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.filter(new AllureRestAssured());
        requestSpecification.header("aesite", "AEO_US");
        requestSpecification.header("x-access-token", Constants.accessTokenUser);
        requestSpecification.header("Cookies", COOKIES);
    }

    @Step("Добавляю товар {skuId} в корзину")
    public Response addItemToCartUser(String skuId, int quantity) {
        LoggerUtil.info(String.format("Добавляю товар %s в корзину", skuId));

        requestSpecification.contentType(ContentType.JSON)
                .body(String.format("{\"items\": [{\"skuId\": \"%s\", \"quantity\": %d}]}", skuId, quantity));

        Response response = given(requestSpecification).when().post("bag/v1/items");
        cartId = response.body().jsonPath().getString("cartId");

        return response;
    }

    @Step("Получаю все товары из корзины")
    public Response getAllItemsInCartUser() {
        LoggerUtil.info("Получаю все товары из корзины");

        Response response = given(requestSpecification).when().get("bag/v1");
        items = response.body().jsonPath().getList("data.items");

        return response;
    }

    @Step("Обновляю данные о товаре {skuId} в корзине")
    public Response updateItemInCart(String skuId, int quantity, String itemId) {
        LoggerUtil.info(String.format("Обновляю данные о товаре %s в корзине", skuId));

        String body = String.format("{\"items\":[{\"skuId\": \"%s\",\"quantity\":%d,\"itemId\":\"%s\"}]}", skuId, quantity, itemId);

        requestSpecification.contentType(ContentType.JSON)
                .body(body);

        return given(requestSpecification).when().patch("bag/v1/items");
    }

    @Step("Удаляю товар {item} из корзины")
    public Response removeItemFromCart(String item) {
        LoggerUtil.info(String.format("Удаляю товар %s из корзины", item));

        requestSpecification.queryParam("itemIds", item);

        return given(requestSpecification).when().delete("bag/v1/items");
    }
}
