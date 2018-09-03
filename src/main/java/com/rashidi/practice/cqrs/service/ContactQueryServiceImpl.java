package com.rashidi.practice.cqrs.service;

import com.rashidi.practice.cqrs.model.Contact;
import com.rashidi.practice.cqrs.repository.impl.ContactRepository;
import com.rashidi.practice.cqrs.service.Impl.ContactQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ContactQueryServiceImpl implements ContactQueryService {

  private final ContactRepository contactRepository;

  @Autowired
  public ContactQueryServiceImpl(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @Override
  public Optional<Contact> findById(long id) {
    return contactRepository.findById(id);
  }

  @Override
  public List<Contact> findAll() {
    return contactRepository.findAll();
  }
}
