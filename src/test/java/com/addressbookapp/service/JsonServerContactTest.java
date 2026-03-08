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

        Contact[] contacts =
                given()
                .when()
                .get("http://localhost:3000/contacts")
                .then()
                .statusCode(200)
                .extract()
                .as(Contact[].class);

        addressBookMemory.clear();
        addressBookMemory.addAll(Arrays.asList(contacts));

        System.out.println("Contacts fetched: " + addressBookMemory.size());

        assertTrue(addressBookMemory.size() >= 0);
    }
    
    /**
     * UC23
     * Add multiple contacts to JSON Server
     */
    @Test
    void shouldAddMultipleContactsToJsonServer() {

        Contact contact1 = new Contact(
                "Thread1","Test","Minal","Bhopal",
                "MP","462001","9999999991","thread1@gmail.com"
        );

        Contact contact2 = new Contact(
                "Thread2","Test","Palasia","Indore",
                "MP","452001","9999999992","thread2@gmail.com"
        );

        Contact[] contacts = {contact1, contact2};

        for(Contact contact : contacts) {

            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(contact)
                    .when()
                    .post("/contacts")
                    .then()
                    .statusCode(201)
                    .extract()
                    .response();

            Contact savedContact = response.as(Contact.class);

            addressBookMemory.add(savedContact);

            System.out.println("Added Contact: " + savedContact.getFirstName());
        }

        assertTrue(addressBookMemory.size() >= 2);
    }
    
    //UC24
    
    @Test
    void shouldUpdateContactInJsonServer() {

        Response response = given()
                .when()
                .get("/contacts")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Contact[] contacts = response.as(Contact[].class);

        assertTrue(contacts.length > 0);

        Contact contactToUpdate = contacts[0];

        contactToUpdate.setCity("Mumbai");

        Response updateResponse = given()
                .contentType(ContentType.JSON)
                .body(contactToUpdate)
                .when()
                .put("/contacts/" + contactToUpdate.getId())
                .then()
                .statusCode(200)
                .extract()
                .response();

        Contact updatedContact = updateResponse.as(Contact.class);

        for(int i = 0; i < addressBookMemory.size(); i++) {

            if(addressBookMemory.get(i).getId().equals(updatedContact.getId())) {

                addressBookMemory.set(i, updatedContact);

            }
        }

        System.out.println("Updated Contact City: " + updatedContact.getCity());

        assertEquals("Mumbai", updatedContact.getCity());
    }
    
    //UC25
    
    @Test
    void shouldDeleteContactFromJsonServer() {

        // Step 1: Get all contacts
        Contact[] contacts =
                given()
                .when()
                .get("http://localhost:3000/contacts")
                .then()
                .statusCode(200)
                .extract()
                .as(Contact[].class);

        assertTrue(contacts.length > 0);

        Contact contactToDelete = contacts[0];

        Long contactId = contactToDelete.getId();

        System.out.println("Deleting Contact ID: " + contactId);

        // Step 2: Delete contact from JSON Server
        given()
            .when()
            .delete("http://localhost:3000/contacts/" + contactId)
            .then()
            .statusCode(200);

        // Step 3: Sync AddressBook Memory
        addressBookMemory.removeIf(contact -> contact.getId().equals(contactId));

        System.out.println("Contact deleted successfully");

        // Step 4: Verify deletion
        Response response =
                given()
                .when()
                .get("http://localhost:3000/contacts")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Contact[] updatedContacts = response.as(Contact[].class);

        boolean exists = Arrays.stream(updatedContacts)
                .anyMatch(contact -> contact.getId().equals(contactId));

        assertFalse(exists);
    }
}