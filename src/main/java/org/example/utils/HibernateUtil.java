package org.example.utils;

import org.example.classes.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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

    public Object read(String query, Class<?> clazz) {
        return read(query, clazz, false);
    }

    public Object read(String query, Class<?> clazz, boolean silent) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Object result = session.createQuery(query, clazz).getSingleResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            if (!silent) {
                System.out.println("Error reading from database: " + e.getMessage());
            }
            return null;
        }
    }

    public void update(Object object) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(object);
            session.getTransaction().commit();
        }
    }

    public void delete(Object object) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(object);
            session.getTransaction().commit();
        }
    }
}


//         HibernateUtil hibernateUtil = new HibernateUtil();
//         Player player = new Player(4, "ant", "ant123", "securePass123", 3, "room1", new PlayerCell(new Coordinates(0, 0)));
//         hibernateUtil.delete(player);
//         hibernateUtil.create(player);
//         Object test = hibernateUtil.read("FROM Player WHERE id = 4", Player.class);
//         System.out.println(test);
//         hibernateUtil.shutdown();