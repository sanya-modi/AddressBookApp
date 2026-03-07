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
    
    public void searchByCity(String city){

        System.out.println("\nPersons in city: " + city);

        boolean found = false;

        for(Map.Entry<String, AddressBookService> entry : addressBooks.entrySet()){

            String bookName = entry.getKey();
            AddressBookService service = entry.getValue();

            for(var contact : service.getContacts()){

                if(contact.getCity().equalsIgnoreCase(city)){
                    System.out.println(contact + " | AddressBook: " + bookName);
                    found = true;
                }
            }
        }

        if(!found){
            System.out.println("No person found in city: " + city);
        }
    }

    public void searchByState(String state){

        System.out.println("\nPersons in state: " + state);

        boolean found = false;

        for(Map.Entry<String, AddressBookService> entry : addressBooks.entrySet()){

            String bookName = entry.getKey();
            AddressBookService service = entry.getValue();

            for(var contact : service.getContacts()){

                if(contact.getState().equalsIgnoreCase(state)){
                    System.out.println(contact + " | AddressBook: " + bookName);
                    found = true;
                }
            }
        }

        if(!found){
            System.out.println("No person found in state: " + state);
        }
    }
}