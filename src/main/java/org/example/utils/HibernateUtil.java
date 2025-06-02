package org.example.utils;

import org.example.classes.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private SessionFactory sessionFactory;

    protected void setUp() {
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

}
