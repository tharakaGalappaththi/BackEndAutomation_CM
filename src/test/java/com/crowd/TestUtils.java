package com.crowd;

import io.restassured.response.Response;

/**
 * Created by QA on 8/30/2017.
 */
public class TestUtils {

    //Extract access token from the response
    public static String generateAccessToken(Response response) {
        String accessToken = response.getBody().path("token");
        return "Bearer " + accessToken;
    }
}
