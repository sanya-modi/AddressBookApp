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
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:

                char addMore;

                do {

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

                    System.out.print("Do you want to add another contact? (y/n): ");
                    addMore = scanner.next().charAt(0);
                    scanner.nextLine();

                } while (addMore == 'y' || addMore == 'Y');

                break;
                
                case 2:
                    service.displayContacts();
                    break;

                case 3:

                    System.out.print("Enter First Name of contact to edit: ");
                    String searchName = scanner.nextLine();

                    Contact existingContact = service.findContact(searchName);

                    if (existingContact == null) {
                        System.out.println("Contact not found!");
                        break;
                    }

                    System.out.print("New Address: ");
                    existingContact.setAddress(scanner.nextLine());

                    System.out.print("New City: ");
                    existingContact.setCity(scanner.nextLine());

                    System.out.print("New State: ");
                    existingContact.setState(scanner.nextLine());

                    System.out.print("New Zip: ");
                    existingContact.setZip(scanner.nextLine());

                    System.out.print("New Phone: ");
                    existingContact.setPhoneNumber(scanner.nextLine());

                    System.out.print("New Email: ");
                    existingContact.setEmail(scanner.nextLine());

                    System.out.println("Contact Updated Successfully!");
                    break;

                case 4:

                    System.out.print("Enter First Name of contact to delete: ");
                    String deleteName = scanner.nextLine();

                    boolean deleted = service.deleteContact(deleteName);

                    if (deleted) {
                        System.out.println("Contact Deleted Successfully!");
                    } else {
                        System.out.println("Contact not found!");
                    }

                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
