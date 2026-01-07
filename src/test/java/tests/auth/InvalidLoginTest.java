package tests.auth;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SignupLoginPage;
import pages.components.Header;

import static io.qameta.allure.Allure.step;

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

        step("Click on Signup/Login link in header", () ->
                header.clickSignupLoginButton()
        );

        step("Verify Login header is visible", () ->
                loginPage.isLoginHeaderVisible()
        );

        step("Set login email", () ->
                loginPage.setLoginEmail(email)
        );

        step("Set login password", () ->
                loginPage.setLoginPassword(password)
        );

        step("Click Login button", () ->
                loginPage.clickLoginButton()
        );

        step("Verify error message for invalid login", () ->
                loginPage.checkLoginErrorMessage(INVALID_LOGIN_ERROR)
        );
    }
}
