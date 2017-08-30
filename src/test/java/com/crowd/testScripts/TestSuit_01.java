package com.crowd.testScripts;

import com.crowd.testObjects.testObjects;
import org.testng.annotations.Test;

/**
 * Created by QA on 8/30/2017.
 */
public class TestSuit_01 {
    String accessToken;
    testObjects firstTest = new testObjects();

    //Functional API test suit
    @Test
    public void smokeSuit() {
        accessToken = firstTest.login();
        firstTest.createPaperSet(accessToken);
    }
}
