package com.addressbookapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.addressbookapp.entity.Contact;
import com.addressbookapp.service.ContactService;

/**
 * ContactController handles all REST API requests for the Address Book.
 *
 * It connects the client requests to the Service layer.
 *
 * Supported operations:
 * - Add contact
 * - Get all contacts
 * - Edit contact
 * - Delete contact
 * - Search contacts by city/state
 * - Count contacts by city/state
 * - Sort contacts
 */

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     * UC2
     * Add a new contact
     */
    @PostMapping("/add")
    
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    /**
     * Display all contacts
     */
    //@GetMapping("/all")
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    /**
     * UC3
     * Edit contact using ID
     */
    @PutMapping("/edit/{id}")
    public Contact editContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        return contactService.editContact(id, updatedContact);
    }

    /**
     * UC4
     * Delete contact by ID
     */
    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "Contact deleted successfully";
    }

    /**
     * UC8
     * Search contacts by city
     */
    @GetMapping("/city/{city}")
    public List<Contact> searchByCity(@PathVariable String city) {
        return contactService.searchByCity(city);
    }

    /**
     * UC8
     * Search contacts by state
     */
    @GetMapping("/state/{state}")
    public List<Contact> searchByState(@PathVariable String state) {
        return contactService.searchByState(state);
    }

    /**
     * UC10
     * Count contacts by city
     */
    @GetMapping("/count/city/{city}")
    public Long countByCity(@PathVariable String city) {
        return contactService.countByCity(city);
    }

    /**
     * UC10
     * Count contacts by state
     */
    @GetMapping("/count/state/{state}")
    public Long countByState(@PathVariable String state) {
        return contactService.countByState(state);
    }

    /**
     * UC11
     * Sort contacts by name
     */
    @GetMapping("/sort/name")
    public List<Contact> sortByName() {
        return contactService.sortByName();
    }

    /**
     * UC12
     * Sort contacts by city
     */
    @GetMapping("/sort/city")
    public List<Contact> sortByCity() {
        return contactService.sortByCity();
    }

    /**
     * UC12
     * Sort contacts by state
     */
    @GetMapping("/sort/state")
    public List<Contact> sortByState() {
        return contactService.sortByState();
    }

    /**
     * UC12
     * Sort contacts by zip
     */
    @GetMapping("/sort/zip")
    public List<Contact> sortByZip() {
        return contactService.sortByZip();
    }
    
    @PostMapping("/add-multiple")
    public List<Contact> addMultipleContacts(@RequestBody List<Contact> contacts) {
        return contactService.addMultipleContacts(contacts);
    }
    
    @GetMapping("/date-range")
    public List<Contact> getContactsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {

        return contactService.getContactsAddedBetween(
                LocalDate.parse(startDate),
                LocalDate.parse(endDate)
        );
    }
    
    @GetMapping("/db/count/city/{city}")
    public int getContactCountByCity(@PathVariable String city) {
        return contactService.getContactCountByCity(city);
    }
    
    @GetMapping("/db/count/state/{state}")
    public int getContactCountByState(@PathVariable String state) {
        return contactService.getContactCountByState(state);
    }
}