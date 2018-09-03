package com.rashidi.practice.cqrs.service.Impl;

import com.rashidi.practice.cqrs.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactQueryService {

  Optional<Contact> findById(long id);

  List<Contact> findAll();

}
