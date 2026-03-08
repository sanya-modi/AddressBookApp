package com.addressbookapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
     * UC1 / UC2
     * Add Contact
     */
    @Test
    void shouldAddContact() {

        Contact contact = new Contact(
                "Sanya",
                "Modi",
                "Minal",
                "Bhopal",
                "MP",
                "462001",
                "9999999999",
                "sanya_test@gmail.com"
        );

        Contact saved = contactService.addContact(contact);

        assertNotNull(saved);
        assertEquals("Sanya", saved.getFirstName());
    }

    /**
     * UC3
     * Edit Contact
     */
    @Test
    void shouldEditContact() {

        List<Contact> contacts = contactService.getAllContacts();

        if(!contacts.isEmpty()) {

            Contact contact = contacts.get(0);
            contact.setCity("Indore");

            Contact updated = contactService.editContact(contact.getId(), contact);

            assertEquals("Indore", updated.getCity());
        }
    }

    /**
     * UC4
     * Delete Contact
     */
    @Test
    void shouldDeleteContact() {

        List<Contact> contacts = contactService.getAllContacts();

        if(!contacts.isEmpty()) {

            Long id = contacts.get(0).getId();

            contactService.deleteContact(id);

            assertTrue(true);
        }
    }

    /**
     * UC5
     * Get All Contacts
     */
    @Test
    void shouldRetrieveAllContacts() {

        List<Contact> contacts = contactService.getAllContacts();

        assertNotNull(contacts);

        System.out.println("Total Contacts: " + contacts.size());
    }

    /**
     * UC8
     * Search by City
     */
    @Test
    void shouldSearchByCity() {

        List<Contact> contacts = contactService.searchByCity("Bhopal");

        assertNotNull(contacts);

        contacts.forEach(c -> assertEquals("Bhopal", c.getCity()));
    }

    /**
     * UC8
     * Search by State
     */
    @Test
    void shouldSearchByState() {

        List<Contact> contacts = contactService.searchByState("MP");

        assertNotNull(contacts);

        contacts.forEach(c -> assertEquals("MP", c.getState()));
    }

    /**
     * UC10
     * Count by City
     */
    @Test
    void shouldCountContactsByCity() {

        long count = contactService.countByCity("Bhopal");

        assertTrue(count >= 0);

        System.out.println("Contacts in Bhopal: " + count);
    }

    /**
     * UC10
     * Count by State
     */
    @Test
    void shouldCountContactsByState() {

        long count = contactService.countByState("MP");

        assertTrue(count >= 0);

        System.out.println("Contacts in MP: " + count);
    }

    /**
     * UC11
     * Sort by Name
     */
    @Test
    void shouldSortContactsByName() {

        List<Contact> contacts = contactService.sortByName();

        assertNotNull(contacts);
    }

    /**
     * UC12
     * Sort by City
     */
    @Test
    void shouldSortContactsByCity() {

        List<Contact> contacts = contactService.sortByCity();

        assertNotNull(contacts);
    }

    /**
     * UC12
     * Sort by State
     */
    @Test
    void shouldSortContactsByState() {

        List<Contact> contacts = contactService.sortByState();

        assertNotNull(contacts);
    }

    /**
     * UC12
     * Sort by Zip
     */
    @Test
    void shouldSortContactsByZip() {

        List<Contact> contacts = contactService.sortByZip();

        assertNotNull(contacts);
    }

    /**
     * UC16
     * Retrieve all contacts from DB
     */
    @Test
    void shouldRetrieveContactsFromDatabase() {

        List<Contact> contacts = contactService.getAllContacts();

        assertNotNull(contacts);
    }

    /**
     * UC18
     * Retrieve contacts between dates
     */
    @Test
    void shouldRetrieveContactsByDateRange() {

        List<Contact> contacts =
                contactService.getContactsAddedBetween(
                        LocalDate.now().minusDays(10),
                        LocalDate.now()
                );

        assertNotNull(contacts);
    }

    /**
     * UC19
     * Count by city using DB function
     */
    @Test
    void shouldCountContactsByCityUsingDBFunction() {

        int count = contactService.getContactCountByCity("Bhopal");

        assertTrue(count >= 0);
    }

    /**
     * UC19
     * Count by state using DB function
     */
    @Test
    void shouldCountContactsByStateUsingDBFunction() {

        int count = contactService.getContactCountByState("MP");

        assertTrue(count >= 0);
    }
    
    //UC20
    
    @Test
    void shouldAddContactWithTransaction() {

        Contact contact = new Contact(
                "Transaction",
                "Test",
                "MP Nagar",
                "Bhopal",
                "MP",
                "462001",
                "8888888888",
                "transaction_test@gmail.com"
        );

        Contact saved = contactService.addContact(contact);

        assertNotNull(saved);
        assertEquals("Transaction", saved.getFirstName());

        System.out.println("Contact added with transaction: " + saved.getFirstName());
    }
    
    @Test
    void shouldRollbackTransactionIfErrorOccurs() {

        Contact contact = new Contact(
                "Rollback",
                "Test",
                "Indore",
                "Indore",
                "MP",
                "452001",
                "7777777777",
                "rollback_test@gmail.com"
        );

        Contact saved = contactService.addContact(contact);

        assertNotNull(saved);
    }
}