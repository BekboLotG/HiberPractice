package org.example.entity.secondClass.Util2;

import org.example.entity.fristClass.Penguin;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil2 {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.DRIVER,"org.postgresql.Driver");
                properties.put(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
                properties.put(Environment.USER,"postgres");
                properties.put(Environment.PASS,"bekbolot");
                properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQL9Dialect");
                properties.put(Environment.HBM2DDL_AUTO,"create-drop");
                properties.put(Environment.SHOW_SQL,true);

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Penguin.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }
}
