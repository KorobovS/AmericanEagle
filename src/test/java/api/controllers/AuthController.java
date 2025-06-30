package api.controllers;

import api.utils.Constants;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ui.utils.LoggerUtil;

import static api.utils.Constants.BASE_URL;
import static io.restassured.RestAssured.given;

public class AuthController {

    private final RequestSpecification requestSpecification = given();

    public AuthController() {
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.filter(new AllureRestAssured());
    }

    @Step("Получаем токен Guest")
    public Response getAccessTokenGuest() {

        LoggerUtil.info("Получаю токен Guest");

        requestSpecification.header("Authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==")
                .formParam("grant_type", "client_credentials");

        Response response = given(requestSpecification).post("auth/oauth/v5/token");
        Constants.accessTokenGuest = response.body().jsonPath().getString("access_token");

        return response;
    }

    @Step("Получаем токен User")
    public Response getAccessTokenUser() {

        LoggerUtil.info("Получаю токен User");

        Constants.createAccessTokenGuest();

        requestSpecification.header("Authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==")
                .header("x-access-token", Constants.accessTokenGuest)
                .header("Cookie", "TLTUID=3D38BBE6CF98C4DB811A9BF61D4B5656; _abck=48DC3F3D01B2888B248BD4CC0C07B41F~-1~YAAQbAxAF03OHK+XAQAAus2ewA7RClwixbqPgexra8w5Kv3j0O+godWrlyRticuT/ZeUUELnrcG2av4oVn6dz9uCdZAtdsM0/cBmXlTagOmyjlgiCXQ/nWmvLGYxPI48DYmHVdmEmSTdw2m5vRvU7A9Lrdvs2wo4ZHR5Ar+PRc3+4iiUqZ997wukhdWiQ0/Su+40qLeBji4aeKbboAIOookbSW1KniKWFqSCKPD8ZA+Ormk5/mm39lP8ntP8PRKLtIsq5ObZLX5s6g/tJvLj2kpyAM3jzn88SFSfNTbT2u4QZveIFtW/wo680D9pJkXJXfFwmkA8MC9NNrF+2gsCKjnJOkVUCMhV0qQysl3Lkh6YdBwtG60UuYzbFux1fIu9+4PLKCywk1XGhGqvYh9gWzEUP4fzGVi7iYnZsaLeAVmKWZt54BiNNazmVUetjudC0FF28L4N2y5ZXWtsFquZ4a3iFa2Y/UYULYxS6yIEvGVLKeuYATJZWVibFNHrCafU6DeJsy3P4NKj9xl6UE2h/j8zZD8uBQMnDB8qczmSisfC9XEhhE/71IO+FnvD2GaMncTR+zu95Ns16AGccAvK220QKlXYnH734H6mdbNvvsIVoWzqJnXq0AC+3Y1yAUTNTV27VjV53mU8S2NUWDZuiLNbdmqGpkAIqqrTJzyvCAS/8zM5cZlyE45sTM9d0fGm9JnsTQA2qm8c8IaE8C3Ws3cSP9TUAKMO9f6UioJBPhJBrsTIDnaA+tUYnn8gl82ONu0ETiKAkRNhGxo214OKhSWvB9BqlvP7ch+iDCYgapHEORsVRTFX4u3hMvzWDqfRZLXAeIyxKMao4wzc0Z1gtN4TKBNT9+65BPYPZ5d2/3545XiBRqNvwRa+Xe43rREPRJtsDP1uWFH42jmmnM9fnbM=~-1~-1~-1; bm_sz=C67CA67526A23EE1029354CE6A5A3856~YAAQbAxAF07OHK+XAQAAus2ewBy4tmwMMuiuZIq1PYe0Gm9aA8aU7pKFpxXdqRG0UcfnEe/0JxMbetY6yArGkvR/83KLsJLBEbGZFDvimHjh7PVeQ9WeBgpY6Zyy+95Kw/hI5osre2Ube0hlYtrBadHpLLWOWydXqA+qq8tSV0aXGt/OEMXIH2FMDFW+bZVz+DqSr2LbikkTlL5tYatnZ09AS5sf7DYcXrsIcQFUsTFxvl80kT6fby6mVVZ/kjCswUIH/uNcEXTzeqGsj6M7BnHumHmsZorbZmAYeHivWxM/jLjZBF/QFrcsopdMFLD3BBb/CCtglaMRjIo8pdRw8bECA6c9u84f37cgN9qL6mDxVuhI5WiupWBvJ+9Xjx18D9pKxo6k4ooi5ryMcC0vh74fnj4xxKWvTuh6Iol5WpOq2hAsjwMsGsJzRzYurtLNXE/f2hAH6Bv0Q9KffU6csR1FNKH3l8ztoKDVqbwNI3m1zrhGBKS9XuEBtz6Y5Y6a8tqtSA9RubB0hsORwZUc92p/vGgRfyxMFHRi+V5gXsz/sJEt+s4MCtfiK2Om~4277046~3753541; akaalb_PROD_ALB_API=~op=PROD_LB_APICG_EAST5:PROD_LB_Origin_APICG_East5|~rv=85~m=PROD_LB_Origin_APICG_East5:0|~os=db0ecb8ead961a2983478ea211c488b6~id=7c6d628ef311c1ae4799c7ba76e5cc72")
                .formParams("grant_type", "password")
                .formParam("username", "Test1@email.ru")
                .formParam("password", "123456qaz");

        Response response = given(requestSpecification).post("auth/oauth/v4/token");
        Constants.accessTokenUser = response.body().jsonPath().getString("access_token");
        return response;
    }
}
