package com.bridgelabz.addressbook.controller;

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

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@GetMapping("/get-all")
	public ResponseEntity<ResponseDTO> getAllContact() {
		ResponseDTO respDto = new ResponseDTO("Get call Succeed", null);
		return new ResponseEntity<>(respDto, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable int contactId) {
		ResponseDTO respDto = new ResponseDTO("Get call Succeed for id : ", + contactId);
		return new ResponseEntity<>(respDto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contactDTO) {
		ResponseDTO respDto = new ResponseDTO("Created Contact Data for : ", contactDTO);
		return new ResponseEntity<>(respDto, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable int contactId, @RequestBody ContactDTO contactDTO) {
		ResponseDTO respDto = new ResponseDTO("Updated Contact Data for : " + contactId, contactDTO);
		return new ResponseEntity<>(respDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int contactId) {
		ResponseDTO respDto = new ResponseDTO("Deleted Contact Data for : " + contactId, null);
		return new ResponseEntity<>(respDto, HttpStatus.OK);
	}

}
