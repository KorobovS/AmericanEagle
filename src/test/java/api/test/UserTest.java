//package api.test;
//
//import api.utils.BaseTest;
//import api.utils.Constants;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static api.utils.Constants.COOKIES;
//
//public class UserTest extends BaseTest {
//
//    @Test
//    public void testCreateUser() {
//        Constants.createAccessTokenGuest();
//
//        Response response = RestAssured.given()
//                .header("accept", "application/vnd.oracle.resource+json")
//                .header("accept-language", "ru,en-US;q=0.9,en;q=0.8")
//                .header("aelang", "en_US")
//                .header("aesite", "AEO_US")
//                .header("authorization", "Bearer " + Constants.accessTokenGuest)
//                .header("content-type", "application/json")
//                .header("lastactivitydate", "VGh1LCAyNiBKdW4gMjAyNSAwNToxNDoxMSBHTVQ=")
//                .header("newrelic", "eyJ2IjpbMCwxXSwiZCI6eyJ0eSI6IkJyb3dzZXIiLCJhYyI6IjI0OTg5OTgiLCJhcCI6IjExMjAxNjg0MzkiLCJpZCI6ImVhOGNiOWJiOGIzMGY1M2IiLCJ0ciI6IjYzZDNjZjY2NWU2N2I5MTg0Y2NjZmYxOTA1OTRjNGMwIiwidGkiOjE3NTA5MTQ4OTU0NzQsInRrIjoiMjA0MzQ4In19")
//                .header("origin", "https://www.ae.com")
//                .header("priority", "u=1, i")
//                .header("referer", "https://www.ae.com/us/en/myaccount/create-account")
//                .header("sec-ch-ua", "\"Google Chrome\";v=\"137\", \"Chromium\";v=\"137\", \"Not/A)Brand\";v=\"24\"")
//                .header("sec-ch-ua-mobile", "?0")
//                .header("sec-ch-ua-platform", "\"Windows\"")
//                .header("sec-fetch-dest", "empty")
//                .header("sec-fetch-mode", "cors")
//                .header("sec-fetch-site", "same-origin")
//                .header("traceparent", "00-63d3cf665e67b9184cccff190594c4c0-ea8cb9bb8b30f53b-01")
//                .header("tracestate", "204348@nr=0-1-2498998-1120168439-ea8cb9bb8b30f53b----1750914895474")
//                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36")
//                .header("x-access-token", Constants.accessTokenGuest)
//                .header("Cookie", "TLTUID=67D7F9C9F202C5110972F7C1DCDD69CA; akaalb_PROD_ALB=~op=PROD_LB_ALL_DCs:PROD_LB_Origin_East4_AGWA_Service_Mesh|~rv=12~m=PROD_LB_Origin_East4_AGWA_Service_Mesh:0|~os=db0ecb8ead961a2983478ea211c488b6~id=26fa3b8e2c9a7be7000ceea69438b67d; aeoStyliticsSegment=true; optimizelyEndUserId=72d36675-4241-4a75-8536-cdf44204aad5; aeoUserIp=109.248.173.67; aeoUserLocation=RU:; ae_clarip_consent=0,1,2,3; ae_clarip_ab_segment=true; brand=aeo; akaalb_PROD_ALB_API=~op=PROD_LB_APICG_EAST5:PROD_LB_Origin_APICG_East5|~rv=60~m=PROD_LB_Origin_APICG_East5:0|~os=db0ecb8ead961a2983478ea211c488b6~id=74c6f21e90226a108e6a12b89c6a32b2; tkbl_session=43ac33e6-f9d6-4435-9e4e-8fac4baa4bc7; ConstructorioID_client_id=c36c928c-632d-4977-839a-3b4fbb6e0f7b; swim_ten=f; acquisition_value=; acquisition_location=https://www.ae.com/us/en; acquisition_location_gtm=https://www.ae.com/us/en; acquisition_value_gtm=; _ga=GA1.1.213600151.1751292692; _scid=8Ssk2-jFZH9JS9ySjAMPvu8w4Fq2IHRU; cjConsent=MHxOfDB8Tnww; cjUser=1e350ee8-2d57-4b50-8729-039950820d82; _tt_enable_cookie=1; _ttp=01JZ0JVN476AWBJV8FV3PM2CSQ_.tt.1; _sctr=1%7C1751230800000; __exponea_etc__=c60b885a-fc65-42b3-8546-b23ce79357f1; _pin_unauth=dWlkPU56STFOakkzWmpZdFlqYzFPQzAwTTJGaExUZ3dObU10WlRReE9URmpORFEwTVRaaA; _ScCbts=%5B%5D; QuantumMetricUserID=f65a5b5f295d59a00a34893fafe2fe8d; _li_dcdm_c=.ae.com; _lc2_fpi=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; _lc2_fpi_js=564cdb68d47c--01jz0jx6pkgg8chhyfgtjqfr1m; geuid=c8b256cf-7d54-4a93-91a1-6a1852a64687; _gepi=true; _geps=true; _gess=true; _getdran=3; BVBRANDID=44877675-8d7e-4971-bb23-e12462a2c18f; granify.uuid=7df4f133-8ef2-4108-a17b-19ba0605d513; granify.new_user.sxkhw=true; aeoUserJourney=journey-user-scrolled%2Cjourney-users-who-added-item-to-bag; optimizelySession=0; granify.session.sxkhw=-1; ConstructorioID_session_id=2; X-AK-PIM-INJECT=sync; _geffran=3; __rtbh.lid=%7B%22eventType%22%3A%22lid%22%2C%22id%22%3A%227Mymqfnx6yevGzB6RL9j%22%2C%22expiryDate%22%3A%222026-06-30T16%3A13%3A32.889Z%22%7D; _br_uid_2=uid%3D4101334484443%3Av%3D17.0%3Ats%3D1751292693313%3Ahc%3D6; _scid_r=Dqsk2-jFZH9JS9ySjAMPvu8w4Fq2IHRUR_sc8Q; ConstructorioID_session={\"sessionId\":2,\"lastTime\":1751300013555}; _gecntaos=MQ==; _gekf=dGVzdDFAZW1haWwucnU=; QuantumMetricSessionID=cce102979643b9ac4bcb8eec4263def4; ak_bmsc=1353AA34E65BBC0716BEEDAA335FFB05~000000000000000000000000000000~YAAQmQcQAo8i97GXAQAAXPZowhyW7G/ACGCdGQJFSMqdbIof7qGxTLwJMFvoDpU/NgACCye8a8Eny7bNT9S2HWhp2W2Qft42zkAkESYvpqV3kcoPjvuZxHktfJQa4+Sn0GmOASFXi0+RyjZynqZ89hYkAbpvi5R8vukTiSqWDKgwumMovGeknYtHLu86XW6yuF08xc4QKNTFIevnMYzohMMwqTPLBRkDnGq58tgALOlesGQgJ+5LNNXwclFo2qPlogk5K9ypXsAqHgv5sXz2ZdT8rlXC9SDHGCnhzLM5URJpX2DbgVbEKEdwypM0VIF8UcfaOuweQG+7HpiCQ8xPWQbJeL8eAAOSSQocvVOp+PnHE3ZrnncoqTJsb8lipP63Loo8AQZY5A==; user_profile_id=undefined; __rtbh.uid=%7B%22eventType%22%3A%22uid%22%2C%22id%22%3A%22%22%2C%22expiryDate%22%3A%222026-06-30T20%3A16%3A47.413Z%22%7D; _ga_XGBGNYD4S1=GS2.1.s1751313358$o5$g1$t1751314607$j47$l0$h1645839381; bm_sv=1F997EEA135166818F6A7FD41E973C04~YAAQk2ITAgCgh4GXAQAAdTl8whwlyqTIYa7BKWJbMgquJctlw4mIsrijsA4d3sZ5EykaNzo+NcZRjVXKnCIyfZnYqmAN/Ce6VgUzGOPwodpQhpHCYrL8y7aPAyQ5B5mMFOJfKswaNFUTTqZ5YTMk6Kt0ufY8ell0a6HOCSAZahpYZa3JVN902AcAeada3aav0IoIAJhIulkI0lENNgDyhBnfP4VNjcvyscnQcUP5ssdev22F2sZNBbzAhkQH~1; utag_main=v_id:0197c12dc3dd00192121f189db330506f001806700bd0$_sn:5$_se:10$_ss:0$_st:1751316957212$dc_visit:5$ses_id:1751313350669%3Bexp-session$_pn:1%3Bexp-session$_prevpage:AE%3Amyaccount%3Acreate_account%3Aui%3Bexp-1751318757215$dc_event:5%3Bexp-session; ttcsid_C0HVR0KP76SVVJ0UU9SG=1751313325357::xL6PzxsifJwGI4xcTnca.5.1751315198230; ttcsid=1751313345278::a-3PQVuISpCaxMqQvfyd.5.1751315198231; _gcl_au=1.1.887176511.1751292694.1363588121.1751313345.1751315198; _abck=0015414213531594FB3FD2EA87A3B272~-1~YAAQbAxAFzsAK6+XAQAACj+Fwg6JzStVAdiz0h8q69Eae8PsPVTc5JYoVJDSailO5fe8johhsRX/kPqykqKBR0h0x6Afgba0XgMIliP2fZ7MSva2mb6OfRGb2/TSIruL/LNChhmWpaARXDd9yBWTYBrHww6PmN0mALFTB/LgGHcovOVIfp30mx153ABXyBeXr5/x8WX6mycFLLRnSXD5qlkDh+880/Ch3gJb3s0nxniQtvmXTlUuEI7ubUjdo86w8V5Z4FZl2zWOcxfxlp6BGmGMGmPiWnOPJTcsm7ubwymEGzoxuTrelmn2GV0+TO6KaDWC8iCtr47D6XxffIlmAMXH3Y7uJJK58qoYtkvTKpXB8VGeITuU46p20lakFZFm9KjgqytckBwuCA7nBg76FbiEpFaqvbJXW5Xqh71GZXVZN8INYVI/ABBJ7QEyx1R3f0BUCfmC1TKzfVhEqMa8VsA1QVjh4jjWIrFcMT0fJEJstpUGfumDjPjyttxtLrarb+Z2hwbWxY9V2ZjIEgGCCKVTmKf63FDZ5+mWeOn4O9jdA0TRh/kEe7xjZJPfBLN79KdC97WlJC+QcClY14eqsxP5HXOmJPjfwr+1zWUTQXFWSM0PYxarOAb4RTbCZqyckf5b3dcluP6DuV8lU9otOLWOmAX/K6Is5qUkuWR/mJfMPGn9jPGQxdBWqOyOJQ9EksEky05fui6OT0tWMV6AttKadQvCZ7bFhzVsLxu+vLmR4BDuuFcxXj2sOnLa1028ZuevpoB/p0n3GbpEeGcZLFNxQy07i0zDEJ1gh6jnUPqTvjzm4NpOXYVawroeKyMhb9SFxqC/sSzWXWU0fQuoAY3FREE8LvzXrByFPR92zP86aP8xK/lC0Fj2TG2ef6aHfPIdfwaRbNyHs2/geaRTwIs4uuxyJuh3c5FGT6wgVD1orhBGU9WqOuN/aCPrnGu+Pk6bHd7kBC01J8By31wuA6yu4eM9vuR/8FJZhPTF2AmeADQTCNCts66nHohLhT2nbOjdcWTl/o4RBS7IKIaAKsHyhwmIUgrLjLd7PQqd8Tdh3ButNxx6SjWA~-1~-1~-1; bm_sz=D4073A763F5BF00ACB38D7B4580ECB97~YAAQbAxAFzwAK6+XAQAACj+FwhzcoVa0VQ0gh1QEcwLdXo0fTSRmd/Z/o3zlaEHw/e1RLDuJZ0iAei6FjajLQutG7UtcVxzmCNUbmANkkw7SFqs7wRUYWhiyZ9GsSIRhTESkHrT5F5MqenKQvtjJpnsoMYeNa2tsWQViBHdzaDw/1h8oS23MzLNMhJSyT17OX5Wg1V97oJ9BRvkiQfugImeI6ivM1KMS+9tD4QSXHrNMnk6Dc/1Yqj7PLQacIXEBaELFKZ+5WA5TwSp8kcvtvUklfT0H60vBMwK7Dk0TwvSp2dCxEY1xmYMcuwM0Y7ELhVHlJ5hl0hOQvbMGODI0u1r5AcmBfJOxyxdTBuDqET7Og+PvP886LW4Q6eIjiQhA3uRo17B4J4CtEeUI9ohs09TJyxiepUIJTeIKkmLikf5/ZgkQpgZH3LZwL60lWGEh~4604728~3749432")
//                .when()
//                .body("{\"firstName\":\"first\",\"lastName\":\"last\",\"password\":\"123456qaz\",\"confirmPassword\":\"123456qaz\",\"login\":\"Test32@email.ru\",\"phoneNumber\":\"+12345678655\",\"preferredLanguage\":\"en_US\",\"preferredCountry\":\"US\",\"emailPreferences\":[\"AE\",\"Aerie\"],\"textPreferences\":[]}")
//                .post("https://www.ae.com/ugp-api/users/v3")
//                .then()
//                .extract().response();
//        System.out.println(response.asString());
//
//        Assert.assertEquals(response.getStatusCode(), 201);
//    }
//}
