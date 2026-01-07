package tests.auth;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.components.Header;

import static io.qameta.allure.Allure.step;

public class RegisterUserTest extends TestBase {

    HomePage homePage = new HomePage();
    AccountInfoPage accountInfoPage = new AccountInfoPage();
    Header header = new Header();
    SignupLoginPage loginPage = new SignupLoginPage();


    @Test
    @Tag("ui")
    @Tag("auth")
    @DisplayName("Verify that home page is visible successfully")
    public void registerUserTest() {

        step("Verify that home page is visible ", () ->
                homePage.checkHomePageVisible()
        );

        step("Open Registration page", () -> {
            header.clickSignupLoginButton();
            loginPage.checkSignupHeaderVisible();
        });

        step("Enter name and email address", () -> {
            loginPage.setSignupName(testData.fullName);
            loginPage.setSignupEmail(testData.email);
        });

        step("Click on signup button", () ->
                loginPage.clickSignupButton()
        );

        step("Verify that 'ENTER ACCOUNT INFORMATION' is visible", () ->
                accountInfoPage.checkAccountInfoPageVisible()
        );

        step("Fill account details", () -> {
            accountInfoPage.setPassword(testData.password)
                    .setDateOfBirth(
                            testData.dayOfBirth,
                            testData.monthOfBirth,
                            testData.yearOfBirth
                    );
            accountInfoPage.newsletterAgree()
                    .selectGenderMale()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setCompany(testData.company)
                    .setAddress(testData.address)
                    .selectCountry("India")
                    .setState(testData.state)
                    .setCity(testData.city)
                    .setZipcode(testData.zipcode)
                    .setMobileNumber(testData.mobileNumber);
        });

        step("Create account", () -> {
            accountInfoPage.clickCreateAccountButton();
        });

        step("Verify account was created and user is logged in", () -> {
            accountInfoPage.checkAccountCreatedStatus()
                    .checkAccountCreated()
                    .checkAccountName(testData.fullName);
        });

        step("Delete account", () -> {
            header.deleteAccount();
        });
    }
}