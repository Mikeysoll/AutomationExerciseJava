package tests.navigation;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.TestCasesPage;
import pages.components.Header;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VerifyTestCasesTest extends TestBase {

    Header header = new Header();
    HomePage homePage = new HomePage();
    TestCasesPage testCasesPage = new TestCasesPage();

    @Test
    @Tag("ui")
    @Tag("navigation")
    @DisplayName("Verify user is navigated to test cases page successfully")
    public void testCasesPageSuccessfully() {
        homePage.checkHomePageVisible();
        header.clickTestCasesButton();
        testCasesPage.checkHeader();
    }
}
