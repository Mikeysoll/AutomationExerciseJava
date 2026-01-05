package tests.navigation;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VerifyTestCasesTest extends TestBase {

    @Test
    @Tag("navigation")
    @DisplayName("Verify user is navigated to test cases page successfully")
    public void testCasesPageSuccessfully() {
        homePage.checkHomePageVisible();
        header.clickTestCasesButton();
        $(".title.text-center").shouldHave(text("Test Cases"));
    }
}
