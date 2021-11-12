package com.bridgelabz.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.ContactInfo;

@Service
public class AddressBookServices implements IAddressBookServices {
	 List<ContactInfo> contactList = new ArrayList<>();

	    @Override
	    public List<ContactInfo> getContact() {

	        return contactList;
	    }

	    @Override
	    public ContactInfo getContactById(int contactId) {
	        return contactList.get(contactId - 1);
	    }

	    @Override
	    public ContactInfo createContact(ContactDTO contactDTO) {
	        ContactInfo contact = new ContactInfo(contactList.size() + 1, contactDTO);
	        contactList.add(contact);
	        return contact;
	    }

	    @Override
	    public ContactInfo updateContact(int contactId, ContactDTO contactDTO) {
	        ContactInfo contact = this.getContactById(contactId);
	        contact.setFirstName(contactDTO.firstName);
	        contact.setLastName(contactDTO.lastName);
	        contact.setAddress(contactDTO.address);
	        contact.setState(contactDTO.state);
	        contact.setCity(contactDTO.city);
	        contact.setZip(contactDTO.zip);
	        contact.setPhone(contactDTO.phone);
	        contactList.set(contactId - 1, contact);
	        return contact;
	    }

	    @Override
	    public void deleteContact(int contactId) {
	        contactList.remove(contactId-1);
	    }

}
