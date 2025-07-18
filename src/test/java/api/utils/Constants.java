package api.utils;

import api.controllers.AuthController;
import api.models.Product;
import api.models.Sku;

import java.util.List;
import java.util.Map;

public final class Constants extends BaseTest {

    public static String accessTokenGuest;
    public static String accessTokenUser;
    public static String BASE_URL = "https://www.ae.com/ugp-api/";
    public static String COOKIES = "TLTUID=67D7F9C9F202C5110972F7C1DCDD69CA; akaalb_PROD_ALB=~op=PROD_LB_ALL_DCs:PROD_LB_Origin_East4_AGWA_Service_Mesh|~rv=12~m=PROD_LB_Origin_East4_AGWA_Service_Mesh:0|~os=db0ecb8ead961a2983478ea211c488b6~id=26fa3b8e2c9a7be7000ceea69438b67d; aeoStyliticsSegment=true; optimizelyEndUserId=72d36675-4241-4a75-8536-cdf44204aad5; aeoUserIp=109.248.173.67; aeoUserLocation=RU:; ae_clarip_consent=0,1,2,3; ae_clarip_ab_segment=true; brand=aeo; akaalb_PROD_ALB_API=~op=PROD_LB_APICG_EAST5:PROD_LB_Origin_APICG_East5|~rv=60~m=PROD_LB_Origin_APICG_East5:0|~os=db0ecb8ead961a2983478ea211c488b6~id=74c6f21e90226a108e6a12b89c6a32b2; tkbl_session=43ac33e6-f9d6-4435-9e4e-8fac4baa4bc7; ConstructorioID_client_id=c36c928c-632d-4977-839a-3b4fbb6e0f7b; swim_ten=f; acquisition_value=; acquisition_location=https://www.ae.com/us/en; acquisition_location_gtm=https://www.ae.com/us/en; acquisition_value_gtm=; _ga=GA1.1.213600151.1751292692; _scid=8Ssk2-jFZH9JS9ySjAMPvu8w4Fq2IHRU; cjConsent=MHxOfDB8Tnww; cjUser=1e350ee8-2d57-4b50-8729-039950820d82; _tt_enable_cookie=1; _ttp=01JZ0JVN476AWBJV8FV3PM2CSQ_.tt.1; _sctr=1%7C1751230800000; __exponea_etc__=c60b885a-fc65-42b3-8546-b23ce79357f1; _pin_unauth=dWlkPU56STFOakkzWmpZdFlqYzFPQzAwTTJGaExUZ3dObU10WlRReE9URmpORFEwTVRaaA; _ScCbts=%5B%5D; QuantumMetricUserID=f65a5b5f295d59a00a34893fafe2fe8d; _li_dcdm_c=.ae.com; _lc2_fpi=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; _lc2_fpi_js=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; geuid=c8b256cf-7d54-4a93-91a1-6a1852a64687; _gepi=true; _geps=true; _gess=true; _getdran=3; BVBRANDID=44877675-8d7e-4971-bb23-e12462a2c18f; granify.uuid=7df4f133-8ef2-4108-a17b-19ba0605d513; granify.new_user.sxkhw=true; aeoUserJourney=journey-user-scrolled%2Cjourney-users-who-added-item-to-bag; optimizelySession=0; granify.session.sxkhw=-1; ConstructorioID_session_id=2; X-AK-PIM-INJECT=sync; _geffran=3; __rtbh.lid=%7B%22eventType%22%3A%22lid%22%2C%22id%22%3A%227Mymqfnx6yevGzB6RL9j%22%2C%22expiryDate%22%3A%222026-06-30T16%3A13%3A32.889Z%22%7D; _br_uid_2=uid%3D4101334484443%3Av%3D17.0%3Ats%3D1751292693313%3Ahc%3D6; _scid_r=Dqsk2-jFZH9JS9ySjAMPvu8w4Fq2IHRUR_sc8Q; ConstructorioID_session={\"sessionId\":2,\"lastTime\":1751300013555}; _gecntaos=MQ==; _gekf=dGVzdDFAZW1haWwucnU=; QuantumMetricSessionID=cce102979643b9ac4bcb8eec4263def4; ak_bmsc=1353AA34E65BBC0716BEEDAA335FFB05~000000000000000000000000000000~YAAQmQcQAo8i97GXAQAAXPZowhyW7G/ACGCdGQJFSMqdbIof7qGxTLwJMFvoDpU/NgACCye8a8Eny7bNT9S2HWhp2W2Qft42zkAkESYvpqV3kcoPjvuZxHktfJQa4+Sn0GmOASFXi0+RyjZynqZ89hYkAbpvi5R8vukTiSqWDKgwumMovGeknYtHLu86XW6yuF08xc4QKNTFIevnMYzohMMwqTPLBRkDnGq58tgALOlesGQgJ+5LNNXwclFo2qPlogk5K9ypXsAqHgv5sXz2ZdT8rlXC9SDHGCnhzLM5URJpX2DbgVbEKEdwypM0VIF8UcfaOuweQG+7HpiCQ8xPWQbJeL8eAAOSSQocvVOp+PnHE3ZrnncoqTJsb8lipP63Loo8AQZY5A==; bm_sz=D4073A763F5BF00ACB38D7B4580ECB97~YAAQmQcQArIj97GXAQAAtftowhz4AejNHUe26vFWhzVobuWGhDYXg7F6nfWllzUttETbw/Pj9r3hg3PMjsK7bKbiUZtQM1i2taJbgK+OJdudrbCSxHvmIHviKGnn3rV3yBLCwVOs2y9J/uvO3lF+TYpRXuia20PZzJ+xPXSMxA6mTZ90UMiJgr01TgB7ZeyT6LgH1e46xJvYmjFuIqdsxWZ03pnQZEyYgmmDp1s2wDbl2duLyKRd627YUzOyGh2uNr88LeXV7wGfJe4CBrz/BdeGo8V6eGjx+HlZLPymuEoN2hwh6iBMW/NqxE1ngFHNADT2RrTOQ4NNauWvR7qIaTLvwS9qxqL5SDdY4v2LHnAxgxTidMy9wFkQA1HBuZV+j06XlQQHfbG7ujfiFQ==~4604728~3749432; user_profile_id=undefined; __rtbh.uid=%7B%22eventType%22%3A%22uid%22%2C%22id%22%3A%22%22%2C%22expiryDate%22%3A%222026-06-30T20%3A14%3A09.813Z%22%7D; utag_main=v_id:0197c12dc3dd00192121f189db330506f001806700bd0$_sn:5$_se:4$_ss:0$_st:1751316249264$dc_visit:5$ses_id:1751313350669%3Bexp-session$_pn:1%3Bexp-session$_prevpage:AE%3Acart%3Aui%3Bexp-1751318049269$dc_event:2%3Bexp-session; _ga_XGBGNYD4S1=GS2.1.s1751313358$o5$g1$t1751314450$j60$l0$h1645839381; ttcsid_C0HVR0KP76SVVJ0UU9SG=1751313325357::xL6PzxsifJwGI4xcTnca.5.1751314465520; ttcsid=1751313345278::a-3PQVuISpCaxMqQvfyd.5.1751314465522; _abck=0015414213531594FB3FD2EA87A3B272~-1~YAAQbAxAF0y4Kq+XAQAAlw16wg51khr1ORWXMwc/zt4cfU5hLpEShtUKk9p3NsMDgSa0DVo40BVKs6ge5KXZiNy9Ao7//HN5ntBT0W5cx06vK5D32D7XomWlEYfLrTPL+qunV8FZcr7+AQQpnP76zr3C9DSuWvlK/zBVfo4k/G64HKO/jP5U1jAJfh22XZTtApiT6AZoXCXPt6Ly421L9HoQP7G7nWm4ejXxOWp1Q+3JIuQMdiBlXbn11MMajMqe+SZzMlbK1CUMToJ8gyqQS4lNIc1UDYL0VS7L4NvKzxFujkynlG8GQWe8WJsPr85IzBDJz4IIyl84B/h7GI0ppqa1ZZZ82CSCF19gvexjTMNvMIQU8m2gLk+CzX25SKG6auoz/y/nNwzQaHD+5ZJmAqtQV8oXROJJSX9wE6hcZGQ6xScqnvIKwZuqd93gWK/CKR3qgIJYDahdU74D47lUmb0e586P2ywoBdo1xn5Q+mTWujeVQJEA1tZ37kZiRC+LTiysr3RCyKDAGAp6QE/SeU6t+hMMMPWYuDn3rJD0R2Hb5vbz05iIvk/EVa2IXXY3n+2wkdtcn12KNjZMsVPayhbDM/LhRAIv4kJdzi/+7RwehO09NENd+swEmepzUa2ZuHOXUowuFqnPhFlZ0Qcoz32tZjIzMDlM6/yRLsGwsfICaxORbqB5u8QI76BkRRajgS+b+DZzaX/6oPHCq1DjXrKOb2mkbwm/jODKL10Bx31sGcCNLHeb87GGDJd/WgBL746r+IgGVenj1mte9+eDHtFlSpaJKs5GMb+5EfhB99Zd7b5zhSh9ONKzIdkBkVo6cK3pJWuCIaxDEqpugdffdmHmEdRC+gR1Bh2Vvp2OAPENvk4LSZ0L8C5yggTkaGr0JSURK6iukmBlKf38VF756UX9/js9n5hjQR3WLkviF4kJCUR5sVwFraZ9GXkX18lYNMWJA0zkU/r1HokovPT+35XYIARHgfJbIY+yy5g+XlYCYUxY0OgyhrpBkijp+y46C4ggEszME9rd3kk87vtiNC8q+Fjrk9bmXqj50gsxWy5FMyH1YNeQ/gUf66Zn/w==~-1~||0||~-1; _gcl_au=1.1.887176511.1751292694.1363588121.1751313345.1751314465; bm_sv=1F997EEA135166818F6A7FD41E973C04~YAAQbAxAF1a4Kq+XAQAAGBB6whzKIEMaCP1gNi1AeczeOZkd6nsQLA4v5OwSKTo+3jkkOQwMnC7X5ItKn9+SiiPjk1bansIXxpNROaSu/Wx6biYKMMSrjxSj/rqH98fPQB9rgpIYMJCHqnei0GHHwyoPfQ7cpS8vURgVola6DfX4rP2Da0K5YSjs3UUwo8+yfZk7bgtv0X2NljuIXh/gBAnRwsjOlzwZd2sIYK8vvBxWJvcP4KfJheP7B1hS~1";


    public static void createAccessTokenGuest() {

        AuthController authController = new AuthController();

        accessTokenGuest = authController
                .getAccessTokenGuest()
                .body().jsonPath().getString("access_token");
    }

    public static void createAccessTokenUser() {
        AuthController authController = new AuthController();

        if (accessTokenUser == null) {
            accessTokenUser = authController
                    .getAccessTokenUser()
                    .body().jsonPath().getString("access_token");
        }
    }

    public final static class BagData {
        public static final String SKUID_WOMEN = "0043270800";
        public static final String SKUID_MEN = "0043421387";

        public static String cartId;
        public static List<Map<String, Object>> items;
    }

    public final static class ProductData {
        public static final String CODE_PRODUCT = "0153_2885_020";
        public static final String SCUID_PRODUCT = "0043043645";
        public static Product product;
        public static Sku productToCart;
    }
}