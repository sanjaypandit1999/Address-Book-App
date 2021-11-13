package com.bridgelabz.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.addressbook.model.ContactInfo;

public interface AddressbBookRepository extends JpaRepository<ContactInfo, Long> {

	@Query(value = "select * from addressbook where city= :city", nativeQuery = true)
	List<ContactInfo> findContactListByCity(String city);

	@Query(value = "select * from addressbook where first_Name= :firstName", nativeQuery = true)
	List<ContactInfo> findContactListByFirstName(String firstName);

	@Query(value = "select * from addressbook where last_Name= :lastName", nativeQuery = true)
	List<ContactInfo> findContactListByLastName(String lastName);

	@Query(value = "select * from addressbook where zip= :zip", nativeQuery = true)
	List<ContactInfo> findContactListByZip(String zip);

	@Query(value = "select * from addressbook order by first_name;", nativeQuery = true)
	List<ContactInfo> sortByName();

	@Query(value = "select * from addressbook order by city;", nativeQuery = true)
	List<ContactInfo> sortByCity();

	@Query(value = "select * from addressbook order by zip;", nativeQuery = true)
	List<ContactInfo> sortByPincode();

}
