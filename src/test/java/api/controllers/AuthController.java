package api.controllers;

import api.utils.Constants;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ui.utils.LoggerUtil;

import static api.utils.Constants.BASE_URL;
import static api.utils.Constants.COOKIES;
import static io.restassured.RestAssured.given;

public class AuthController {

    private final RequestSpecification requestSpecification = given();

    public AuthController() {
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.filter(new AllureRestAssured());
    }

    @Step("Получаем токен Guest")
    public Response getAccessTokenGuest() {

        LoggerUtil.info("Получаю токен Guest");

        requestSpecification.header("Authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==")
                .formParam("grant_type", "client_credentials");

        Response response = given(requestSpecification).post("auth/oauth/v5/token");
        Constants.accessTokenGuest = response.body().jsonPath().getString("access_token");

        return response;
    }

    @Step("Получаем токен User")
    public Response getAccessTokenUser() {

        LoggerUtil.info("Получаю токен User");

        Constants.createAccessTokenGuest();

        requestSpecification.header("Authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==")
                .header("x-access-token", Constants.accessTokenGuest)
                .header("Cookie", COOKIES)
                .formParams("grant_type", "password")
                .formParam("username", "Test1@email.ru")
                .formParam("password", "123456qaz");

        Response response = given(requestSpecification).post("auth/oauth/v4/token");
        Constants.accessTokenUser = response.body().jsonPath().getString("access_token");
        return response;
    }
}
