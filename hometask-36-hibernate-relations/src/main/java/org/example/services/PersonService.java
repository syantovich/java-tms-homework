package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final SessionFactory sessionFactory;

    public void save(PersonEntity person) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        PersonEntity personEntity = session.get(PersonEntity.class, id);
        session.delete(personEntity);
        session.getTransaction().commit();
        session.close();
    }

    public PersonEntity findById(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        PersonEntity personEntity = session.get(PersonEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return personEntity;
    }
}
