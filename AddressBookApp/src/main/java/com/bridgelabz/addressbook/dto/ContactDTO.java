package com.bridgelabz.addressbook.dto;

import lombok.ToString;

@ToString
public class ContactDTO {
	public String firstName;
	public String lastName;
	public String address;
	public String state;
	public String city;
	public String zip;
	public String phone;

	public ContactDTO(String firstName, String lastName, String address, String state, String city, String zip,
			String phone) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
	}

}
