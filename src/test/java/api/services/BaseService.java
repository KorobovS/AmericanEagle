package api.services;

import api.utils.ApiClient;
import api.utils.Specification;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseService {

    protected RequestSpecification requestSpecification;
    protected ApiClient apiClient = ApiClient.getInstance();
    protected static final Logger LOGGER = LogManager.getLogger();

    protected void initRequestSpecification() {
        requestSpecification = RestAssured.given().spec(Specification.installRequest());
    }

    {
        initRequestSpecification();
    }
}
