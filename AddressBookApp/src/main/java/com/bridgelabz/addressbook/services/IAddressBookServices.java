package com.bridgelabz.addressbook.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.ContactInfo;

@Service
public interface IAddressBookServices {
	List<ContactInfo> getContact();

    ContactInfo getContactById(long contactId);

    ContactInfo createContact(ContactDTO contactDTO);

    ContactInfo updateContact(long contactId, ContactDTO contactDTO);

    void deleteContact(long contactId);

    String deleteAllAddressBookData();

}
