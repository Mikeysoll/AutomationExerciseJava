package data;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    public String fullName = faker.name().fullName();
}
