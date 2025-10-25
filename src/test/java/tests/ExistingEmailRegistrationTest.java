package tests;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExistingEmailRegistrationTest extends TestBase {

    private static final String EMAIL_EXISTS_ERROR
            = "Email Address already exist!";
    @ValueSource(strings = {"TestAccount@yandex.ru"})
    @DisplayName("Register User with existing email")
    @ParameterizedTest
    public void existingEmailRegistrationTest(String email) {
        header.clickSignupLoginLink();
        loginPage.isSignupHeaderVisible()
                 .setSignupName(testData.fullName)
                 .setSignupEmail(email)
                 .clickSignupButton()
                 .checkSignUpErrorMessage(EMAIL_EXISTS_ERROR);
    }

}
