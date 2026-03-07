package com.addressbookapp.manager;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookManager {

    private Map<String, AddressBookService> addressBooks = new HashMap<>();
    private Map<String, List<Contact>> cityDictionary = new HashMap<>();
    private Map<String, List<Contact>> stateDictionary = new HashMap<>();

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
    
    public void updateDictionaries(Contact contact){

        cityDictionary
                .computeIfAbsent(contact.getCity(), k -> new ArrayList<>())
                .add(contact);

        stateDictionary
                .computeIfAbsent(contact.getState(), k -> new ArrayList<>())
                .add(contact);
    }
    
    public void viewPersonsByCity(String city){

        if(!cityDictionary.containsKey(city)){
            System.out.println("No persons found in city: " + city);
            return;
        }

        System.out.println("\nPersons in city: " + city);

        cityDictionary.get(city)
                .forEach(System.out::println);
    }
    
    public void viewPersonsByState(String state){

        if(!stateDictionary.containsKey(state)){
            System.out.println("No persons found in state: " + state);
            return;
        }

        System.out.println("\nPersons in state: " + state);

        stateDictionary.get(state)
                .forEach(System.out::println);
    }
    
    public void countByCity(){

        if(cityDictionary.isEmpty()){
            System.out.println("No city records available.");
            return;
        }

        System.out.println("\nContact count by City:");

        cityDictionary.forEach((city, contacts) ->
                System.out.println(city + " → " + contacts.size()));
    }
    
    public void countByState(){

        if(stateDictionary.isEmpty()){
            System.out.println("No state records available.");
            return;
        }

        System.out.println("\nContact count by State:");

        stateDictionary.forEach((state, contacts) ->
                System.out.println(state + " → " + contacts.size()));
    }
}