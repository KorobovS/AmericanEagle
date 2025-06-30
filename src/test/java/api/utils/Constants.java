package api.utils;

import api.controllers.AuthController;

import java.util.List;
import java.util.Map;

public final class Constants extends BaseTest {

    public static String accessTokenGuest;
    public static String accessTokenUser;
    public static String BASE_URL = "https://www.ae.com/ugp-api/";
    public static String COOKIES = "QuantumMetricSessionID=0fedeb7941e704eaf46813bccfbe016b; TLTUID=67D7F9C9F202C5110972F7C1DCDD69CA; akaalb_PROD_ALB=~op=PROD_LB_ALL_DCs:PROD_LB_Origin_East4_AGWA_Service_Mesh|~rv=12~m=PROD_LB_Origin_East4_AGWA_Service_Mesh:0|~os=db0ecb8ead961a2983478ea211c488b6~id=26fa3b8e2c9a7be7000ceea69438b67d; aeoStyliticsSegment=true; optimizelyEndUserId=72d36675-4241-4a75-8536-cdf44204aad5; aeoUserIp=109.248.173.67; aeoUserLocation=RU:; ae_clarip_consent=0,1,2,3; ae_clarip_ab_segment=true; brand=aeo; ak_bmsc=0D8D7A4D07189C8D08863459673C8018~000000000000000000000000000000~YAAQbAxAF+JsH6+XAQAArMctwRxXJApa7JdyR9lrfXQDOfDDnah4IXVDDF/3SjAnYf9pKaF1c1b32y6frLhqNu12hnqcRNXwOkjeFQu59fbubEKLmh1xZJW5ILDRGjKRmcdtt23vOb+ap5IHJkcw5gZqRBbplkGOqTynuBFoqE5l0OHaAiAQH6KC2b4O7w/pEx+QdX0ffUVrQaTmMlioWHEYuMRwxmMj3fKIS/wdUyrqoSKsjNbSNHS0snIERgevprWjxqm3m8aBUGVTJpIXh/Q4xxe1ZtDnAfs4tFOekfzBxq4KnWKw+0y61WRGLRkHSadJl+YpoIIYECKaihIuEI5KaPqjYWs5AkLpl78Gom7+axTeZHWsU0upmmP8PzSa5GbCO8pzRnnzjwLggvYvzHu25w8i4/jhSRGYArzIwjpXjAmxfd18nQp0TwWIi8wXEtLkKCIuZK0=; akaalb_PROD_ALB_API=~op=PROD_LB_APICG_EAST5:PROD_LB_Origin_APICG_East5|~rv=60~m=PROD_LB_Origin_APICG_East5:0|~os=db0ecb8ead961a2983478ea211c488b6~id=74c6f21e90226a108e6a12b89c6a32b2; tkbl_session=43ac33e6-f9d6-4435-9e4e-8fac4baa4bc7; ConstructorioID_client_id=c36c928c-632d-4977-839a-3b4fbb6e0f7b; swim_ten=f; acquisition_value=; acquisition_location=https://www.ae.com/us/en; acquisition_location_gtm=https://www.ae.com/us/en; acquisition_value_gtm=; _ga=GA1.1.213600151.1751292692; _scid=8Ssk2-jFZH9JS9ySjAMPvu8w4Fq2IHRU; cjConsent=MHxOfDB8Tnww; cjUser=1e350ee8-2d57-4b50-8729-039950820d82; _tt_enable_cookie=1; _ttp=01JZ0JVN476AWBJV8FV3PM2CSQ_.tt.1; _sctr=1%7C1751230800000; __exponea_etc__=c60b885a-fc65-42b3-8546-b23ce79357f1; _pin_unauth=dWlkPU56STFOakkzWmpZdFlqYzFPQzAwTTJGaExUZ3dObU10WlRReE9URmpORFEwTVRaaA; _ScCbts=%5B%5D; QuantumMetricUserID=f65a5b5f295d59a00a34893fafe2fe8d; _li_dcdm_c=.ae.com; _lc2_fpi=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; _lc2_fpi_js=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; geuid=c8b256cf-7d54-4a93-91a1-6a1852a64687; _gepi=true; _geps=true; _gess=true; _getdran=3; BVBRANDID=44877675-8d7e-4971-bb23-e12462a2c18f; granify.uuid=7df4f133-8ef2-4108-a17b-19ba0605d513; granify.new_user.sxkhw=true; aeoUserJourney=journey-user-scrolled%2Cjourney-users-who-added-item-to-bag; optimizelySession=0; granify.session.sxkhw=-1; ConstructorioID_session_id=2; ConstructorioID_session={\"sessionId\":2,\"lastTime\":1751298135727}; _br_uid_2=uid%3D4101334484443%3Av%3D17.0%3Ats%3D1751292693313%3Ahc%3D2; _scid_r=Cqsk2-jFZH9JS9ySjAMPvu8w4Fq2IHRUR_sc_Q; __rtbh.lid=%7B%22eventType%22%3A%22lid%22%2C%22id%22%3A%227Mymqfnx6yevGzB6RL9j%22%2C%22expiryDate%22%3A%222026-06-30T15%3A42%3A17.545Z%22%7D; __exponea_time2__=2.382534980773926; _geffran=2; _gecntaos=MQ==; _geaos=true; _gekf=dGVzdDFAZW1haWwucnU=; user_profile_id=undefined; __rtbh.uid=%7B%22eventType%22%3A%22uid%22%2C%22id%22%3A%22%22%2C%22expiryDate%22%3A%222026-06-30T15%3A47%3A21.317Z%22%7D; utag_main=v_id:0197c12dc3dd00192121f189db330506f001806700bd0$_sn:3$_se:12$_ss:0$_st:1751300238788$_prevpage:AE%3Acart%3Aui%3Bexp-1751302038793$dc_visit:3$ses_id:1751297165865%3Bexp-session$_pn:2%3Bexp-session$dc_event:3%3Bexp-session$dc_region:eu-central-1%3Bexp-session; _ga_XGBGNYD4S1=GS2.1.s1751297172$o3$g1$t1751298442$j60$l0$h530885893; bm_sz=CF0EF3FBB13C5C80DADAA7D0062D10FE~YAAQbAxAF4wPIa+XAQAAVe+FwRwMdqhfI7b4MdPHbBjgqzmcl8tkSZQW+4YhxoTgWCPrytafTZmpntvPIiWfPWzzIW2lHf/ViyWRLdR2wnf65LL8YsJvJmXuTKs9eOuiEz1D8AsHQzGP7B6NY96odgIJScUfMJ0yK14yHR0SkJH0VQHR6IUixELQ6DyI5I1RU/V04WfYRnEv0p/2LWofGA33671j8Y5hJCLKuhezwoN5re/PxHbpV6vp/8us+4NY4Ie89sbZoYWcPuXPIy5XJAu0Ck8IlzMW6IHJEGnfgYzCiH2SwGtD7OaIorpoOS851PJrB42VppQ1IF14eUKNAO85oWyxWbJaWDDOLFSoy8AV7z5tLRFfax1hcrdhuducHTK0G8HyzBVG/Wzuy9Q06lBLoDJnprRcZo1J9wLWon8qH0AALilGo2Z2faNKpwCBRXpr7VvJtt7kC8o=~4471092~3621685; ttcsid_C0HVR0KP76SVVJ0UU9SG=1751297168535::_bHqLNtKwDiQvhWqqFpt.3.1751298486218; ttcsid=1751297171631::2rEwlW0O_d1vpQR5xQze.3.1751298486219; _abck=0015414213531594FB3FD2EA87A3B272~-1~YAAQbAxAF7UQIa+XAQAAijqGwQ5tQvp0zG2N6QmJVP5J+RGTGWvkwmvSE9u1xxgFyKSkiUNHyGxG6yGNaIAIbsZu4Xb9kUmzU5+/NBT37tqxl7lpfp6e7Mxxfemr6R0roSD0/quMGStj80/OgArO6csqCoXNyamuHxugtnESM+iVuMEgzsQseZedRWrJAjfhgFyoDvVfshYL52ddznXiEVudw9OsK3S6KZSeETQz9y0Sg6Fq2d2KLW6OOBWmVZlDobOgi9KrX3fCG49pbeG9XXsYBWkBtVKC3U6IZnOBJIcEz72Daw2SQUwnabqE22e2ecwE0RWqVaccO+raKDyf2N1CswlLCRojt2xgXEDDbSXBcbwUxYFtQpaycVM8G7JfzJXF08rZkAB7FrKgq46pMPYzdWF/WDxN0SjM3/aZW3q0raeuzMOBda63xgf/EC8jDGMsRybecnMd/RgAbnbF0Tjp8v3pwAZB3meyaIADjax2JzkT4DKDFJi7zmlu7/4EMC6cg+dkOcw7EwP3vlhBnRXNcV2Pw2fds6rmQ+cJJxpS2YLfddIfmBfY2Wcagn/svSQkugwAkB8uk+6PY1F2/TZiszjDguPN1NDvMK8eJrDOq1LBN3BHI5oTIRVPchGGPsyA8itMdvTO1eYAa9sVosmod3rU7cZSnyzxhenOhnkpGdaUSZSS80H4Gfg5QF9r4I4HHPKym7F5UHJKmrriyZIIkKmnoseMmGA1jYHO7lGbWtWfAE5iLWHnofh00kE4HtSu1L7I8ICaZA3QjZDJMlV2vRUhpdFuwfxwWPnu+6WLVQJSo4uTNlkytGb1vHNQGA0cCb9sP8u8SHFzTtbzrJYN8IrN2NLe17k+b5PVbh61DLfqeyi47ZyuGjlWZ/dB0pJKKlbAhXFyINV05RoM4S11/j1++pt7EbJChcptCQ==~-1~||0||~-1; _gcl_au=1.1.887176511.1751292694.1527771561.1751298459.1751298486; bm_sv=CF33A679BD3A425A4BFA3697895CAA39~YAAQbAxAF78QIa+XAQAALT2GwRwT92bUL/n1T0ZKzwEhYDjKpuyIOrazPXqmp0Gdp5Ow2luUg5W1dEMpHgUvlVTW4fBtjVKtVq6/YomoaHNZaUK5Zl0yb56OE72eCo8dtW4ZRKrtlzJ/O/1Yj9eHaHG+U2YB5P6PUh8jOR1KaThcNLHWlYZX4aqp81/jPJ0jYm+9WagVox3xa/a61thzntDHjo6gE/yJB9mzScdiuhZMYTjJd3jx6Qkjm/wR~1";

    public static void createAccessTokenGuest() {

        AuthController authController = new AuthController();

        accessTokenGuest = authController
                .getAccessTokenGuest()
                .body().jsonPath().getString("access_token");
    }

    public static void createAccessTokenUser() {
        AuthController authController = new AuthController();

        accessTokenUser = authController
                .getAccessTokenUser()
                .body().jsonPath().getString("access_token");
    }

    public final static class BagData {
        public static final String SKUID_WOMEN = "0043270800";
        public static final String SKUID_MEN = "0043421387";

        public static String cartId;
        public static List<Map<String, Object>> items;
    }
}