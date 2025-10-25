package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class Header {
    public void clickSignupLoginLink() {
        $(".nav.navbar-nav a[href='/login']").click();
    }
}