package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final String HOME_LOGO = ".logo.pull-left";

    private SelenideElement homePageLogo = $(HOME_LOGO),
            subscriptionHeader = $(".single-widget"),
            subscriptionField = $("#susbscribe_email");

    @Step("Check that home page is visible")
    public HomePage checkHomePageVisible() {
        homePageLogo.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check that subscription header is visible")
    public HomePage checkSubscriptionHeaderVisible() {
        subscriptionHeader.shouldHave(text("Subscription"));
        return this;
    }

    @Step("Check that subscription field is visible")
    public HomePage checkSubscriptionFieldVisible() {
        subscriptionField.shouldBe(Condition.visible);
        return this;
    }

    @Step("Set email to subscription: {email}")
    public HomePage setEmailToSubscription(String email) {
        subscriptionField.setValue(email);
        return this;
    }
}
