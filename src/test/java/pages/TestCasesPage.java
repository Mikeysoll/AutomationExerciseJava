package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage {

    private SelenideElement header = $(byText("Test Cases"));

    @Step("Check that Test Cases header is visible")
    public TestCasesPage checkHeader() {
        header.shouldBe(visible);
        return this;
    }
}
