package api.utils;

import api.services.AuthService;

public final class TestData extends BaseTest {

    public static String accessToken;


    public static void getAccessToken() {
        AuthService authService = new AuthService();
        accessToken = authService
                .getAccessToken()
                .body().jsonPath().getString("access_token");
    }

    public final static class BagData {
        public static final String SKUID = "0043043660";

        public static String cartId;
        public static String itemId;
    }
}