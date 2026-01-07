package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {

    private SelenideElement
            contactUsInfoHeader = $(byText("Get In Touch")),
            nameInput = $("[data-qa=\"name\"]"),
            emailInput = $("[data-qa=\"email\"]"),
            subjectInput = $("[data-qa=\"subject\"]"),
            messageInput = $("#message"),
            uploadFileInput = $("input[type='file']"),
            submitButton = $("[data-qa=\"submit-button\"]"),
            successMessage = $(".status.alert.alert-success"),
            homeButton = $(".btn.btn-success");

    @Step("Check that Contact Us header is visible")
    public ContactPage checkContactHeaderVisible() {
        contactUsInfoHeader.shouldBe(Condition.visible);
        return this;
    }

    @Step("Set name: {name}")
    public ContactPage setName(String name) {
        nameInput.setValue(name);
        return this;
    }

    @Step("Set email: {email}")
    public ContactPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Set subject: {subject}")
    public ContactPage setSubject(String subject) {
        subjectInput.setValue(subject);
        return this;
    }

    @Step("Set message: {message}")
    public ContactPage setMessage(String message) {
        messageInput.setValue(message);
        return this;
    }

    @Step("Upload file: {file}")
    public ContactPage uploadFile(String file) {
        uploadFileInput.uploadFromClasspath(file);
        return this;
    }

    @Step("Click Submit button")
    public ContactPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Check success message: {message}")
    public ContactPage checkSuccessMessage(String message) {
        successMessage.shouldHave(text(message));
        return this;
    }

    @Step("Click Home button")
    public ContactPage clickHomeButton() {
        homeButton.click();
        return this;
    }
}
