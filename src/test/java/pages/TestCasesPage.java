package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage {

    private SelenideElement
            header = $(byText("Test Cases"));

    public TestCasesPage checkHeader(){
        header.shouldBe(visible);
        return this;
    }
}
