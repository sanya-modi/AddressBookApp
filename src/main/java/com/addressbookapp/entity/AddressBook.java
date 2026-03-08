package com.addressbookapp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "address_books")
public class AddressBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contact> contacts;

	public AddressBook() {
	}

	public AddressBook(String name) {
		this.name = name;
	}

	// getters & setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}