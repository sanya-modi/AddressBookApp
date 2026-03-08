package com.addressbookapp.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.addressbookapp.entity.Contact;

public class JsonServerContactTest {

    private static List<Contact> addressBookMemory = new ArrayList<>();

    @BeforeAll
    static void setup() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;

    }

    /**
     * UC22
     * Read contacts from JSON Server
     */
    @Test
    void shouldReadContactsFromJsonServer() {

        Response response = (Response) given()
                .when()
                .get("/contacts")
                .then()
                .statusCode(200);

        assertEquals(200, response.getStatusCode());

        Contact[] contacts = response.getBody().as(Contact[].class);

        List<Contact> contactList = Arrays.asList(contacts);

        addressBookMemory.addAll(contactList);

        System.out.println("Contacts retrieved from JSON Server:");

        addressBookMemory.forEach(System.out::println);

        assertTrue(addressBookMemory.size() > 0);
    }
    
    /**
     * UC23
     * Add multiple contacts to JSON Server
     */
    @Test
    void shouldAddMultipleContactsToJsonServer() {

        Contact contact1 = new Contact(
                "Thread1",
                "Test",
                "Minal",
                "Bhopal",
                "MP",
                "462001",
                "9999999991",
                "thread1@gmail.com"
        );

        Contact contact2 = new Contact(
                "Thread2",
                "Test",
                "Palasia",
                "Indore",
                "MP",
                "452001",
                "9999999992",
                "thread2@gmail.com"
        );

        Contact[] contacts = { contact1, contact2 };

        for(Contact contact : contacts) {

            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(contact)
                    .when()
                    .post("/contacts");

            assertEquals(201, response.getStatusCode());

            Contact savedContact = response.getBody().as(Contact.class);

            addressBookMemory.add(savedContact);

            System.out.println("Contact added to JSON Server: " + savedContact.getFirstName());
        }

        assertTrue(addressBookMemory.size() >= 2);
    }
}