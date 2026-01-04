package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final String HOME_LOGO = ".logo.pull-left";

    public HomePage isHomePageVisible() {
        $(HOME_LOGO).shouldBe(Condition.visible);
        return this;
    }

}
