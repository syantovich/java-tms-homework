package org.example.services;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.search.PersonSearch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
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

    public List<PersonEntity> findByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<PersonEntity> personEntities = session.createQuery("from PersonEntity where firstName = :name", PersonEntity.class).setParameter("name", name).list();
        session.getTransaction().commit();
        session.close();
        return personEntities;
    }

    public List<PersonEntity> findAllWhereAgeLessThan(int age) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<PersonEntity> list = session.createQuery("from PersonEntity pe where pe.fullAge < :age", PersonEntity.class).setParameter("age", age).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public List<PersonEntity> find(PersonSearch personSearch) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> criteriaQuery = criteriaBuilder.createQuery(PersonEntity.class);
        Root<PersonEntity> from = criteriaQuery.from(PersonEntity.class);
        CriteriaQuery<PersonEntity> select = criteriaQuery.select(from);
        if (personSearch != null) {
            String lastName = personSearch.getLastName();
            String firstName = personSearch.getFirstName();
            int minAge = personSearch.getMinAge();
            int maxAge = personSearch.getMaxAge();
            if (lastName != null) {
                criteriaQuery.where(criteriaBuilder.like(from.get("lastName"), "%" + lastName + "%"));
            }
            if (firstName != null) {
                criteriaQuery.where(criteriaBuilder.like(from.get("firstName"), "%" + firstName + "%"));
            }
            criteriaQuery.where(criteriaBuilder.between(from.get("fullAge"), minAge, maxAge));
        }

        return session.createQuery(criteriaQuery).list();

    }


}
