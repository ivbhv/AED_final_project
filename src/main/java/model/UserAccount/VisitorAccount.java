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
import model.AdoptDetails.AdopterDetails;

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
    
    
}
