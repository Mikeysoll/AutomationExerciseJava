package tests.products;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class SubscriptionTest extends TestBase {

    HomePage homePage = new HomePage();

    @Test
    @Tag("ui")
    @Tag("products")
    @DisplayName("Verify Subscription in home page")
    public void verifySubscriptionTest() {

        homePage.checkHomePageVisible()
                .checkSubscriptionHeaderVisible()
                .checkSubscriptionFieldVisible()
                .setEmailToSubscription(testData.email);
    }
}
