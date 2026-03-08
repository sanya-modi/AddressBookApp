package com.addressbookapp.util;


import java.io.*;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbookapp.entity.Contact;

/**
 * AddressBookFileIO handles file read and write operations.
 * 
 * UC13: Read and Write Address Book using Java File IO.
 */
@Service
public class AddressBookFileIO {

    /**
     * Writes contact list to a file in CSV format.
     */
    public void writeToFile(String fileName, List<Contact> contactList) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Contact contact : contactList) {

                writer.write(
                        contact.getFirstName() + "," +
                        contact.getLastName() + "," +
                        contact.getAddress() + "," +
                        contact.getCity() + "," +
                        contact.getState() + "," +
                        contact.getZip() + "," +
                        contact.getPhoneNumber() + "," +
                        contact.getEmail()
                );

                writer.newLine();
            }

            System.out.println("Contacts written to file successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    /**
     * Reads contacts from file and returns list of Contact objects.
     */
    public void readFromFile(String fileName, List<Contact> contactList) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 8) {

                    Contact contact = new Contact(
                            data[0], data[1], data[2],
                            data[3], data[4], data[5],
                            data[6], data[7]
                    );

                    contactList.add(contact);
                }
            }

            System.out.println("Contacts loaded from file successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}