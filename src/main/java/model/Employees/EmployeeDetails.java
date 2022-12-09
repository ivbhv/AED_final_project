/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Employees;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import model.Network.NetworkDetails;
import org.hibernate.Session;
import view.Main.Main;

/**
 *
 * @author manohar
 */

@Entity
public class EmployeeDetails implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="status_id")
    private int id;
    
    private String name;
    
    @Column(unique = true)
    private String email;

    public EmployeeDetails(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public EmployeeDetails() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public EmployeeDetails getOrCreateByEmail(String name, String email) {
        EmployeeDetails n;
        try (Session s = Main.controller.getSession()) {
            n = (EmployeeDetails) s.createQuery("from EmployeeDetails n where n.email = :email ").setParameter("email", email).uniqueResult();
        }
        if (n != null) {
            return n;

        } else {
            n = new EmployeeDetails(name, email);
        }
        Main.controller.saveObject(n);
        
        return n;
    }
}
