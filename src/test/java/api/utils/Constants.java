package api.utils;

import api.controllers.AuthController;

import java.util.List;
import java.util.Map;

public final class Constants extends BaseTest {

    public static String accessToken;
    public static String BASE_URL = "https://www.ae.com/ugp-api/";

    public static void getAccessToken() {

        AuthController authController = new AuthController();

        accessToken = authController
                .getAccessToken()
                .body().jsonPath().getString("access_token");
    }

    public final static class BagData {
        public static final String SKUID_WOMEN = "0043270800";
        public static final String SKUID_MEN = "0043421387";

        public static String cartId;
        public static List<Map<String, Object>> items;
    }
}