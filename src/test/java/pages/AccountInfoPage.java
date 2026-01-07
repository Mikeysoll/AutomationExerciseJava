package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class AccountInfoPage {

    private SelenideElement
            accountInfoHeader = $(withText("Enter Account Information")),
            accountPasswordInput = $("#password"),
            daySelect = $("#days"),
            monthSelect = $("#months"),
            yearSelect = $("#years"),
            newsletterCheckBox = $("#newsletter"),
            genderMaleRadio = $("#id_gender1"),
            firstNameInput = $("#first_name"),
            lastNameInput = $("#last_name"),
            companyInput = $("#company"),
            address1Input = $("#address1"),
            countrySelect = $("#country"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            zipcodeInput = $("#zipcode"),
            mobileNumberInput = $("#mobile_number"),
            createAccountButton = $(byText("Create Account")),
            accountCreatedStatus = $(byText("Account Created!"));

    @Step("Check that account info page is visible")
    public AccountInfoPage checkAccountInfoPageVisible() {
        accountInfoHeader.shouldBe(Condition.visible);
        return this;
    }

    @Step("Set password: {password}")
    public AccountInfoPage setPassword(String password) {
        accountPasswordInput.setValue(password);
        return this;
    }

    @Step("Set date of birth: {day}-{month}-{year}")
    public AccountInfoPage setDateOfBirth(int day, String month, int year) {
        daySelect.selectOption(String.valueOf(day));
        monthSelect.selectOption(month);
        yearSelect.selectOption(String.valueOf(year));
        return this;
    }

    @Step("Agree to newsletter")
    public AccountInfoPage newsletterAgree() {
        newsletterCheckBox.click();
        return this;
    }

    @Step("Select gender male")
    public AccountInfoPage selectGenderMale() {
        genderMaleRadio.click();
        return this;
    }

    @Step("Set first name: {firstNameValue}")
    public AccountInfoPage setFirstName(String firstNameValue) {
        firstNameInput.setValue(firstNameValue);
        return this;
    }

    @Step("Set last name: {lastNameValue}")
    public AccountInfoPage setLastName(String lastNameValue) {
        lastNameInput.setValue(lastNameValue);
        return this;
    }

    @Step("Set company: {companyValue}")
    public AccountInfoPage setCompany(String companyValue) {
        companyInput.setValue(companyValue);
        return this;
    }

    @Step("Set address: {addressValue}")
    public AccountInfoPage setAddress(String addressValue) {
        address1Input.setValue(addressValue);
        return this;
    }

    @Step("Select country: {countryName}")
    public AccountInfoPage selectCountry(String countryName) {
        countrySelect.selectOption(countryName);
        return this;
    }

    @Step("Set state: {stateName}")
    public AccountInfoPage setState(String stateName) {
        stateInput.setValue(stateName);
        return this;
    }

    @Step("Set city: {cityName}")
    public AccountInfoPage setCity(String cityName) {
        cityInput.setValue(cityName);
        return this;
    }

    @Step("Set zipcode: {zipcode}")
    public AccountInfoPage setZipcode(String zipcode) {
        zipcodeInput.setValue(zipcode);
        return this;
    }

    @Step("Set mobile number: {mobileNumber}")
    public AccountInfoPage setMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
        return this;
    }

    @Step("Click Create Account button")
    public AccountInfoPage clickCreateAccountButton() {
        createAccountButton.click();
        return this;
    }

    @Step("Check account created status is visible")
    public AccountInfoPage checkAccountCreatedStatus() {
        accountCreatedStatus.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check that account was created")
    public AccountInfoPage checkAccountCreated() {
        $("[data-qa=\"account-created\"]").shouldHave(text("Account Created!"));
        $("[data-qa=\"continue-button\"]").click();
        return this;
    }

    @Step("Check logged in account name: {fullName}")
    public AccountInfoPage checkAccountName(String fullName) {
        $(".header-middle").shouldHave(text("Logged in as " + fullName));
        return this;
    }
}
