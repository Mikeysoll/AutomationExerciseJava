package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Header {
    public void clickSignupLoginButton() {
        $(".nav.navbar-nav a[href='/login']").click();
    }

    public void clickProductsButton() {
        $(".nav.navbar-nav a[href=\"/products\"]").click();
    }

    public void deleteAccount() {
        $("a[href='/delete_account']").click();
        $("[data-qa=\"account-deleted\"]").shouldHave(text("Account Deleted!"));
        $("[data-qa=\"continue-button\"]").click();
    }

    public void clickLogoutButton() {
        $("a[href='/logout']").click();
    }

    public void clickContactUsButton() {
        $(".fa.fa-envelope").click();
    }

    public void clickTestCasesButton() {
        $("a[href=\"/test_cases\"]").click();
    }
}