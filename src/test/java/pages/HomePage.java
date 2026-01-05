package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final String HOME_LOGO = ".logo.pull-left";

    public HomePage checkHomePageVisible() {
        $(HOME_LOGO).shouldBe(Condition.visible);
        return this;
    }

}
