package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class Header {
    public void clickLoginLink() {
        $(".nav.navbar-nav a[href='/login']").click();
    }
}