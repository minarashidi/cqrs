package com.rashidi.practice.cqrs.service.Impl;

import com.rashidi.practice.cqrs.model.Contact;

public interface ContactCommandService {

  Long create(Contact contact);

  void update(Contact contact);

  void delete(long id);
}
