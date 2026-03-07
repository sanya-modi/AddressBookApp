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
            System.out.println("4 Search Person by City");
            System.out.println("5 Search Person by State");
            System.out.println("6 View Persons by City");
            System.out.println("7 View Persons by State");
            System.out.println("8 Count Persons by City");
            System.out.println("9 Count Persons by State");
            System.out.println("10 Exit");

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

                    addressBookMenu(service,scanner, manager);
                    break;

                case 3:
                    manager.displayAddressBooks();
                    break;

                case 4:

                    System.out.print("Enter City name: ");
                    String city = scanner.nextLine();

                    manager.searchByCity(city);
                    break;

                case 5:

                    System.out.print("Enter State name: ");
                    String state = scanner.nextLine();

                    manager.searchByState(state);
                    break;

                case 6:

                    System.out.print("Enter City: ");
                    String viewByCity = scanner.nextLine();

                    manager.viewPersonsByCity(viewByCity);
                    break;

                case 7:

                    System.out.print("Enter State: ");
                    String viewByState = scanner.nextLine();

                    manager.viewPersonsByState(viewByState);
                    break;
                    
                case 8:
                    manager.countByCity();
                    break;

                case 9:
                    manager.countByState();
                    break;

                case 10:
                    System.out.println("Exiting AddressBook Application...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addressBookMenu(AddressBookService service, Scanner scanner, AddressBookManager manager){
    	    	
        while(true){

        	System.out.println("\n--- AddressBook Menu ---");
        	System.out.println("1 Add Contact");
        	System.out.println("2 Display Contacts");
        	System.out.println("3 Delete Contact");
        	System.out.println("4 Sort Contacts by Name");
        	System.out.println("5 Sort Contacts by City");
        	System.out.println("6 Sort Contacts by State");
        	System.out.println("7 Sort Contacts by Zip");
        	System.out.println("8 Back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){

                case 1:

                    char addMore;

                    do{

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

                        Contact contact = new Contact(firstName,lastName,address,city,state,zip,phone,email);

                        boolean added = service.addContact(contact);

                        if(added){
                            manager.updateDictionaries(contact);
                            System.out.println("Contact Added Successfully!");
                        }
                        else{
                            System.out.println("Duplicate contact found! Contact not added.");
                        }

                        System.out.print("Do you want to add another contact? (y/n): ");
                        addMore = scanner.next().charAt(0);
                        scanner.nextLine();

                    }while(addMore == 'y' || addMore == 'Y');

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
                    service.sortContactsByName();
                    break;

                case 5:
                    service.sortContactsByCity();
                    break;

                case 6:
                    service.sortContactsByState();
                    break;

                case 7:
                    service.sortContactsByZip();
                    break;

                case 8:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}