package com.rashidi.practice.cqrs.repository.impl;

import com.rashidi.practice.cqrs.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {

  Optional<Contact> findById(long id);

  List<Contact> findAll();

  long create(Contact contact);

  void update(Contact contact);

  void delete(long ContactId);
}
