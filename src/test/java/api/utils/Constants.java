package api.utils;

import api.controllers.AuthController;

import java.util.List;
import java.util.Map;

public final class Constants extends BaseTest {

    public static String accessTokenGuest;
    public static String accessTokenUser;
    public static String BASE_URL = "https://www.ae.com/ugp-api/";
    public static String COOKIES = "QuantumMetricSessionID=0fedeb7941e704eaf46813bccfbe016b; TLTUID=67D7F9C9F202C5110972F7C1DCDD69CA; akaalb_PROD_ALB=~op=PROD_LB_ALL_DCs:PROD_LB_Origin_East4_AGWA_Service_Mesh|~rv=12~m=PROD_LB_Origin_East4_AGWA_Service_Mesh:0|~os=db0ecb8ead961a2983478ea211c488b6~id=26fa3b8e2c9a7be7000ceea69438b67d; aeoStyliticsSegment=true; optimizelyEndUserId=72d36675-4241-4a75-8536-cdf44204aad5; aeoUserIp=109.248.173.67; aeoUserLocation=RU:; ae_clarip_consent=0,1,2,3; ae_clarip_ab_segment=true; brand=aeo; ak_bmsc=0D8D7A4D07189C8D08863459673C8018~000000000000000000000000000000~YAAQbAxAF+JsH6+XAQAArMctwRxXJApa7JdyR9lrfXQDOfDDnah4IXVDDF/3SjAnYf9pKaF1c1b32y6frLhqNu12hnqcRNXwOkjeFQu59fbubEKLmh1xZJW5ILDRGjKRmcdtt23vOb+ap5IHJkcw5gZqRBbplkGOqTynuBFoqE5l0OHaAiAQH6KC2b4O7w/pEx+QdX0ffUVrQaTmMlioWHEYuMRwxmMj3fKIS/wdUyrqoSKsjNbSNHS0snIERgevprWjxqm3m8aBUGVTJpIXh/Q4xxe1ZtDnAfs4tFOekfzBxq4KnWKw+0y61WRGLRkHSadJl+YpoIIYECKaihIuEI5KaPqjYWs5AkLpl78Gom7+axTeZHWsU0upmmP8PzSa5GbCO8pzRnnzjwLggvYvzHu25w8i4/jhSRGYArzIwjpXjAmxfd18nQp0TwWIi8wXEtLkKCIuZK0=; akaalb_PROD_ALB_API=~op=PROD_LB_APICG_EAST5:PROD_LB_Origin_APICG_East5|~rv=60~m=PROD_LB_Origin_APICG_East5:0|~os=db0ecb8ead961a2983478ea211c488b6~id=74c6f21e90226a108e6a12b89c6a32b2; tkbl_session=43ac33e6-f9d6-4435-9e4e-8fac4baa4bc7; ConstructorioID_client_id=c36c928c-632d-4977-839a-3b4fbb6e0f7b; ConstructorioID_session_id=1; ConstructorioID_session={\"sessionId\":1,\"lastTime\":1751292691409}; swim_ten=f; acquisition_value=; acquisition_location=https://www.ae.com/us/en; acquisition_location_gtm=https://www.ae.com/us/en; acquisition_value_gtm=; _ga=GA1.1.213600151.1751292692; _br_uid_2=uid%3D4101334484443%3Av%3D17.0%3Ats%3D1751292693313%3Ahc%3D1; __rtbh.lid=%7B%22eventType%22%3A%22lid%22%2C%22id%22%3A%227Mymqfnx6yevGzB6RL9j%22%2C%22expiryDate%22%3A%222026-06-30T14%3A11%3A33.332Z%22%7D; _scid=8Ssk2-jFZH9JS9ySjAMPvu8w4Fq2IHRU; _scid_r=8Ssk2-jFZH9JS9ySjAMPvu8w4Fq2IHRU; cjConsent=MHxOfDB8Tnww; cjUser=1e350ee8-2d57-4b50-8729-039950820d82; _tt_enable_cookie=1; _ttp=01JZ0JVN476AWBJV8FV3PM2CSQ_.tt.1; _sctr=1%7C1751230800000; __exponea_etc__=c60b885a-fc65-42b3-8546-b23ce79357f1; _pin_unauth=dWlkPU56STFOakkzWmpZdFlqYzFPQzAwTTJGaExUZ3dObU10WlRReE9URmpORFEwTVRaaA; _ScCbts=%5B%5D; __exponea_time2__=2.569058895111084; QuantumMetricUserID=f65a5b5f295d59a00a34893fafe2fe8d; _li_dcdm_c=.ae.com; _lc2_fpi=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; _lc2_fpi_js=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; _gcl_au=1.1.887176511.1751292694.1027081526.1751292759.1751292765; _geffran=1; geuid=c8b256cf-7d54-4a93-91a1-6a1852a64687; _gecntaos=MQ==; _gepi=true; _geps=true; ae_i18n=en|US|USD|US|us; ae_lang=en; user_profile_id=ugp21925413135; _gekf=dGVzdDFAZW1haWwucnU=; _gess=true; _getdran=3; BVBRANDID=44877675-8d7e-4971-bb23-e12462a2c18f; granify.uuid=7df4f133-8ef2-4108-a17b-19ba0605d513; granify.new_user.sxkhw=true; bm_sz=CF0EF3FBB13C5C80DADAA7D0062D10FE~YAAQbAxAFyR4H6+XAQAAQtUvwRx2vArvh8DnJoq10tG+L2F4R4yCKM2PZuAj6pyt4meWeLAGDkFOpVQ+18QCxFJ+3RwIKJAp/lE9xfrCRj/k7FKE7rSTUBrIpY2ik6Mh6yZdpWDKLVcTp+5iPI9BpOeJ3zxA3o03WJwXczALwBAdS3h5zWqG8lQSSd3Cvz8Fo1DiFYTYNDNHOVjjMQ0HT+P/rDjTbpOBcj8rgukXsZgbazolMH69xZ2JE2ZxbrKu3qZsi0vIPRBmskHpJmsf7LteUKB+52Jyq8TCbyeWDBagZcnaf6l1eS/4ZxrZCdjmVqI7GG1TzI7ILe104Ru4HYhHCMbPuAY8A6OD1xN9yP2PcCj5pVER3xzuYmEL/yrCjnkzuaiqFaN6F23Q47cJiXF1CAwOpm1wqv571xn1z1ZvvTk=~4471092~3621685; aeoUserJourney=journey-user-scrolled%2Cjourney-users-who-added-item-to-bag; optimizelySession=1751292824993; __rtbh.uid=%7B%22eventType%22%3A%22uid%22%2C%22id%22%3A%223072e1c2944698b39664ce877329441c0216cbe419616aa62b9d0d3f8c5ee7ae%22%2C%22expiryDate%22%3A%222026-06-30T14%3A13%3A45.242Z%22%7D; utag_main=v_id:0197c12dc3dd00192121f189db330506f001806700bd0$_sn:1$_se:16$_ss:0$_st:1751294625034$ses_id:1751292691423%3Bexp-session$_pn:1%3Bexp-session$_prevpage:AE%3Amen%3Aaccessories_socks%3Asunglasses%3Apdp%3Bexp-1751296425037$dc_visit:1$dc_event:4%3Bexp-session$dc_region:eu-central-1%3Bexp-session; ttcsid=1751292695723::za_ahXCKRFWN2PQz9wjc.1.1751292825387; _ga_XGBGNYD4S1=GS2.1.s1751292692$o1$g1$t1751292825$j43$l0$h1177984100; ttcsid_C0HVR0KP76SVVJ0UU9SG=1751292695722::0DU1hZYidgVxArq0yYns.1.1751292825623; bm_sv=CF33A679BD3A425A4BFA3697895CAA39~YAAQbAxAF0l4H6+XAQAAm9wvwRxsYcPqgwr6kZd9Mplc02MkMBxJGqMi5dg7ePHW9KXrPaHw1ut7gBHLvFOAyA1RgQWCpVhwVKEdIobhp1T5tpITkBJLARD+DEf/B0FW/iAaEaIOXkmlZ/OkwBAvQvbakKtVbSgyZWwc2j0dYm6FsbMNk8Q8k878l+8A/nbxgfiqRmRTiSZR3D04HA5AOgb4uZvbR7TctLGb46SxwW0F9KHdDsJ18OlOFwhU~1; granify.session.sxkhw=-1; _abck=0015414213531594FB3FD2EA87A3B272~-1~YAAQbAxAF6EgIK+XAQAA17dSwQ6v3X+FA+f+owDPNZuWl7FT3mAqxHyFIRx+8zBR42mPn6HqYff+rvOP2jeFrIcG0GJcrjrbhIv6DJKaFpHYHVkDSuQpzAiraznOMjUhRnU05mWXscvPkBpFf3RXB9pcvLWNa/ErlCbul5LBgpSbL1eX5Ha6p+3qhcTeH/0oNkMRPI8moLuMGKQwcNXBwcRuxORM0d+aKWu9tynDhMLXKa+18gUyJLreaAudgxNa+ixaYzbxNo82s6/KoM8q8zRqwlgLjBy6fi4iUv9pnSC0do38gkTVG2NaXQEcCwsYWi4HtNsgT9lqX5yayOyIICKvoCVgaTmcesTWmXwJtYIN15moM9xChsGKHdhzCQvtnoBVfGqTbUGpwe8LcwuoUhBfW4LsZ12/D5DfqN9eW4DbN0Zlf8dC6IldMqK3PPDIPkfSK+wYhEQPGlWQyTfpZYbAQEAIV0E6Ir25jdr7LKCg6oVnUe0vjNhVdDiNWpOxj/PrvvtbXVgJm5IhoKFqTFUsQV2gvSMEptr45FXD3+xRtb+8kh+BsLSqWtYyMuTuVwfonCDwhoJaXmoXCaUMTYslUiv4Ef388MwGcEsEvw3ODVphi0rlUE6HlUwXKwyBwnTgsMsjQ1F+zZb4D85KP8dgb4K5AGIs9oaajyZl1RBTX4kQcZHiBjAwGQtX7edAhX4G9yI4aDJlA+hljTaclX+dwFTFAmBTCE47lJkOMZbpo7nQ6Oypjq29U3dSXPSt6/1hbNkcBiiF3aKcTET3TD1RI5ypuMOfslrehi6Br6g+9lvlnb4gv2vgvuWbBpPNcCXdoYW4WKXUPjQoocsiuwvFMNBpBDmY~-1~-1~-1";

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