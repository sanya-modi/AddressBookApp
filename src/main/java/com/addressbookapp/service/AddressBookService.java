package com.addressbookapp.service;

import java.util.List;

import com.addressbookapp.model.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBookService {

    private List<Contact> contactList = new ArrayList<>();

    public boolean addContact(Contact contact){

        boolean duplicate = contactList
                .stream()
                .anyMatch(c -> c.equals(contact));

        if(duplicate){
            return false;
        }

        contactList.add(contact);
        return true;
    }

    public void displayContacts() {
        if(contactList.isEmpty()){
            System.out.println("No contacts available");
            return;
        }

        for(Contact contact : contactList){
            System.out.println(contact);
        }
    }
    
    public void sortContactsByName(){

        if(contactList.isEmpty()){
            System.out.println("No contacts available to sort.");
            return;
        }

        contactList.stream()
                .sorted((c1, c2) -> c1.getFirstName()
                .compareToIgnoreCase(c2.getFirstName()))
                .forEach(System.out::println);
    }
    
    public void sortContactsByCity(){

        if(contactList.isEmpty()){
            System.out.println("No contacts available.");
            return;
        }

        contactList.stream()
                .sorted(java.util.Comparator.comparing(Contact::getCity))
                .forEach(System.out::println);
    }
    
    public void sortContactsByState(){

        if(contactList.isEmpty()){
            System.out.println("No contacts available.");
            return;
        }

        contactList.stream()
                .sorted(java.util.Comparator.comparing(Contact::getState))
                .forEach(System.out::println);
    }
    
    public void sortContactsByZip(){

        if(contactList.isEmpty()){
            System.out.println("No contacts available.");
            return;
        }

        contactList.stream()
                .sorted(java.util.Comparator.comparing(Contact::getZip))
                .forEach(System.out::println);
    }
    
    public Contact findContact(String firstName) {

        for (Contact contact : contactList) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                return contact;
            }
        }

        return null;
    }
    
    public boolean deleteContact(String firstName) {

        Iterator<Contact> iterator = contactList.iterator();

        while (iterator.hasNext()) {

            Contact contact = iterator.next();

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
    
    public List<Contact> getContacts(){
        return contactList;
    }
    
}
