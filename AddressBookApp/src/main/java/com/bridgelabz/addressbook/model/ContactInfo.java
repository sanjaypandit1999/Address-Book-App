package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;

import lombok.Data;

@Data
public class ContactInfo {
	private int contactId;
	public String firstName;
	public String lastName;
	public String address;
	public String state;
	public String city;
	public String zip;
	public String phone;

	public ContactInfo(int contactId, ContactDTO contactDTO) {
		this.contactId = contactId;
		this.firstName = contactDTO.firstName;
		this.lastName = contactDTO.lastName;
		this.address = contactDTO.address;
		this.state = contactDTO.state;
		this.city = contactDTO.city;
		this.zip = contactDTO.zip;
		this.phone = contactDTO.phone;
	}

}