package tests;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SubscriptionTest extends TestBase {

    @Test
    @DisplayName("Verify Subscription in home page")
    public void verifySubscriptionTest(){

        step("Open home page and verify it is visible", () ->
                homePage.checkHomePageVisible()
        );

        step("Verify subscription input is visible", () ->{
            homePage.checkSubscriptionHeaderVisible();
            homePage.checkSubscriptionFieldVisible();
        });

        step("Verify subscription field is visible", () ->
                homePage.setEmailToSubscription(testData.email)
        );
    }
}
