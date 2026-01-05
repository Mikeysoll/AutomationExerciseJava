package tests.contact;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ContactFormTest extends TestBase {

    private static final String SUCCES_MESSAGE = "Success! Your details have been submitted successfully.";

    @Test
    @Tag("ui")
    @Tag("contact")
    @DisplayName("Contact Us Form Test")
    public void contactFormTest() {

        step("Click on 'Contact Us' button", () ->
                header.clickContactUsButton()
        );

        step("Verify that \"Get In Touch\" is visible", () ->
                contactPage.checkContactHeaderVisible()
        );

        step("Enter user information", () -> {
            contactPage.setName(testData.fullName)
                    .setEmail(testData.email)
                    .setSubject(testData.subject)
                    .setMessage(testData.message);
        });

        step("Upload file", () -> {
            contactPage.uploadFile("img/test.jpg");
        });

        step("Submit the form and verify success", () -> {
            contactPage.clickSubmitButton()
                    .checkSuccessMessage(SUCCES_MESSAGE)
                    .clickHomeButton();
        });

    }
}
