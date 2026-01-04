package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

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


    public AccountInfoPage checkAccountInfoPageVisible() {
        accountInfoHeader.shouldBe(Condition.visible);
        return this;
    }

    public AccountInfoPage setPassword(String password) {
        accountPasswordInput.setValue(password);
        return this;
    }

    public AccountInfoPage setDateOfBirth(int day, String month, int year) {
        daySelect.selectOption(String.valueOf(day));
        monthSelect.selectOption(month);
        yearSelect.selectOption(String.valueOf(year));
        return this;
    }

    public AccountInfoPage newsletterAgree() {
        newsletterCheckBox.click();
        return this;
    }

    public AccountInfoPage selectGenderMale() {
        genderMaleRadio.click();
        return this;
    }

    public AccountInfoPage setFirstName(String firstNameValue) {
        firstNameInput.setValue(firstNameValue);
        return this;
    }

    public AccountInfoPage setLastName(String lastNameValue) {
        lastNameInput.setValue(lastNameValue);
        return this;
    }

    public AccountInfoPage setCompany(String companyValue) {
        companyInput.setValue(companyValue);
        return this;
    }

    public AccountInfoPage setAddress(String addressValue) {
        address1Input.setValue(addressValue);
        return this;
    }

    public AccountInfoPage selectCountry(String countryName) {
        countrySelect.selectOption(countryName);
        return this;
    }

    public AccountInfoPage setState(String stateName) {
        stateInput.setValue(stateName);
        return this;
    }

    public AccountInfoPage setCity(String cityName) {
        cityInput.setValue(cityName);
        return this;
    }

    public AccountInfoPage setZipcode(String zipcode) {
        zipcodeInput.setValue(zipcode);
        return this;
    }

    public AccountInfoPage setMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
        return this;
    }

    public AccountInfoPage clickCreateAccountButton() {
        createAccountButton.click();
        return this;
    }

    public AccountInfoPage checkAccountCreatedStatus() {
        accountCreatedStatus.shouldBe(Condition.visible);
        return this;
    }

    public AccountInfoPage checkAccountCreated() {
        $("[data-qa=\"account-created\"]").shouldHave(text("Account Created!"));
        $("[data-qa=\"continue-button\"]").click();
        return this;
    }

    public AccountInfoPage checkAccountName(String fullName) {
        $(".header-middle").shouldHave(text("Logged in as " + fullName));
        return this;
    }
}