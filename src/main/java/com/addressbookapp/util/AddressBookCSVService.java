package com.addressbookapp.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbookapp.entity.Contact;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * UC14: Handles CSV read/write using OpenCSV library.
 */
@Service
public class AddressBookCSVService {

	/**
	 * Write contacts to CSV file using OpenCSV.
	 */
	public void writeToCSV(String fileName, List<Contact> contactList) {

		try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {

			for (Contact contact : contactList) {

				String[] data = { 
						contact.getFirstName(), 
						contact.getLastName(), 
						contact.getAddress(),
						contact.getCity(), 
						contact.getState(), 
						contact.getZip(), 
						contact.getPhoneNumber(),
						contact.getEmail() 
						};

				writer.writeNext(data);
			}

			System.out.println("Contacts written to CSV successfully!");

		} catch (IOException e) {
			System.out.println("Error writing CSV: " + e.getMessage());
		}
	}

	/**
	 * Read contacts from CSV file using OpenCSV.
	 */
	public void readFromCSV(String fileName, List<Contact> contactList) {

		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

			List<String[]> records = reader.readAll();

			for (String[] data : records) {

				if (data.length == 8) {

					Contact contact = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6],
							data[7]);

					contactList.add(contact);
				}
			}

			System.out.println("Contacts loaded from CSV successfully!");

		} catch (Exception e) {
			System.out.println("Error reading CSV: " + e.getMessage());
		}
	}
}
