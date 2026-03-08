package com.addressbookapp.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Contact class represents a single person in the Address Book.
 * 
 * It stores personal details such as name, address, city, state, zip, phone
 * number, and email.
 * 
 * This class is used across multiple use cases (UC1, UC2, UC3) as the core data
 * model.
 * UC7: Overrides equals() to prevent duplicate entries.
 */

@Entity
@Table(name = "contacts")
public class Contact {

	/**
     * Primary Key for database table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "address_book_id")
	private AddressBook addressBook;
	

    /**
     * Default constructor required by JPA
     */
    public Contact() {
    }

	public Contact(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	

	// setters (needed for UC-3)
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
	    return city;
	}

	public String getState() {
	    return state;
	}
	public String getAddress() { 
		return address; 
	}

	// getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
	    return lastName;
	}
	public String getZip() {
	    return zip;
	}
	public String getPhoneNumber() { 
		return phoneNumber; 
	}
	public String getEmail() { 
		return email; 
	}
	
	
	public AddressBook getAddressBook() {
	    return addressBook;
	}

	public void setAddressBook(AddressBook addressBook) {
	    this.addressBook = addressBook;
	}
	
    /**
     * UC7:
     * Two contacts are considered equal if
     * they have the same first name and last name.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Contact contact = (Contact) obj;

        return firstName.equalsIgnoreCase(contact.firstName)
                && lastName.equalsIgnoreCase(contact.lastName);
    }
    
    /**
     * hashCode overridden to maintain contract with equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

	/**
	 * Displays all contact details in a readable format. Used after adding or
	 * editing a contact.
	 */
	public void displayContact() {
		System.out.println("----- Contact Details -----");
		System.out.println("Name        : " + firstName + " " + lastName);
		System.out.println("Address     : " + address);
		System.out.println("City        : " + city);
		System.out.println("State       : " + state);
		System.out.println("Zip         : " + zip);
		System.out.println("Phone No.   : " + phoneNumber);
		System.out.println("Email       : " + email);
	}
	@Override
	public String toString() {
	    return "Name: " + firstName + " " + lastName +
	            ", Address: " + address +
	            ", City: " + city +
	            ", State: " + state +
	            ", Zip: " + zip +
	            ", Phone: " + phoneNumber +
	            ", Email: " + email;
	}
}
