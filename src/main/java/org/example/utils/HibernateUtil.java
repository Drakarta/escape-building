package org.example.utils;

import org.example.classes.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HibernateUtil {
    private SessionFactory sessionFactory;

    public HibernateUtil() {
        final StandardServiceRegistry registry =
            new StandardServiceRegistryBuilder()
				.build();
        try {
            sessionFactory =
                new MetadataSources(registry)
                    .addAnnotatedClass(Player.class)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed." + e);
        }
    }

    public void shutdown() throws Exception {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    public void create(Object object) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(object);
            session.getTransaction().commit();
        }
    }
}
