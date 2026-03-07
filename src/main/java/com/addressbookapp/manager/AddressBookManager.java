package com.addressbookapp.manager;

import com.addressbookapp.service.AddressBookService;

import java.util.HashMap;
import java.util.Map;

public class AddressBookManager {

    private Map<String, AddressBookService> addressBooks = new HashMap<>();

    public void createAddressBook(String name){

        if(addressBooks.containsKey(name)){
            System.out.println("AddressBook already exists!");
            return;
        }

        addressBooks.put(name, new AddressBookService());
        System.out.println("AddressBook '" + name + "' created successfully.");
    }

    public AddressBookService getAddressBook(String name){
        return addressBooks.get(name);
    }

    public void displayAddressBooks(){

        if(addressBooks.isEmpty()){
            System.out.println("No AddressBooks available.");
            return;
        }

        System.out.println("Available AddressBooks:");

        for(String name : addressBooks.keySet()){
            System.out.println("- " + name);
        }
    }
}