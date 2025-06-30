package api.utils;

import api.controllers.AuthController;

import java.util.List;
import java.util.Map;

public final class Constants extends BaseTest {

    public static String accessTokenGuest;
    public static String accessTokenUser;
    public static String BASE_URL = "https://www.ae.com/ugp-api/";
    public static String COOKIES = "QuantumMetricSessionID=0fedeb7941e704eaf46813bccfbe016b; TLTUID=67D7F9C9F202C5110972F7C1DCDD69CA; akaalb_PROD_ALB=~op=PROD_LB_ALL_DCs:PROD_LB_Origin_East4_AGWA_Service_Mesh|~rv=12~m=PROD_LB_Origin_East4_AGWA_Service_Mesh:0|~os=db0ecb8ead961a2983478ea211c488b6~id=26fa3b8e2c9a7be7000ceea69438b67d; aeoStyliticsSegment=true; optimizelyEndUserId=72d36675-4241-4a75-8536-cdf44204aad5; aeoUserIp=109.248.173.67; aeoUserLocation=RU:; ae_clarip_consent=0,1,2,3; ae_clarip_ab_segment=true; brand=aeo; akaalb_PROD_ALB_API=~op=PROD_LB_APICG_EAST5:PROD_LB_Origin_APICG_East5|~rv=60~m=PROD_LB_Origin_APICG_East5:0|~os=db0ecb8ead961a2983478ea211c488b6~id=74c6f21e90226a108e6a12b89c6a32b2; tkbl_session=43ac33e6-f9d6-4435-9e4e-8fac4baa4bc7; ConstructorioID_client_id=c36c928c-632d-4977-839a-3b4fbb6e0f7b; swim_ten=f; acquisition_value=; acquisition_location=https://www.ae.com/us/en; acquisition_location_gtm=https://www.ae.com/us/en; acquisition_value_gtm=; _ga=GA1.1.213600151.1751292692; _scid=8Ssk2-jFZH9JS9ySjAMPvu8w4Fq2IHRU; cjConsent=MHxOfDB8Tnww; cjUser=1e350ee8-2d57-4b50-8729-039950820d82; _tt_enable_cookie=1; _ttp=01JZ0JVN476AWBJV8FV3PM2CSQ_.tt.1; _sctr=1%7C1751230800000; __exponea_etc__=c60b885a-fc65-42b3-8546-b23ce79357f1; _pin_unauth=dWlkPU56STFOakkzWmpZdFlqYzFPQzAwTTJGaExUZ3dObU10WlRReE9URmpORFEwTVRaaA; _ScCbts=%5B%5D; QuantumMetricUserID=f65a5b5f295d59a00a34893fafe2fe8d; _li_dcdm_c=.ae.com; _lc2_fpi=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; _lc2_fpi_js=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; geuid=c8b256cf-7d54-4a93-91a1-6a1852a64687; _gepi=true; _geps=true; _gess=true; _getdran=3; BVBRANDID=44877675-8d7e-4971-bb23-e12462a2c18f; granify.uuid=7df4f133-8ef2-4108-a17b-19ba0605d513; granify.new_user.sxkhw=true; aeoUserJourney=journey-user-scrolled%2Cjourney-users-who-added-item-to-bag; optimizelySession=0; granify.session.sxkhw=-1; ConstructorioID_session_id=2; __exponea_time2__=2.382534980773926; X-AK-PIM-INJECT=sync; _geffran=3; ak_bmsc=B2E2DD5240EF050833DB087CEFA53B28~000000000000000000000000000000~YAAQbAxAF61oIa+XAQAA/RSdwRw49BLrI1Xcwjd0jB9S6JRMWEfD0GnhsBwcDyRIh5QFGLtvLsOr4pWVQfBSApt7KzOvzqX0F5VO7RwLdDvHCqHtpPasMc7C0XQ3vgl10IAw2yJyqHHMN9MZUYuSuyo/wOMP+E9F+y7z1niFLxXL2OAj9pW492lNkdiPJksnHiA5ASC90X5v5gcvo1Vv6odZDasg3HIFXSR6GI7X3bZLpHcmw3V2WqBV5TOMqTHdn03vIPmx02uCxwUiE0fNtiKf8eKmgsB9UlVJ1pH6UmoPLhuEjSToUbndOGDek4MwYeeZsNKB15K1u6AiowezNOsjxyDjUFIawcRBAblE3rySZ4oDu0xwP2fIbf6BGWjUSvuOmzjjkg==; bm_mi=B400561F3D1E2D5FA65A7B196D4BDE5E~YAAQbAxAF4ZpIa+XAQAAsWGdwRyMDICkSy74g+8kgCcMHNsn9prS7PYZ5lT9uP0HtFt2bPsnJvnWsCoMTJkGb0P2tNEvQJeUQ4LvJFRZ5SoGlfVT9kIPKJ+H5O9n7td5/31qQFaLZoSd0Rq9BBg6Ypq8c6VuW43tMvgL2z3q/Ahkq387KTEYz3HquzQ97H5OUTQSSGGTN3EIwzf0zOAViUN/uDI7+/jrrJy2sOF+7aY9sSIDTjw6ysbDFDa/wNH4DRtgWa5ktAIG+ypwDQhqW1luM/94Kt+33BwVAWzdZvBFB9oSTwiKpHAVu7sR0fAbKg==~1; __rtbh.lid=%7B%22eventType%22%3A%22lid%22%2C%22id%22%3A%227Mymqfnx6yevGzB6RL9j%22%2C%22expiryDate%22%3A%222026-06-30T16%3A13%3A32.889Z%22%7D; _br_uid_2=uid%3D4101334484443%3Av%3D17.0%3Ats%3D1751292693313%3Ahc%3D6; _scid_r=Dqsk2-jFZH9JS9ySjAMPvu8w4Fq2IHRUR_sc8Q; ConstructorioID_session={\"sessionId\":2,\"lastTime\":1751300013555}; _gecntaos=MQ==; _geaos=true; _gekf=dGVzdDFAZW1haWwucnU=; bm_sz=CF0EF3FBB13C5C80DADAA7D0062D10FE~YAAQbAxAF3ZsIa+XAQAATi6ewRxyBaMQvwQI/5nQym54gPJJbzJEZCwROHT4LtSHprponMIVkKbGTv+toWIUKoe5Hn7XoTWtNm9V+QgWpEUFCIelZD/dW3+bXG9xOqyt4H4mgUuSe5H8Vb4f6cp4MEZjS1kiwt9w5ULm0Bk055TnVCDd8TJ11mM+tmvUCQJDIdOL2UGKFnlRaa0ktgrjg+AZfBJVaKD0iHCiGyjS1n5iYFiNYBDBRlPkpkh8fESp4Lf7ltDo3i3hI3nRx6kuRaWuZ0mcAVH+oqvOi9zI2t/m21z0TBcPemK4N+09uLF51skexcCFPzBa8DVNNW5FKK/Ua9vZqAS3VuNtJusMmLi9+L0sj/l6sSijzg+zLe7sfuFN4yKqzly4VBQbg9vFpSRrSQmmEPsgd9PB/uIxabrglK15LiPITSzpaTThEaCc24FRbWg6+jYfuF73hjgshVBgUTQK8Oo0lpBVoiwntJL0J0EO4NGiqWd5QZal24TcjAM/~4471092~3621685; user_profile_id=undefined; __rtbh.uid=%7B%22eventType%22%3A%22uid%22%2C%22id%22%3A%22%22%2C%22expiryDate%22%3A%222026-06-30T16%3A21%3A38.012Z%22%7D; utag_main=v_id:0197c12dc3dd00192121f189db330506f001806700bd0$_sn:3$_se:49$_ss:0$_st:1751302294703$_prevpage:AE%3Acart%3Aui%3Bexp-1751304094710$dc_visit:3$ses_id:1751297165865%3Bexp-session$_pn:6%3Bexp-session$dc_event:11%3Bexp-session$dc_region:eu-central-1%3Bexp-session; _ga_XGBGNYD4S1=GS2.1.s1751297172$o3$g1$t1751300498$j60$l0$h530885893; ttcsid_C0HVR0KP76SVVJ0UU9SG=1751297168535::_bHqLNtKwDiQvhWqqFpt.3.1751300523567; ttcsid=1751297171631::2rEwlW0O_d1vpQR5xQze.3.1751300523568; _abck=0015414213531594FB3FD2EA87A3B272~-1~YAAQbAxAF7uJIa+XAQAA+VClwQ5mf/FcvcKxcSycW7HjxwZ6AhaaqYN+q3Fs8FTnzT6uPoX3DcY01z6srZ/zq3nhcq+d+3pV0IPdIrJEzCBNaJUGllyQxoEM+701PrIlgBzA+hZJVcic+SoDYUf0bDChLF6CqDyUFQWIqECZEDQJCptRSs0yJBuUfx5JZ8tq9tOt7eHaMz+1GwG62EVHC5j3ffoUpbeUlb6EdaB5pvKPXKr09Z5z5fENZ3tMR5F1xu4S88qgOmYJRTBJ7ZSE4NAXGbDnwuq0S2lnm9Q4h3YfF2+zKliIDDDcqtlX0a1AZ6/g8+Q6TdR/GB0b3R/CS3vfG3V7bUaR5rZSxbFqw76BXZfcF8yKTG1oznIsC4Nw7AAlZ99aLiMt+UUVn5C2N3zzyRF691TUhn3DRhAgt6BO08mBl6R0V5KmBRh07bedj7VAh7ayB/p0k6N1NK69To00gOpu7IHG40JYjiapQ59xNd9tq9hgdOlSKysByFB74KH4epIORUae8DASsViVyErHgd81jcR2a2U+i133cxgV5hAGRujYmXHYyNWDrNsZwbsLeBj3Es7fRGF5nBX/1ZFedCVnZ34c+JZHf9QO1CG7k3Qv1v4GTOxVkl78+WxA2dqgJ8h7USR0FRAubKQuUrV7cGMXEb5JCXvQ+fnnl8iuuPA0csDO06JWOHIbEQ84qILQia1OaYq0hPN/A3awRFf4G7NHovel9iEg3sSemkQXGuukk+/QfbUpjXDSp/tvQ3h8+hjPtH58aRkRLTEPpknp+ozH8bP1+t3YOibC27Ij6a4DxBmnYM2yDIKvAnNl7KWceLgkSxxO4hT3qXpwWvme8pL9mMpSjiLbSkzP7Ue59VLSu94t5aYNITt7MpKewcSTj7OeX7D6NK6tHebh8cJETkSuDIiQZ5i/E4IEf8WAA6m84WwAN/UKax6Fb3AqGZUMf5YR+BiUkOsbDiuBZX2MWfDau5soIw==~-1~||0||~-1; _gcl_au=1.1.887176511.1751292694.1527771561.1751298459.1751300523; bm_sv=5162DDBA2B24580B3EAA4E40F7FACC79~YAAQbAxAF8GJIa+XAQAARVOlwRwEEVbWZh2nLtwxlbpNF1lyZJFW9dPppEsrYybLOTtqTFPJbCGiiYzzWu7iCq/5igKrcRraoz3jJcKRK8XPkBe6QxEDMUC5QDWicczJupgMnHASTUxmcrPHcnw5ymMmqV9qAvmbEHDdcw9XzgElMuB0h4/8rE9NuIGucEEuJZ6BuCZ8ju1Sd41avA9DR6wXAe3KCzWmpOUQgfKtvY2AbJg5RzDjIy9zxN4x~1";

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
}