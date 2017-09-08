package com.crowd.Scripts;

import com.crowd.TestConfig;
import com.crowd.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/**
 * Created by QA on 8/31/2017.
 */
public class LoginEP {

    public static String accessToken;
    Reporter loginRP = new Reporter();
    @Test
    public void login() {
        loginRP.log("This test case verifies the functionality of Login API ");

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
                .and()
                .time(lessThanOrEqualTo(TestConfig.expectedResponseTime)) //Verify response time is less than or equal to 4s
                .and()
                .contentType(ContentType.JSON)
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
