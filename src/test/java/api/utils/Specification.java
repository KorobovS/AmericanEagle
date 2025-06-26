package api.utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public static RequestSpecification installRequest() {

        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .addHeader("aelang", "en_US")
                .addHeader("aesite", "AEO_US")
                .addHeader("aecountry", "US")
                .setBaseUri("https://www.ae.com/ugp-api/")
                .build();
    }
}
