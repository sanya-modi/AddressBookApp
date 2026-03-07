package com.addressbookapp;

import com.addressbookapp.manager.AddressBookManager;
import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;

import java.util.Scanner;

public class AddressBookMain {

    public static void start(){

        Scanner scanner = new Scanner(System.in);
        AddressBookManager manager = new AddressBookManager();

        while(true){

            System.out.println("\n------ AddressBook System ------");
            System.out.println("1 Create AddressBook");
            System.out.println("2 Select AddressBook");
            System.out.println("3 Show AddressBooks");
            System.out.println("4 Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){

                case 1:

                    System.out.print("Enter new AddressBook name: ");
                    String name = scanner.nextLine();

                    manager.createAddressBook(name);
                    break;

                case 2:

                    manager.displayAddressBooks();

                    System.out.print("\nEnter AddressBook name to open: ");
                    String bookName = scanner.nextLine();

                    AddressBookService service = manager.getAddressBook(bookName);

                    if(service == null){
                        System.out.println("AddressBook not found!");
                        break;
                    }

                    System.out.println("\nAddressBook '" + bookName + "' opened successfully.");

                    addressBookMenu(service,scanner);
                    break;

                case 3:
                    manager.displayAddressBooks();
                    break;

                case 4:
                    System.out.println("Exiting AddressBook Application...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addressBookMenu(AddressBookService service, Scanner scanner){

        while(true){

            System.out.println("\n--- AddressBook Menu ---");
            System.out.println("1 Add Contact");
            System.out.println("2 Display Contacts");
            System.out.println("3 Delete Contact");
            System.out.println("4 Back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){

                case 1:

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("City: ");
                    String city = scanner.nextLine();

                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();

                    Contact contact = new Contact(firstName,lastName,"",city,"","",phone,"");

                    service.addContact(contact);
                    break;

                case 2:
                    service.displayContacts();
                    break;

                case 3:

                    System.out.print("Enter first name to delete: ");
                    String name = scanner.nextLine();

                    if(service.deleteContact(name))
                        System.out.println("Contact deleted successfully!");
                    else
                        System.out.println("Contact not found!");

                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}