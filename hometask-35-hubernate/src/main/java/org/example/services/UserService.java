package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements InitializingBean {
    private final SessionFactory sessionFactory;

    public List<PersonEntity> getAllPersons() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List persons = session.createQuery("from PersonEntity").list();
        session.getTransaction().commit();
        session.close();
        return persons;
    }

    public PersonEntity getPersonById(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        PersonEntity person = session.get(PersonEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    public void createPerson(PersonEntity person) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    public void updatePerson(PersonEntity person) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
        session.close();
    }

    public void deletePerson(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        PersonEntity person = session.get(PersonEntity.class, id);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PersonEntity person = new PersonEntity();
        person.setId(UUID.randomUUID());
        person.setFirstName("John");
        person.setLastName("Smith");
        person.setEmail("john.smith@gmail.com");
        person.setPassword("password");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}
