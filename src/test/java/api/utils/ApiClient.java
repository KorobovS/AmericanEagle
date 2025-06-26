package api.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiClient {

    private static ApiClient instance;
    private static final Logger LOGGER = LogManager.getLogger();

    public static ApiClient getInstance() {

        if (instance == null) {
            LOGGER.info("Создаю новый ApiClient");
            instance = new ApiClient();
        }

        LOGGER.info("Возвращаю ApiClient");
        return instance;
    }

    public Response get(String path, RequestSpecification requestSpecification) {

        return requestSpecification.get(path);
    }

    public Response post(String path, RequestSpecification requestSpecification) {

        return requestSpecification.post(path);
    }

    public Response patch(String path, RequestSpecification requestSpecification) {

        return requestSpecification.patch(path);
    }

    public Response delete(String path, RequestSpecification requestSpecification) {

        return requestSpecification.delete(path);
    }
}
