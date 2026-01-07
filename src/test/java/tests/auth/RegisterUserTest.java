package tests.auth;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.components.Header;

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
        homePage.checkHomePageVisible();
        header.clickSignupLoginButton();
        loginPage.checkSignupHeaderVisible()
                .setSignupName(testData.fullName)
                .setSignupEmail(testData.email)
                .clickSignupButton();
        accountInfoPage.checkAccountInfoPageVisible()
                .setPassword(testData.password)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .newsletterAgree()
                .selectGenderMale()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setCompany(testData.company)
                .setAddress(testData.address)
                .selectCountry("India")
                .setState(testData.state)
                .setCity(testData.city)
                .setZipcode(testData.zipcode)
                .setMobileNumber(testData.mobileNumber)
                .clickCreateAccountButton()
                .checkAccountCreatedStatus()
                .checkAccountCreated()
                .checkAccountName(testData.fullName);
        header.deleteAccount();
    }
}
