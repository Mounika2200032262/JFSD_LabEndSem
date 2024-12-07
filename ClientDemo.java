package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        // Configure Hibernate
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert records
        Client client1 = new Client();
        client1.setName("Alice");
        client1.setGender("Female");
        client1.setAge(30);
        client1.setLocation("New York");
        client1.setEmail("alice@example.com");
        client1.setMobileNumber("1234567890");

        Client client2 = new Client();
        client2.setName("Bob");
        client2.setGender("Male");
        client2.setAge(35);
        client2.setLocation("San Francisco");
        client2.setEmail("bob@example.com");
        client2.setMobileNumber("9876543210");

        session.persist(client1);
        session.persist(client2);

        // Commit transaction
        transaction.commit();

        // Fetch all records
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        System.out.println("All Clients:");
        for (Client client : clients) {
            System.out.println(client);
        }

        // Close session
        session.close();
        sessionFactory.close();
    }
}
