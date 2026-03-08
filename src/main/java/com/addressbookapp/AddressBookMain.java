package com.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the Spring Boot Address Book Application.
 *
 * @SpringBootApplication does three things:
 * 1. Enables component scanning
 * 2. Enables auto configuration
 * 3. Enables Spring Boot configuration
 *
 * This class starts the Spring Boot application.
 */
@SpringBootApplication
public class AddressBookMain {

    /**
     * Main method where program execution begins.
     */
    public static void main(String[] args) {

    	 SpringApplication.run(AddressBookMain.class, args);

         System.out.println("Address Book Spring Boot Application Started Successfully!");
    }
}