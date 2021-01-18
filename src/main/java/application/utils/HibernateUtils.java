package application.utils;

import application.Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(CadruDidactic.class);
            configuration.addAnnotatedClass(Facultate.class);
            configuration.addAnnotatedClass(Firma.class);
            configuration.addAnnotatedClass(Sectie.class);
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Tutore.class);

            configuration.configure();

            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
            standardServiceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch(Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}