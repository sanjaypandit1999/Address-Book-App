package com.bridgelabz.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.addressbook.model.ContactInfo;

public interface AddressbBookRepository extends JpaRepository<ContactInfo, Long> {

}
