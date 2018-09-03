package com.rashidi.practice.cqrs.repository;

import com.rashidi.practice.cqrs.model.Contact;
import com.rashidi.practice.cqrs.repository.impl.ContactRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Optional<Contact> findById(long id) {
    return entityManager.createQuery("select c from Contact c where c.id = :id", Contact.class)
      .setParameter("id", id)
      .setMaxResults(1)
      .getResultList()
      .stream()
      .findFirst();
  }

  @Override
  public List<Contact> findAll() {
    return entityManager.createQuery("from Contact c", Contact.class).getResultList();
  }

  @Override
  public long create(Contact contact) {
    entityManager.persist(contact);
    entityManager.flush();
    return contact.getId();
  }

  @Override
  public void update(Contact contact) {
    Query query = entityManager.createQuery("update Contact c set c.name = :name, c.email = :email, c.phone = :phone where c.id = :id");
    query.setParameter("id", contact.getId());
    query.setParameter("name", contact.getName());
    query.setParameter("email", contact.getEmail());
    query.setParameter("phone", contact.getPhone());
    query.executeUpdate();
  }

  @Override
  public void delete(long id) {
    final Contact contact = entityManager.find(Contact.class, id);
    entityManager.remove(contact);
  }
}
