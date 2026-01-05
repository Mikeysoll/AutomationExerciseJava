package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final String HOME_LOGO = ".logo.pull-left";

    private SelenideElement homePageLogo = $(HOME_LOGO),
        subscriptionHeader = $(".single-widget"),
        subscriptionField = $("#susbscribe_email");

    public HomePage checkHomePageVisible() {
        homePageLogo.shouldBe(Condition.visible);
        return this;
    }

    public HomePage checkSubscriptionHeaderVisible() {
        subscriptionHeader.shouldHave(text("Subscription"));
        return this;
    }

    public HomePage  checkSubscriptionFieldVisible() {
        subscriptionField.shouldBe(Condition.visible);
        return this;
    }

    public HomePage setEmailToSubscription(String email) {
        subscriptionField.setValue(email);
        return this;
    }

}
