package tests.contact;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ContactPage;
import pages.components.Header;

public class ContactFormTest extends TestBase {

    private static final String SUCCES_MESSAGE = "Success! Your details have been submitted successfully.";
    ContactPage contactPage = new ContactPage();
    Header header = new Header();

    @Test
    @Tag("ui")
    @Tag("contact")
    @DisplayName("Contact Us Form Test")
    public void contactFormTest() {
        header.clickContactUsButton();
        contactPage.checkContactHeaderVisible()
                .setName(testData.fullName)
                .setEmail(testData.email)
                .setSubject(testData.subject)
                .setMessage(testData.message)
                .uploadFile("img/test.jpg")
                .clickSubmitButton()
                .checkSuccessMessage(SUCCES_MESSAGE)
                .clickHomeButton();
    }
}
