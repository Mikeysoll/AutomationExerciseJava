package tests.auth;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SignupLoginPage;
import pages.components.Header;

public class InvalidLoginTest extends TestBase {

    SignupLoginPage loginPage = new SignupLoginPage();
    Header header = new Header();

    private static final String INVALID_LOGIN_ERROR = "Your email or password is incorrect!";

    @Tag("ui")
    @Tag("auth")
    @CsvSource(value = {
            "firstTry@Email,firstTryPassword",
            "secondTry@Email,secondTryPassword"
    })
    @ParameterizedTest
    @DisplayName("Login User with incorrect email and password")
    void invalidLoginTest(String email, String password) {

        header.clickSignupLoginButton();
        loginPage.isLoginHeaderVisible()
                .setLoginEmail(email)
                .setLoginPassword(password)
                .clickLoginButton()
                .checkLoginErrorMessage(INVALID_LOGIN_ERROR);
    }
}
