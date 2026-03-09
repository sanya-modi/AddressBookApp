# AddressBookApp

AddressBookApp is a Spring Boot based console application used to manage contacts in an Address Book.  
It supports multiple address books, file storage, database operations using JDBC, multithreading, and REST API testing using REST Assured with JSON Server.

---

# START

- Created the **AddressBookAppApplication** Spring Boot project.
- Created **AddressBookMain** class to start the console application.
- Displayed the message **"Welcome to Address Book Application"** when the program starts.
- Established the base structure for the Address Book system.

---

# Section 1: Address Book Core Features

---

## UC1 – Ability to Create a Contact in Address Book

Implemented the ability to create a Contact with personal and address details.

### Features Implemented

- Created **Contact model class**
- Added fields:
  - First Name
  - Last Name
  - Address
  - City
  - State
  - Zip
  - Phone Number
  - Email
- Applied **OOP principles**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC1-CreateContact

---

## UC2 – Ability to Add a New Contact to Address Book

Implemented functionality to add a new contact to AddressBook.

### Features Implemented

- Created **AddressBookService**
- Implemented **addContact()**
- Stored contacts using **ArrayList**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC2-AddContact

---

## UC3 – Ability to Edit Existing Contact

Implemented functionality to edit an existing contact.

### Features Implemented

- Search contact using **person's first name**
- Update address, city, state, phone, email

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC3-EditContact

---

## UC4 – Ability to Delete a Person

Implemented functionality to delete a contact.

### Features Implemented

- Search by **first name**
- Remove contact from AddressBook

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC4-DeleteContact

---

## UC5 – Ability to Add Multiple Contacts

Implemented functionality to add multiple contacts.

### Features Implemented

- Used **ArrayList**
- Multiple contacts stored in AddressBook

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC5-AddMultipleContacts

---

## UC6 – Ability to Add Multiple AddressBooks

System now supports multiple AddressBooks.

### Features Implemented

- Created **AddressBookManager**
- Used **HashMap**
- AddressBookName → AddressBookService

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC6-AddMultipleAddressbooks

---

## UC7 – Prevent Duplicate Contacts

Implemented validation to prevent duplicate contacts.

### Features Implemented

- Used **Streams API**
- Checked duplicate using **person name**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC7-EnsureUniqueness

---

## UC8 – Search Person by City or State

Implemented search functionality.

### Features Implemented

- Search contacts by:
  - City
  - State
- Used **Streams API filtering**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC8-SearchContactWithCityOrState

---

## UC9 – View Persons by City or State

Implemented grouping of contacts.

### Features Implemented

- Maintained dictionaries:
  - City → List<Contact>
  - State → List<Contact>

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC9-ViewContactByCityOrState

---

## UC10 – Count Contacts by City or State

Implemented counting functionality.

### Features Implemented

- Count contacts by:
  - City
  - State
- Used **Streams API**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC10-CountByCityOrState

---

## UC11 – Sort Contacts by Person Name

Implemented alphabetical sorting.

### Features Implemented

- Used **Streams sorting**
- Sorted by **first name**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC11-SortByPersonName

---

## UC12 – Sort Contacts by City, State, or Zip

Implemented multiple sorting options.

### Features Implemented

- Sort by:
  - City
  - State
  - Zip

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC12-SortByCityStateOrZip

---

# Section 2: IO Streams

---

## UC13 – Read/Write AddressBook using File IO

Implemented File IO operations.

### Features Implemented

- Write contacts to **text file**
- Read contacts from file

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC13-ReadOrWriteUsingFileIO

---

## UC14 – Read/Write AddressBook using CSV

Implemented CSV file operations.

### Features Implemented

- Write contacts to **CSV**
- Read contacts from **CSV**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC14-ReadOrWriteUsingCSVFile

---

## UC15 – Read/Write AddressBook using JSON

Implemented JSON operations.

### Features Implemented

- Used **Jackson Library**
- Write contacts to JSON
- Read contacts from JSON

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC15-ReadOrWriteUsingJSON

---

# Section 3: JDBC

---

## UC16 – Retrieve Contacts from Database

Implemented database retrieval.

### Features Implemented

- JDBC connection
- Retrieve contacts using SQL
- JUnit tests implemented

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC16-RetrieveContactsFromDatabase

---

## UC17 – Update Contact and Sync with Database

Implemented update functionality.

### Features Implemented

- Updated contact using **PreparedStatement**
- Verified synchronization using **JUnit**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC17-update-contact-db-sync

---

## UC18 – Retrieve Contacts by Date Range

Implemented date range filtering.

### Features Implemented

- Used SQL **BETWEEN query**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC18-retrieve-contacts-by-date-range

---

## UC19 – Count Contacts by City/State in Database

Implemented aggregation queries.

### Features Implemented

- Used **GROUP BY queries**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC19-count-contacts-by-city-state-db

---

## UC20 – Add Contact using Database Transaction

Implemented insertion using transaction.

### Features Implemented

- Inserted contact across multiple tables
- Ensured **ACID properties**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC20-add-contact-transaction

---

# Section 4: Multithreading

---

## UC21 – Add Multiple Contacts using Threads

Implemented concurrent contact insertion.

### Features Implemented

- Used **Java Threads**
- Added contacts simultaneously
- Measured execution time

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC21-add-multiple-contacts-threads

---

# Section 5: REST Assured

---

## UC22 – Retrieve Contacts from JSON Server

Implemented REST API testing.

### Features Implemented

- Used **REST Assured**
- Retrieved contacts from **JSON Server**
- Converted JSON response to **Contact objects**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC22-read-contacts-jsonserver

---

## UC23 – Add Contact to JSON Server

Implemented POST API.

### Features Implemented

- Sent **POST request**
- Added contact to JSON Server

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC23-add-contact-jsonserver

---

## UC24 – Update Contact in JSON Server

Implemented PUT API.

### Features Implemented

- Updated contact using **PUT request**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC24-update-contact-jsonserver

---

## UC25 – Delete Contact from JSON Server

Implemented DELETE API.

### Features Implemented

- Deleted contact using **DELETE request**

### GitHub Branch

https://github.com/iakashhhh/AddressBookApp/tree/feature/UC25-delete-contact-jsonserver

---

# Technologies Used

- Java 17
- Spring Boot
- Maven
- JDBC
- MySQL
- REST Assured
- JSON Server
- JUnit
- Git & GitHub

---

# Author

Akash Sharma  
GitHub: https://github.com/iakashhhh
