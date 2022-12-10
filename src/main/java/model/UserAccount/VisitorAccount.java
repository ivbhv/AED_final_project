/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.UserAccount;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.AdoptDetails.AdopterDetails;
import org.hibernate.Session;
import view.Main.Main;

/**
 *
 * @author sejal
 */

@Entity
public class VisitorAccount implements Serializable {
    
    @Id
    private String username;
    
    private String password;
    
    @Column(unique=true)
    private String email;
    
    @OneToOne
    private AdopterDetails adoptor;

    public VisitorAccount(String username, String password, String email, AdopterDetails adoptor) {
        this.username = username;
        this.password = password;
        this.adoptor = adoptor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public VisitorAccount() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdopterDetails getAdoptor() {
        return adoptor;
    }

    public void setAdoptor(AdopterDetails adoptor) {
        this.adoptor = adoptor;
    }
    
    public VisitorAccount authenticateUser(String username, String password) {

        VisitorAccount u;
        try (Session s = Main.controller.getSession()) {
            CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
            CriteriaQuery<VisitorAccount> criteriaQuery = criteriaBuilder.createQuery(VisitorAccount.class);
            Root<VisitorAccount> root = criteriaQuery.from(VisitorAccount.class);
            criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
            u = s.createQuery(criteriaQuery).uniqueResult();
            s.close();
        }

        if(u == null) {
            return null;
        }

        if (u.getPassword().equals(password)) {
            return u;
        }

        return null;

    }
}
