package com.rashidi.practice.cqrs.controller;

import com.rashidi.practice.cqrs.dto.ContactCommandDto;
import com.rashidi.practice.cqrs.model.Contact;
import com.rashidi.practice.cqrs.service.Impl.ContactCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/contacts")
public class ContactCommandController {

  private static final Logger logger = LoggerFactory.getLogger(ContactCommandController.class);

  private final ContactCommandService contactCommandService;

  @Autowired
  public ContactCommandController(ContactCommandService contactCommandService) {
    this.contactCommandService = contactCommandService;
  }

  @PostMapping
  public ResponseEntity<Object> create(@RequestBody ContactCommandDto contactDto) {
    Contact contact = new Contact(contactDto.getId(), contactDto.getName(), contactDto.getEmail(), contactDto.getPhone());
    long savedContactId = contactCommandService.create(contact);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedContactId).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void update(@RequestBody ContactCommandDto contactDto) {
    Contact contact = new Contact(contactDto.getId(), contactDto.getName(), contactDto.getEmail(), contactDto.getPhone());
    contactCommandService.update(contact);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable long id) {
    contactCommandService.delete(id);
  }

}
