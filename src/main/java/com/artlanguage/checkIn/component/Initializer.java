package com.artlanguage.checkIn.component;

import com.artlanguage.checkIn.entity.Users;
import com.artlanguage.checkIn.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Initializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    private final Log logger = LogFactory.getLog(Initializer.class);

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            logger.info("NO USER FOUND... CREATING SOME");

            // Create sample users
            Users user1 = new Users();
            user1.setUsername("john_doe");
            user1.setDisplayName("John Doe");
            user1.setPassword("password123");
            user1.setRole("10");
            user1.setDateOfJoin("2024-01-01");
            user1.setAge(25);
            user1.setCountry("USA");
            user1.setCity("New York");
            user1.setPhone("1234567890");
            user1.setEmail("john_doe@example.com");
            user1.setGender("Male");
            user1.setBio("I am John Doe, a software developer.");

            Users user2 = new Users();
            user2.setUsername("jane_doe");
            user2.setDisplayName("Jane Doe");
            user2.setPassword("password123");
            user2.setRole("10");
            user2.setDateOfJoin("2023-05-15");
            user2.setAge(28);
            user2.setCountry("UK");
            user2.setCity("London");
            user2.setPhone("0987654321");
            user2.setEmail("jane_doe@example.com");
            user2.setGender("Female");
            user2.setBio("I am Jane Doe, a graphic designer.");

            Users user3 = new Users();
            user3.setUsername("sam_smith");
            user3.setDisplayName("Sam Smith");
            user3.setPassword("password123");
            user3.setRole("20");
            user3.setDateOfJoin("2022-08-22");
            user3.setAge(32);
            user3.setCountry("Canada");
            user3.setCity("Toronto");
            user3.setPhone("1122334455");
            user3.setEmail("sam_smith@example.com");
            user3.setGender("Male");
            user3.setBio("I am Sam Smith, a data scientist.");

            Users user4 = new Users();
            user4.setUsername("alice_jones");
            user4.setDisplayName("Alice Jones");
            user4.setPassword("password123");
            user4.setRole("10");
            user4.setDateOfJoin("2021-12-10");
            user4.setAge(30);
            user4.setCountry("Australia");
            user4.setCity("Sydney");
            user4.setPhone("2233445566");
            user4.setEmail("alice_jones@example.com");
            user4.setGender("Female");
            user4.setBio("I am Alice Jones, a UX/UI designer.");

            Users user5 = new Users();
            user5.setUsername("mike_lee");
            user5.setDisplayName("Mike Lee");
            user5.setPassword("password123");
            user5.setRole("30");
            user5.setDateOfJoin("2020-09-15");
            user5.setAge(35);
            user5.setCountry("South Korea");
            user5.setCity("Seoul");
            user5.setPhone("3344556677");
            user5.setEmail("mike_lee@example.com");
            user5.setGender("Male");
            user5.setBio("I am Mike Lee, a project manager.");

            Users user6 = new Users();
            user6.setUsername("emma_white");
            user6.setDisplayName("Emma White");
            user6.setPassword("password123");
            user6.setRole("40");
            user6.setDateOfJoin("2019-04-20");
            user6.setAge(29);
            user6.setCountry("Germany");
            user6.setCity("Berlin");
            user6.setPhone("4455667788");
            user6.setEmail("emma_white@example.com");
            user6.setGender("Female");
            user6.setBio("I am Emma White, a marketing specialist.");

            // Save the users to the database
            userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6));

            logger.info("Sample users created.");
        } else {
            logger.info("USERS FOUND.");
        }
    }
}
