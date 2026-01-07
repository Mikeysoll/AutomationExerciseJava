package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SignupLoginPage {

    private SelenideElement
            // ====================== Login ======================
            loginHeader = $(byText("Login to your account")),
            loginEmailInput = $("[data-qa=\"login-email\"]"),
            loginPasswordInput = $("[data-qa=\"login-password\"]"),
            loginButton = $("[data-qa=\"login-button\"]"),
            loginForm = $(".login-form"),

    // ====================== Signup ======================
    signupHeader = $(byText("New User Signup!")),
            signupName = $("[data-qa=\"signup-name\"]"),
            signupEmail = $("[data-qa=\"signup-email\"]"),
            signupButton = $("[data-qa=\"signup-button\"]"),
            signupForm = $(".signup-form");

    // ====================== Login Actions ======================
    @Step("Check that login header is visible")
    public SignupLoginPage isLoginHeaderVisible() {
        loginHeader.shouldBe(visible);
        return this;
    }

    @Step("Set login email: {value}")
    public SignupLoginPage setLoginEmail(String value) {
        loginEmailInput.setValue(value);
        return this;
    }

    @Step("Set login password: {value}")
    public SignupLoginPage setLoginPassword(String value) {
        loginPasswordInput.setValue(value);
        return this;
    }

    @Step("Click login button")
    public SignupLoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Check login error message: {value}")
    public SignupLoginPage checkLoginErrorMessage(String value) {
        loginForm.shouldHave(text(value));
        return this;
    }

    // ====================== Signup Actions ======================
    @Step("Check that signup header is visible")
    public SignupLoginPage checkSignupHeaderVisible() {
        signupHeader.shouldBe(visible);
        return this;
    }

    @Step("Set signup name: {value}")
    public SignupLoginPage setSignupName(String value) {
        signupName.setValue(value);
        return this;
    }

    @Step("Set signup email: {value}")
    public SignupLoginPage setSignupEmail(String value) {
        signupEmail.setValue(value);
        return this;
    }

    @Step("Click signup button")
    public SignupLoginPage clickSignupButton() {
        signupButton.click();
        return this;
    }

    @Step("Check signup error message: {value}")
    public SignupLoginPage checkSignUpErrorMessage(String value) {
        signupForm.shouldHave(text(value));
        return this;
    }
}
