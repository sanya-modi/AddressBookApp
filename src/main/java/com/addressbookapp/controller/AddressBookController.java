package com.addressbookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbookapp.entity.AddressBook;
import com.addressbookapp.repository.AddressBookRepository;

@RestController
@RequestMapping("/addressbooks")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @PostMapping
    public AddressBook createAddressBook(@RequestBody AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    @GetMapping
    public List<AddressBook> getAllAddressBooks() {
        return addressBookRepository.findAll();
    }
}