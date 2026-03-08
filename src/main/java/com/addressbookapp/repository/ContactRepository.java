package com.addressbookapp.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.addressbookapp.entity.Contact;

/**
 * ContactRepository handles database operations for Contact entity.
 *
 * By extending JpaRepository, Spring Boot automatically provides:
 * - save()
 * - findAll()
 * - findById()
 * - deleteById()
 * - count()
 * - and many more CRUD operations.
 *
 * Custom query methods are also defined here.
 */

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    /**
     * Find contacts by city
     */
    List<Contact> findByCityIgnoreCase(String city);

    /**
     * Find contacts by state
     */
    List<Contact> findByStateIgnoreCase(String state);

    /**
     * Count contacts by city
     */
    long countByCityIgnoreCase(String city);

    /**
     * Count contacts by state
     */
    long countByStateIgnoreCase(String state);
    
    boolean existsByEmail(String email);
    
    List<Contact> findByDateAddedBetween(LocalDate startDate, LocalDate endDate);
    
    @Query(value = "SELECT count_contacts_by_city(?1)", nativeQuery = true)
    int countContactsByCityFunction(String city);

    @Query(value = "SELECT count_contacts_by_state(?1)", nativeQuery = true)
    int countContactsByStateFunction(String state);

}
