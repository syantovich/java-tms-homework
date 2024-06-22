package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final SessionFactory sessionFactory;

    public void saveProduct(ProductEntity product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteProduct(UUID uuid) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ProductEntity product = session.get(ProductEntity.class, uuid);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    public List<ProductEntity> findByIds(List<UUID> ids) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ArrayList<ProductEntity> productEntities = new ArrayList<>();
        for (UUID uuid : ids) {
            ProductEntity product = session.get(ProductEntity.class, uuid);
            productEntities.add(product);
        }
        session.getTransaction().commit();
        session.close();
        return productEntities;
    }

    public ProductEntity findById(UUID uuid) {
        return findByIds(List.of(uuid)).get(0);
    }
}
