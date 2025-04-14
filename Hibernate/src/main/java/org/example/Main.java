package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class Main {
    public static void main(String[] args) {

         Laptop L1 = new Laptop();
         L1.setBrand("vivoBook");
         L1.setRam(16);
         L1.setLid(5);


         Alien a = new Alien();
         a.setName("Amira");
         a.setTech("Java");
         a.setAId(70);
         a.setLap(L1);
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session  = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(L1);
        session.persist(a);






        transaction.commit();

        session.close();
        sf.close();

    }
}