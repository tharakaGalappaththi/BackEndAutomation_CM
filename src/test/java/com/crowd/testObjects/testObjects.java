package com.crowd.testObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.crowd.*;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class testObjects extends RestAssured {

    public String login() {
        Map<String, Object> jsonAsMapLogin = new HashMap<>();
        jsonAsMapLogin.put(TestConfig.loginKeyEmail, TestConfig.loginValueEmail);
        jsonAsMapLogin.put(TestConfig.loginKeyPassword, TestConfig.loginValuePassword);

        Response response =
                expect()
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
        return TestUtils.generateAccessToken(response);
    }

    public void createPaperSet(String accessToken) {
        Map<String, Object> jsonAsMapCreatePaperSetBody = new HashMap<>();
        jsonAsMapCreatePaperSetBody.put(TestConfig.createPsKeyTitle, TestConfig.createPsValueTitle);
        jsonAsMapCreatePaperSetBody.put(TestConfig.createPsKeySummary, TestConfig.createPsValueSummary);
        System.out.println(jsonAsMapCreatePaperSetBody);
        expect()
                .statusCode(200)
                //.log().all()
                .body(TestConfig.createPsKeyMessage, equalTo(TestConfig.createPsValueMessage))
                .given()
                .contentType(ContentType.JSON)
                .header(TestConfig.createPsKeyAccessToken, accessToken)
                .body(jsonAsMapCreatePaperSetBody)
                .when()
                .post(TestConfig.ENDPOINT_CREATE_PAPER_SET);
    }
}