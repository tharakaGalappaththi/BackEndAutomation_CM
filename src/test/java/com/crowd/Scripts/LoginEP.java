package com.crowd.Scripts;

import com.crowd.TestConfig;
import com.crowd.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by QA on 8/31/2017.
 */
public class LoginEP {

    public static String accessToken;

    @Test
    public void login() {
        Map<String, Object> jsonAsMapLogin = new HashMap<>();
        jsonAsMapLogin.put(TestConfig.loginKeyEmail, TestConfig.loginValueEmail);
        jsonAsMapLogin.put(TestConfig.loginKeyPassword, TestConfig.loginValuePassword);

        Response response;
        response = expect()
                .statusCode(200)
                //.log().all()
                .body(TestConfig.loginKeyFirstname, equalTo(TestConfig.loginValueFirstname))
                .body(TestConfig.loginKeyLastname, equalTo(TestConfig.loginValueLastName))
                .body(TestConfig.loginKeyRole, equalTo(TestConfig.loginValueRole))
                .given()
                .contentType(ContentType.JSON)
                .body(jsonAsMapLogin)
                .when()
                .post(TestConfig.ENDPOINT_LOGIN);
        //System.out.println(TestHelper.generateAccessToken(response));
        //return TestUtils.generateAccessToken(response);
        TestConfig.ACCESS_TOKEN = TestUtils.generateAccessToken(response);
    }
}
