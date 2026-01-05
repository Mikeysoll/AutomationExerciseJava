package tests.auth;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

public class LogoutTest extends TestBase {

    @ParameterizedTest
    @DisplayName("Logout User")
    @CsvSource({
            "Test, testaccount@test.ru, testaccount@test.ru"
    })
    @Tag("ui")
    @Tag("auth")
    void logoutTest(String userName, String userEmail, String userPassword) {

        step("Verify that home page is visible", () ->
                homePage.checkHomePageVisible()
        );

        step("Open login page", () -> {
            header.clickSignupLoginButton();
            loginPage.isLoginHeaderVisible();
        });

        step("Enter correct email address and password and login", () -> {
            loginPage.setLoginEmail(userEmail)
                    .setLoginPassword(userPassword)
                    .clickLoginButton();
        });

        step("Verify user is logged in", () ->
                accountInfoPage.checkAccountName(userName)
        );

        step("Logout user", () ->
                header.clickLogoutButton()
        );
    }
}