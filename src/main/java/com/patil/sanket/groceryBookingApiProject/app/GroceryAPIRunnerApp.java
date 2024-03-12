package com.patil.sanket.groceryBookingApiProject.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.patil.sanket.groceryBookingApiProject", exclude = SecurityAutoConfiguration.class)
@EnableAutoConfiguration
// entity/ bean classes & repositories are not in the same package as that of the runner app classes, so we need to specify their base packages explicitly, so that the runner class can scan them
@EnableJpaRepositories("com.patil.sanket.groceryBookingApiProject.repositories")
@EntityScan(basePackages = {"com.patil.sanket.groceryBookingApiProject.beans"})
public class GroceryAPIRunnerApp {
    public static void main(String[] args) {
        SpringApplication.run(GroceryAPIRunnerApp.class, args);
    }
}