/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

/**
 *
 * @author vaibhav
 */

public class HibernateController {

    
    
    private Session session;
    private Transaction transaction;
    private SessionFactory factory;
    
    public void startSession()  {
        this.factory = new Configuration().configure().buildSessionFactory();
        this.session = this.factory.openSession();
    }
    
    public void startTransation() {
        this.transaction = this.session.getTransaction();
    }
    
    public void commitTransaction() {
        this.transaction.commit();
    }
    
    public void closeSession() {
        this.session.close();
    }
    
    public void saveObject(Object o) {
        this.startSession();
        this.session.beginTransaction();
        this.session.save(o);
        this.session.getTransaction().commit();
        this.session.close();
        this.factory.close();
    }

}
