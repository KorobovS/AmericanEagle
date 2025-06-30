package api.controllers;

import api.utils.Constants;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class BagController {

    private static final Logger LOGGER = LogManager.getLogger();
    private final RequestSpecification requestSpecification = given();

    public BagController() {
        requestSpecification.baseUri("https://www.ae.com/ugp-api/");
        requestSpecification.filter(new AllureRestAssured());
        requestSpecification.header("aelang", "en_US");
        requestSpecification.header("aesite", "AEO_US");
        requestSpecification.header("aecountry", "US");
        requestSpecification.header("Authorization", "Bearer " + Constants.accessToken);
        requestSpecification.log().all();
    }

    @Step("Добавляю товар {item} в корзину")
    public Response addItemToCart(String item) {
        LOGGER.info("Добавляю товар {} в корзину", item);

        requestSpecification.contentType(ContentType.JSON)
                .body(String.format("{\"items\": [{\"skuId\": \"%s\", \"quantity\": 3}]}", item));

        Response response = given(requestSpecification).when().post("bag/v1/items");
        Constants.BagData.cartId = response.body().jsonPath().getString("cartId");

        return response;
    }

    @Step("Получаю все товары из корзины")
    public Response getAllItemsInCart() {
        LOGGER.info("Получаю все товары из корзины");

        Response response = given(requestSpecification).when().get("bag/v1");
        Constants.BagData.itemId = response.body().jsonPath().getString("data.items[0].itemId");

        return response;
    }

    @Step("Обновляю данные о товаре {item} в корзине")
    public Response updateItemInCart(String item, String body) {
        LOGGER.info("Обновляю данные о товаре {} в корзине", item);

        requestSpecification.contentType(ContentType.JSON)
                .body(body);

        Response response = given(requestSpecification).when().patch("bag/v1/items");

        return response;
    }

    @Step("Удаляю товар {item} из корзины")
    public Response removeItemFromCart(String item) {
        LOGGER.info("Удаляю товар {} из корзины", item);

        requestSpecification.queryParam("itemIds", item);

        Response response = given(requestSpecification).when().delete("bag/v1/items");

        return response;
    }
}
