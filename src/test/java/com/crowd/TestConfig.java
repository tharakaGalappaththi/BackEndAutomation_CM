package com.crowd;

/**
 * Created by QA on 8/29/2017.
 */
public class TestConfig {

    public static final String baseUrl = "https://dev.api.grade5.lk";

    //Endpoints
    public static final String ENDPOINT_LOGIN = TestConfig.baseUrl + "/v1/auth/login";
    public static final String ENDPOINT_CREATE_PAPER_SET = TestConfig.baseUrl + "/v1/papersets";

    // login test keys and values
    public static String loginKeyEmail = "email";
    public static String loginKeyPassword = "password";
    public static String loginValueEmail = "system@grade5.lk";
    public static String loginValuePassword = "System@2017";
    public static String loginKeyFirstname = "user.firstname";
    public static String loginValueFirstname = "System";
    public static String loginKeyLastname = "user.lastname";
    public static String loginValueLastName = "Admin";
    public static String loginKeyRole = "user.role";
    public static String loginValueRole = "SYSTEM_ADMIN";
    public static String ACCESS_TOKEN;

    //Create paper set keys and values
    public static String createPsKeyTitle = "title";
    public static String createPsKeySummary = "summary";
    public static String createPsKeyMessage = "message";
    public static String createPsKeyAccessToken = "authorization";

    public static String createPsValueTitle = "Paperset 01";
    public static String createPsValueSummary = "Title of paper set 01";
    public static String createPsValueMessage = "OK";


}
