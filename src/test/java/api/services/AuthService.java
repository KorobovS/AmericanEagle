package api.services;

import api.utils.TestData;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AuthService extends BaseService {

    @Step("Получаем токен Guest")
    public Response getAccessToken() {
        requestSpecification.header("Authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==")
                .formParam("grant_type", "client_credentials");

        Response response = apiClient.post("auth/oauth/v5/token", requestSpecification);
        TestData.accessToken = response.body().jsonPath().getString("access_token");
        initRequestSpecification();

        return response;
    }
}
