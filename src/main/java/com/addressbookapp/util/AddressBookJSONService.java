package com.addressbookapp.util;


import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbookapp.entity.Contact;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * UC15:
 * Handles reading and writing AddressBook contacts as JSON using Gson.
 */
@Service
public class AddressBookJSONService {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Writes contacts to JSON file.
     */
    public void writeToJSON(String fileName, List<Contact> contactList) {

        try (FileWriter writer = new FileWriter(fileName)) {

            gson.toJson(contactList, writer);

            System.out.println("Contacts written to JSON successfully!");

        } catch (Exception e) {
            System.out.println("Error writing JSON: " + e.getMessage());
        }
    }

    /**
     * Reads contacts from JSON file.
     */
    public void readFromJSON(String fileName, List<Contact> contactList) {

        try (FileReader reader = new FileReader(fileName)) {

            Type contactListType = new TypeToken<List<Contact>>(){}.getType();

            List<Contact> contacts = gson.fromJson(reader, contactListType);

            contactList.clear();
            contactList.addAll(contacts);

            System.out.println("Contacts loaded from JSON successfully!");

        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }
}