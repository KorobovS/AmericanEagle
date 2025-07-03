package api.controllers;

import api.models.Product;
import api.utils.Constants;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.LoggerUtil;

import static api.utils.Constants.BASE_URL;
import static api.utils.Constants.accessTokenGuest;
import static io.restassured.RestAssured.given;

public class ProductGuestController {

    private final RequestSpecification requestSpecification = given();

    public ProductGuestController() {
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.filter(new AllureRestAssured());
        requestSpecification.header("x-access-token", accessTokenGuest);
        requestSpecification.header("Authorization", "Bearer " + accessTokenGuest);
    }

    @Step("Получаю товар {skuId}")
    public Response getProduct(String skuId) {
        LoggerUtil.info(String.format("Получаю товар %s", skuId));

        requestSpecification.contentType(ContentType.JSON)
                .param("productIds", skuId);

        Response response = given(requestSpecification).when().get("catalog/v1/product/sizes");
        Constants.ProductData.product = response.body().jsonPath().getObject("data.records[0].sizes", Product.class);

        return response;
    }
}
