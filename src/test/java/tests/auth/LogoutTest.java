package tests.auth;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.components.Header;

public class LogoutTest extends TestBase {

    HomePage homePage = new HomePage();
    SignupLoginPage loginPage = new SignupLoginPage();
    AccountInfoPage accountInfoPage = new AccountInfoPage();
    Header header = new Header();

    @ParameterizedTest
    @DisplayName("Logout User")
    @CsvSource({
            "Test, testaccount@test.ru, testaccount@test.ru"
    })
    @Tag("ui")
    @Tag("auth")
    void logoutTest(String userName, String userEmail, String userPassword) {
        homePage.checkHomePageVisible();
        header.clickSignupLoginButton();
        loginPage.isLoginHeaderVisible()
                .setLoginEmail(userEmail)
                .setLoginPassword(userPassword)
                .clickLoginButton();
        accountInfoPage.checkAccountName(userName);
        header.clickLogoutButton();
    }
}
