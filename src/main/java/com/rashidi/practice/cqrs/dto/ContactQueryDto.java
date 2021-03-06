package com.rashidi.practice.cqrs.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactQueryDto {

  private final long id;
  private final String name;
  private final String email;
  private final String phone;

  @JsonCreator
  public ContactQueryDto(@JsonProperty("id") long id,
                         @JsonProperty("name") String name,
                         @JsonProperty("email") String email,
                         @JsonProperty("phone") String phone) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }
}
