package com.bridgelabz.addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.ContactInfo;
import com.bridgelabz.addressbook.repository.AddressbBookRepository;

@Service
public class AddressBookServices implements IAddressBookServices {
	@Autowired
	private AddressbBookRepository addressBookRepository;

	public List<ContactInfo> getContact() {

		return addressBookRepository.findAll();
	}

	public ContactInfo getContactById(long contactId) {
		return addressBookRepository.findById(contactId)
				.orElseThrow(() -> new AddressBookException("Contact with id " + contactId + " does not exist..!"));
	}

	public ContactInfo createContact(ContactDTO contactDTO) {
		ContactInfo contact = new ContactInfo(contactDTO);
		return addressBookRepository.save(contact);
	}

	public ContactInfo updateContact(long contactId, ContactDTO contactDTO) {
		ContactInfo contact = this.getContactById(contactId);
		contact.updateContact(contactDTO);
		return addressBookRepository.save(contact);
	}

	public void deleteContact(long contactId) {
		ContactInfo contact = this.getContactById(contactId);
		addressBookRepository.delete(contact);
	}

	public String deleteAllAddressBookData() {
		addressBookRepository.deleteAll();
		return "Successfully deleted all the Contacts from AddressBook";
	}
}
