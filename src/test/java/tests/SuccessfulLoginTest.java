package tests;

import base.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static io.qameta.allure.Allure.step;

public class SuccessfulLoginTest extends TestBase {

    @ParameterizedTest
    @DisplayName("Login User with correct email and password")
    @CsvSource({
            "Test, testaccount@test.ru, testaccount@test.ru"
    })
    @Tag("smoke")
    void successfulLoginTest(String userName, String userEmail, String userPassword) {

        step("Verify that home page is visible", () ->
                homePage.isHomePageVisible()
        );

        step("Open Registration page and login", () -> {
            header.clickSignupLoginLink();
            loginPage.isLoginHeaderVisible()
                    .setLoginEmail(userEmail)
                    .setLoginPassword(userPassword)
                    .clickLoginButton();
            accountInfoPage.checkAccountName(userName);
        });
    }
}