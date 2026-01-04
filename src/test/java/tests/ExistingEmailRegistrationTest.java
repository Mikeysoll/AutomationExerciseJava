package tests;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class ExistingEmailRegistrationTest extends TestBase {

    private static final String EMAIL_EXISTS_ERROR = "Email Address already exist!";

    @ValueSource(strings = {"TestAccount@yandex.ru"})
    @ParameterizedTest
    @DisplayName("Register User with existing email")
    public void existingEmailRegistrationTest(String email) {

        step("Click on Signup/Login link in header", () ->
                header.clickSignupLoginLink()
        );

        step("Verify Signup header is visible", () ->
                loginPage.isSignupHeaderVisible()
        );

        step("Set signup name", () ->
                loginPage.setSignupName(testData.fullName)
        );

        step("Set signup email", () ->
                loginPage.setSignupEmail(email)
        );

        step("Click Signup button", () ->
                loginPage.clickSignupButton()
        );

        step("Verify error message for existing email", () ->
                loginPage.checkSignUpErrorMessage(EMAIL_EXISTS_ERROR)
        );
    }
}
