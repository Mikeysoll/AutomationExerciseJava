package tests.auth;

import base.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.components.Header;

import static io.qameta.allure.Allure.step;

public class SuccessfulLoginTest extends TestBase {

    SignupLoginPage loginPage = new SignupLoginPage();
    HomePage homePage = new HomePage();
    AccountInfoPage accountInfoPage = new AccountInfoPage();
    Header header = new Header();

    @ParameterizedTest
    @DisplayName("Login User with correct email and password")
    @CsvSource({
            "Test, testaccount@test.ru, testaccount@test.ru"
    })
    @Tag("ui")
    @Tag("auth")
    void successfulLoginTest(String userName, String userEmail, String userPassword) {

        step("Verify that home page is visible", () ->
                homePage.checkHomePageVisible()
        );

        step("Open Registration page and login", () -> {
            header.clickSignupLoginButton();
            loginPage.isLoginHeaderVisible()
                    .setLoginEmail(userEmail)
                    .setLoginPassword(userPassword)
                    .clickLoginButton();
            accountInfoPage.checkAccountName(userName);
        });
    }
}