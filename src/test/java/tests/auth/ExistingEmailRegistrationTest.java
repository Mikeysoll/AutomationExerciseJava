package tests.auth;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SignupLoginPage;
import pages.components.Header;

public class ExistingEmailRegistrationTest extends TestBase {

    protected SignupLoginPage loginPage = new SignupLoginPage();
    private static final String EMAIL_EXISTS_ERROR = "Email Address already exist!";
    Header header = new Header();

    @ValueSource(strings = {"TestAccount@yandex.ru"})
    @ParameterizedTest
    @Tag("ui")
    @Tag("auth")
    @DisplayName("Register User with existing email")
    public void existingEmailRegistrationTest(String email) {

        header.clickSignupLoginButton();
        loginPage.checkSignupHeaderVisible()
                .setSignupName(testData.fullName)
                .setSignupEmail(email)
                .clickSignupButton()
                .checkSignUpErrorMessage(EMAIL_EXISTS_ERROR);
    }
}
