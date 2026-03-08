package com.addressbookapp.service;

import io.restassured.RestAssured;
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

        Response response = given()
                .when()
                .get("/contacts");

        assertEquals(200, response.getStatusCode());

        Contact[] contacts = response.getBody().as(Contact[].class);

        List<Contact> contactList = Arrays.asList(contacts);

        addressBookMemory.addAll(contactList);

        System.out.println("Contacts retrieved from JSON Server:");

        addressBookMemory.forEach(System.out::println);

        assertTrue(addressBookMemory.size() > 0);
    }
}