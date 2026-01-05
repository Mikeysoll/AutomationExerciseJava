package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

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
            homeButton=$(".btn.btn-success");

    public ContactPage checkContactHeaderVisible() {
        contactUsInfoHeader.shouldBe(Condition.visible);
        return this;
    }

    public ContactPage setName(String name) {
        nameInput.setValue(name);
        return this;
    }

    public ContactPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public ContactPage setSubject(String subject) {
        subjectInput.setValue(subject);
        return this;
    }

    public ContactPage setMessage(String message) {
        messageInput.setValue(message);
        return this;
    }

    public ContactPage uploadFile(String file) {
        uploadFileInput.uploadFromClasspath(file);
        return this;
    }

    public ContactPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public ContactPage checkSuccessMessage(String message) {
        successMessage.shouldHave(text(message));
        return this;
    }

    public ContactPage clickHomeButton() {
        homeButton.click();
        return this;
    }
}
