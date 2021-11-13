package com.bridgelabz.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.ContactInfo;
import com.bridgelabz.addressbook.services.IAddressBookServices;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookServices addressbookservice;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getContactData() {
		List<ContactInfo> contactList = addressbookservice.getContact();
		ResponseDTO response = new ResponseDTO("Get call success", contactList);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getContactData(@PathVariable("contactId") int contactId) {
		ContactInfo contact = addressbookservice.getContactById(contactId);
		ResponseDTO response = new ResponseDTO("Get call success for id", contact);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addContactData(@Valid @RequestBody ContactDTO contactDTO) {
		ContactInfo contact = addressbookservice.createContact(contactDTO);
		ResponseDTO response = new ResponseDTO("Created contact data for", contact);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateContactData(@Valid @PathVariable("contactId") int contactId,
			@RequestBody ContactDTO contactDTO) {
		ContactInfo contact = addressbookservice.updateContact(contactId, contactDTO);
		ResponseDTO response = new ResponseDTO("Updated contact data for", contact);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") int contactId) {
		addressbookservice.deleteContact(contactId);
		ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + contactId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}
}
