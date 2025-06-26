package api.services;

import api.utils.ApiClient;
import api.utils.Specification;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    protected RequestSpecification requestSpecification;
    protected ApiClient apiClient = ApiClient.getInstance();

    protected void initRequestSpecification() {
        requestSpecification = RestAssured.given().spec(Specification.installRequest());
    }

    {
        initRequestSpecification();
    }
}
