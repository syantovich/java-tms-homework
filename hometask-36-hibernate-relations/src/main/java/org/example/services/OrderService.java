package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.OrderEntity;
import org.example.entities.PersonEntity;
import org.example.entities.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final SessionFactory sessionFactory;
    private final ProductsService productsService;
    private final PersonService personService;


    public void save(OrderEntity order) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

    public void createOrder(UUID personId, List<UUID> productIds) {
        OrderEntity orderEntity = new OrderEntity();
        PersonEntity person = personService.findById(personId);
        List<ProductEntity> products = productsService.findByIds(productIds);
        orderEntity.setPerson(person);
        orderEntity.setProducts(products);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(orderEntity);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        OrderEntity order = session.get(OrderEntity.class, id);
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }

    public OrderEntity findById(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        OrderEntity order = session.get(OrderEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return order;
    }
}
