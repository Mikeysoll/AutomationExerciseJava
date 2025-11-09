package tests;

import base.TestBase;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("first")
public class InvalidLoginTest extends TestBase {

    private static final String INVALID_LOGIN_ERROR = "Your email or password is incorrect!";

    @CsvSource(value = {
            "firstTry@Email,firstTryPassword",
            "secondTry@Email,secondTryPassword",
            "thirdTry@Email,thirdTryPassword"
    })
    @ParameterizedTest
    @DisplayName("Login User with incorrect email and password")
    void invalidLoginTest(String email, String password) {
        header.clickSignupLoginLink();
        loginPage.isLoginHeaderVisible()
                .setLoginEmail(email)
                .setLoginPassword(password)
                .clickLoginButton()
                .checkLoginErrorMessage(INVALID_LOGIN_ERROR);
    }

}
