package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class Header {

    @Step("Click Signup/Login button")
    public void clickSignupLoginButton() {
        $(".nav.navbar-nav a[href='/login']").click();
    }

    @Step("Click Products button")
    public void clickProductsButton() {
        $(".nav.navbar-nav a[href=\"/products\"]").click();
    }

    @Step("Delete account")
    public void deleteAccount() {
        $("a[href='/delete_account']").click();
        $("[data-qa=\"account-deleted\"]").shouldHave(text("Account Deleted!"));
        $("[data-qa=\"continue-button\"]").click();
    }

    @Step("Click Logout button")
    public void clickLogoutButton() {
        $("a[href='/logout']").click();
    }

    @Step("Click Contact Us button")
    public void clickContactUsButton() {
        $(".fa.fa-envelope").click();
    }

    @Step("Click Test Cases button")
    public void clickTestCasesButton() {
        $("a[href=\"/test_cases\"]").click();
    }
}
