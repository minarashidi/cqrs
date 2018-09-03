package com.rashidi.practice.cqrs.controller;

import com.rashidi.practice.cqrs.dto.ContactQueryDto;
import com.rashidi.practice.cqrs.model.Contact;
import com.rashidi.practice.cqrs.service.Impl.ContactQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/contacts")
public class ContactQueryController {
  private static final Logger logger = LoggerFactory.getLogger(ContactQueryController.class);

  private final ContactQueryService contactQueryService;

  @Autowired
  public ContactQueryController(ContactQueryService contactQueryService) {
    this.contactQueryService = contactQueryService;
  }

  @GetMapping("/{id}")
  public Contact getContact(@PathVariable long id) {
    return contactQueryService
      .findById(id)
      .orElseThrow(NoResultException::new);
  }

  @GetMapping
  public List<ContactQueryDto> getContacts() {
    return contactQueryService.findAll().stream()
      .map(con -> new ContactQueryDto(con.getId(), con.getName(), con.getEmail(), con.getPhone()))
      .collect(Collectors.toList());
  }

}
