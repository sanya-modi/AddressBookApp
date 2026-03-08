package com.addressbookapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.addressbookapp.entity.Contact;

@SpringBootTest
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    /**
     * UC16
     * Test retrieval of all contacts from database
     */
    @Test
    void shouldRetrieveAllContactsFromDatabase() {

        List<Contact> contacts = contactService.getAllContacts();

        assertNotNull(contacts, "Contact list should not be null");

        System.out.println("Total contacts found: " + contacts.size());

        contacts.forEach(contact -> System.out.println(contact));
    }

    /**
     * UC8
     * Test search contacts by city
     */
    @Test
    void shouldSearchContactsByCity() {

        String city = "Bhopal";

        List<Contact> contacts = contactService.searchByCity(city);

        assertNotNull(contacts, "Contacts list should not be null");

        contacts.forEach(contact -> 
            assertEquals(city.toLowerCase(), contact.getCity().toLowerCase())
        );
    }

    /**
     * UC10
     * Test count contacts by state
     */
    @Test
    void shouldCountContactsByState() {

        String state = "MP";

        long count = contactService.countByState(state);

        assertTrue(count >= 0, "Count should never be negative");

        System.out.println("Total contacts in " + state + ": " + count);
    }
}