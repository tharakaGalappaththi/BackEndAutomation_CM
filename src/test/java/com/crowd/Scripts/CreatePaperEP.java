package com.crowd.Scripts;

import com.crowd.TestConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by QA on 8/31/2017.
 */
public class CreatePaperEP {
    @Test
    public void createPaperSet() {
        Map<String, Object> jsonAsMapCreatePaperSetBody = new HashMap<>();
        jsonAsMapCreatePaperSetBody.put(TestConfig.createPsKeyTitle, TestConfig.createPsValueTitle);
        jsonAsMapCreatePaperSetBody.put(TestConfig.createPsKeySummary, TestConfig.createPsValueSummary);
        //  System.out.println(jsonAsMapCreatePaperSetBody);
        expect()
                .statusCode(200)
                //.log().all()
                .body(TestConfig.createPsKeyMessage, equalTo(TestConfig.createPsValueMessage))
                .given()
                .contentType(ContentType.JSON)
                .header(TestConfig.createPsKeyAccessToken, TestConfig.ACCESS_TOKEN)
                .body(jsonAsMapCreatePaperSetBody)
                .when()
                .post(TestConfig.ENDPOINT_CREATE_PAPER_SET);
    }
}

