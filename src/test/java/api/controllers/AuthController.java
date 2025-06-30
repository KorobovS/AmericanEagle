package api.controllers;

import api.utils.Constants;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static api.utils.Constants.BASE_URL;
import static io.restassured.RestAssured.given;

public class AuthController {

    private final RequestSpecification requestSpecification = given();

    public AuthController() {
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.filter(new AllureRestAssured());
    }

    @Step("Получаем токен Guest")
    public Response getAccessToken() {
        requestSpecification.header("Authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==")
                .formParam("grant_type", "client_credentials");

        Response response = given(requestSpecification).post("auth/oauth/v5/token");
        Constants.accessToken = response.body().jsonPath().getString("access_token");

        return response;
    }
}
