package com.addressbookapp.service;



import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addressbookapp.entity.AddressBook;
import com.addressbookapp.entity.Contact;
import com.addressbookapp.repository.ContactRepository;
import com.addressbookapp.repository.AddressBookRepository;

/**
 * ContactService contains the business logic of the Address Book system.
 *
 * It connects Controller with Repository and implements the operations
 * required by different Use Cases.
 */

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * UC18
     * Update Add new contact
     */
    public Contact addContact(Contact contact) {

        if(contactRepository.existsByEmail(contact.getEmail())) {
            throw new RuntimeException("Contact with this email already exists");
        }

        contact.setDateAdded(LocalDate.now());

        return contactRepository.save(contact);
    }

    /**
     * Display all contacts
     */
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    /**
     * UC3
     * Edit existing contact
     */
    public Contact editContact(Long id, Contact updatedContact) {

        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        existingContact.setFirstName(updatedContact.getFirstName());
        existingContact.setLastName(updatedContact.getLastName());
        existingContact.setAddress(updatedContact.getAddress());
        existingContact.setCity(updatedContact.getCity());
        existingContact.setState(updatedContact.getState());
        existingContact.setZip(updatedContact.getZip());
        existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
        existingContact.setEmail(updatedContact.getEmail());

        return contactRepository.save(existingContact);
    }

    /**
     * UC4
     * Delete contact by ID
     */
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    /**
     * UC8
     * Search contacts by city
     */
    public List<Contact> searchByCity(String city) {
        return contactRepository.findByCityIgnoreCase(city);
    }

    /**
     * UC8
     * Search contacts by state
     */
    public List<Contact> searchByState(String state) {
        return contactRepository.findByStateIgnoreCase(state);
    }

    /**
     * UC10
     * Count contacts by city
     */
    public long countByCity(String city) {
        return contactRepository.countByCityIgnoreCase(city);
    }

    /**
     * UC10
     * Count contacts by state
     */
    public long countByState(String state) {
        return contactRepository.countByStateIgnoreCase(state);
    }

    /**
     * UC11
     * Sort contacts alphabetically by name
     */
    public List<Contact> sortByName() {

        List<Contact> contacts = contactRepository.findAll();

        contacts.sort(Comparator
                .comparing(Contact::getFirstName)
                .thenComparing(Contact::getLastName));

        return contacts;
    }

    /**
     * UC12
     * Sort contacts by city
     */
    public List<Contact> sortByCity() {

        List<Contact> contacts = contactRepository.findAll();

        contacts.sort(Comparator.comparing(Contact::getCity));

        return contacts;
    }

    /**
     * UC12
     * Sort contacts by state
     */
    public List<Contact> sortByState() {

        List<Contact> contacts = contactRepository.findAll();

        contacts.sort(Comparator.comparing(Contact::getState));

        return contacts;
    }

    /**
     * UC12
     * Sort contacts by zip
     */
    public List<Contact> sortByZip() {

        List<Contact> contacts = contactRepository.findAll();

        contacts.sort(Comparator.comparing(Contact::getZip));

        return contacts;
    }
    
    public List<Contact> addMultipleContacts(List<Contact> contacts) {

        for(Contact contact : contacts) {

            if(contactRepository.existsByEmail(contact.getEmail())) {
                throw new RuntimeException("Contact already exists with email: " + contact.getEmail());
            }
        }

        return contactRepository.saveAll(contacts);
    }
    
    public List<Contact> getContactsAddedBetween(LocalDate startDate, LocalDate endDate) {

        return contactRepository.findByDateAddedBetween(startDate, endDate);
    }
    
    public int getContactCountByCity(String city) {
        return contactRepository.countContactsByCityFunction(city);
    }
    
    public int getContactCountByState(String state) {
        return contactRepository.countContactsByStateFunction(state);
    }
    
    @Transactional
    public Contact addContactToAddressBook(Long addressBookId, Contact contact) {

        AddressBook addressBook = addressBookRepository.findById(addressBookId)
                .orElseThrow(() -> new RuntimeException("AddressBook not found"));

        contact.setAddressBook(addressBook);
        contact.setDateAdded(LocalDate.now());

        return contactRepository.save(contact);
    }
}