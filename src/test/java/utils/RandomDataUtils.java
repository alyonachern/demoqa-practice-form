package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomDataUtils {

    Faker faker = new Faker(new Locale("en-GB"));

    private String[] gender = new String[] {"Male", "Female", "Other"},
    hobby = new String[] {"Reading", "Sports", "Music"};
    private List<String> subjects = new ArrayList<>((Arrays.asList
            ("Math", "Accounting", "Arts", "Social Studies", "Biology", "Chemistry", "Computer Science", "Commerce")));

    private Map<String, String[]> stateAndCity = new HashMap<>();

    {
        stateAndCity.put("NCR", new String[] {"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Uttar Pradesh", new String[] {"Agra", "Lucknow", "Merrut"});
        stateAndCity.put("Haryana", new String[] {"Karnal", "Panipat"});
        stateAndCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

    public String randomFirstName() {
        return faker.name().firstName();
    }

    public String randomLastName() {
        return faker.name().lastName();
    }

    public String randomEmail() {
        return faker.internet().emailAddress();
    }

    public String randomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }
    public String randomAddress() {
        return faker.address().fullAddress();
    }

    public String randomGender() {
        return faker.options().nextElement(gender);
    }

    public String[] randomDate() {
        String[] date = new SimpleDateFormat("MMMM/yyyy/dd", Locale.ENGLISH)
                .format(faker.date().birthday(18, 100)).split("/");
        return date;
    }

    public String randomSubject() {
        return faker.options().nextElement(subjects);
    }

    public String randomHobby() {
        return faker.options().nextElement(hobby);
    }

    public String randomState() {
        return faker.options().option(stateAndCity.keySet().toArray()).toString();
    }

    public String randomCity(String state) {
        return faker.options().option(stateAndCity.get(state));
    }
}
