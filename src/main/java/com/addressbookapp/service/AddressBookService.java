package com.addressbookapp.service;

import java.util.List;

import com.addressbookapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class AddressBookService {

    private List<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
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
}
