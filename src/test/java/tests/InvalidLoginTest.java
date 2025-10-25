package tests;

import base.TestBase;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InvalidLoginTest extends TestBase {

    private static final String INVALID_LOGIN_ERROR = "Your email or password is incorrect!";

    @CsvSource (value = {
            "firstTry@Email,firstTryPassword",
            "secondTry@Email,secondTryPassword",
            "thirdTry@Email,thirdTryPassword"
    })
    @DisplayName("Login User with incorrect email and password")
    @ParameterizedTest
    void invalidLoginTest(String email, String password) {
        header.clickLoginLink();
        loginPage.isLoginHeaderVisible()
                 .setLogin(email)
                 .setPassword(password)
                 .clickLoginButton()
                 .checkErrorMessage(INVALID_LOGIN_ERROR);
    }

}
