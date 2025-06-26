package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.rootPath;

public class AuthTest {

    @Test
    public void testGetTokenGuest() {
        Response response = RestAssured.given()
                .header("Authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==")
                .header("aelang", "en_US")
                .header("aesite", "AEO_US")
                .header("aecountry", "US")
                .when()
                .formParam("grant_type", "client_credentials")
                .post("https://www.ae.com/ugp-api/auth/oauth/v5/token")
                .then()
                .extract().response();
        System.out.println(response.body().jsonPath().getString(rootPath));

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
