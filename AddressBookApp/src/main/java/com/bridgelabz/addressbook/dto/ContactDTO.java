package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.Pattern;

import lombok.ToString;

@ToString
public class ContactDTO {
	@Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "FirstName is invalid")
	public String firstName;
	@Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "LastName is invalid")
	public String lastName;
	public String address;
	public String state;
	public String city;
	@Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Invalid Zip")
	public String zip;
	@Pattern(regexp = "^^[0-9]{2}?[\\s,-]{0,1}[7-9]{1}[0-9]{9}$", message = "Invalid Phone number")
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
