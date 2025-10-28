package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SignupLoginPage {
    private SelenideElement
//          ====================== Login ======================
            loginHeader = $(byText("Login to your account")),
            loginEmailInput = $("[data-qa=\"login-email\"]"),
            loginPasswordInput = $("[data-qa=\"login-password\"]"),
            loginButton = $("[data-qa=\"login-button\"]"),
            loginForm = $(".login-form"),


    //          ====================== Signup ======================
            signupHeader = $(byText("New User Signup!")),
            signupName = $("[data-qa=\"signup-name\"]"),
            signupEmail = $("[data-qa=\"signup-email\"]"),
            signupButton = $("[data-qa=\"signup-button\"]"),
            signupForm = $(".signup-form");


    //  ====================== Login Actions ======================
    public SignupLoginPage isLoginHeaderVisible() {
        loginHeader.shouldBe(visible);
        return this;
    }

    public SignupLoginPage setLoginEmail(String value) {
        loginEmailInput.setValue(value);
        return this;
    }

    public SignupLoginPage setLoginPassword(String value) {
        loginPasswordInput.setValue(value);
        return this;
    }

    public SignupLoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public SignupLoginPage checkLoginErrorMessage(String value) {
        loginForm.shouldHave(text(value));
        return this;
    }


    //  ====================== Signup Actions ======================
    public SignupLoginPage isSignupHeaderVisible() {
        signupHeader.shouldBe(visible);
        return this;
    }

    public SignupLoginPage setSignupName(String value) {
        signupName.setValue(value);
        return this;

    }

    public SignupLoginPage setSignupEmail(String value) {
        signupEmail.setValue(value);
        return this;

    }

    public SignupLoginPage clickSignupButton() {
        signupButton.click();
        return this;
    }

    public SignupLoginPage checkSignUpErrorMessage(String value) {
        signupForm.shouldHave(text(value));
        return this;
    }


}
