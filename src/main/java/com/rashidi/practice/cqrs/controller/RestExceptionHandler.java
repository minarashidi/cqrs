package com.rashidi.practice.cqrs.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.NoResultException;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = NoResultException.class)
  public ResponseEntity handleContactNotFound() {
    return new ResponseEntity<>("Contact not found!", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({ AccessDeniedException.class })
  public ResponseEntity<Object> handleAccessDeniedException() {
    return new ResponseEntity<>("Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
  }
}
