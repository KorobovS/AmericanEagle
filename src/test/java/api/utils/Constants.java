package api.utils;

import api.services.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Constants extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    public static String accessToken;
    public static String BASE_URL = "https://www.ae.com/ugp-api/";

    public static void getAccessToken() {
        LOGGER.info("Получаю токен Guest");

        AuthService authService = new AuthService();
        accessToken = authService
                .getAccessToken()
                .body().jsonPath().getString("access_token");
    }

    public final static class BagData {
        public static final String SKUID_WOMEN = "0043270800";
        public static final String SKUID_MEN = "0043421387";

        public static String cartId;
        public static String itemId;
    }
}