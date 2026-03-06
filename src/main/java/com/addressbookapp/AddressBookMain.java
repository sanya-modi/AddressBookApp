package com.addressbookapp;

import java.util.Scanner;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;

public class AddressBookMain {

    public static void start() {

        Scanner scanner = new Scanner(System.in);
        AddressBookService service = new AddressBookService();

        while (true) {

            System.out.println("\n----- Address Book Menu -----");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Address: ");
                    String address = scanner.nextLine();

                    System.out.print("City: ");
                    String city = scanner.nextLine();

                    System.out.print("State: ");
                    String state = scanner.nextLine();

                    System.out.print("Zip: ");
                    String zip = scanner.nextLine();

                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, email, phone);

                    service.addContact(contact);

                    System.out.println("Contact Added Successfully!");
                    break;

                case 2:
                    service.displayContacts();
                    break;

                case 3:
                    System.out.println("Exiting Address Book...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
