package data;

import com.github.javafaker.Faker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    Faker faker = new Faker();

    public String fullName = faker.name().fullName(),
            email = faker.internet().emailAddress(),
            password = faker.internet().password(),
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            company = faker.company().name(),
            address = faker.address().fullAddress();

    LocalDate localDate = Instant.ofEpochMilli(faker.date().birthday().getTime())
            .atZone(ZoneId.systemDefault()).toLocalDate();

    public int dayOfBirth = localDate.getDayOfMonth(),
            yearOfBirth = localDate.getYear();

    String month = localDate.getMonth().name();
    public String monthOfBirth =
            month.substring(0, 1) + month.substring(1).toLowerCase();

    public String state = faker.address().state();
    public String city = faker.address().cityName();
    public String zipcode = faker.address().zipCode();
    public String mobileNumber = faker.phoneNumber().cellPhone();
    public String message = faker.lorem().paragraph();
    public String subject = faker.lorem().sentence(5);

}
