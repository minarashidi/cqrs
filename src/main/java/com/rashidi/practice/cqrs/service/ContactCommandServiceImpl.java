package com.rashidi.practice.cqrs.service;

import com.rashidi.practice.cqrs.model.Contact;
import com.rashidi.practice.cqrs.repository.impl.ContactRepository;
import com.rashidi.practice.cqrs.service.Impl.ContactCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ContactCommandServiceImpl implements ContactCommandService {

  private final ContactRepository contactRepository;

  @Autowired
  public ContactCommandServiceImpl(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @Override
  public Long create(Contact contact) {
    return contactRepository.create(contact);
  }

  @Override
  public void update(Contact contact) {
    contactRepository.update(contact);
  }

  @Override
  public void delete(long id) {
    contactRepository.delete(id);
  }
}
