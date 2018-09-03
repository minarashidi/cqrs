package com.rashidi.practice.cqrs.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "contactSeq", sequenceName = "s_contact", allocationSize = 1)
public class Contact {

  private long id;

  private String name;

  private String email;

  private String phone;

  public Contact() {
  }

  public Contact(long id, String name, String email, String phone) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactSeq")
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

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Contact contact = (Contact) o;

    if (id != contact.id) return false;
    if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
    if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
    return phone != null ? phone.equals(contact.phone) : contact.phone == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Contact{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", email='" + email + '\'' +
      ", phone='" + phone + '\'' +
      '}';
  }
}
