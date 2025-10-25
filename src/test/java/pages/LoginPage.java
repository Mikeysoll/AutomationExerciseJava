package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import javax.print.attribute.standard.PageRanges;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement
            loginHeader = $(byText("Login to your account")),
            loginInput = $("[data-qa=\"login-email\"]"),
            passwordInput = $("[data-qa=\"login-password\"]"),
            loginButton = $("[data-qa=\"login-button\"]"),
            loginForm = $(".login-form");


    public LoginPage isLoginHeaderVisible() {
        loginHeader.shouldBe(visible);
        return this;
    }

    public LoginPage setLogin(String value){
        loginInput.setValue(value);

        return this;
    }

    public LoginPage setPassword(String value){
        passwordInput.setValue(value);

        return this;
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    public LoginPage checkErrorMessage(String value){
        loginForm.shouldHave(text(value));
        return this;
    }


}
