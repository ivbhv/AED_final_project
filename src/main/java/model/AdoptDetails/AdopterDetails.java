/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.AdoptDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author vaibhav
 */

@Entity
public class AdopterDetails implements Serializable {
    
    @Id
    private String ssnNumber;
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private AddressDetails address;
    private String email;
    
    @OneToMany
    @JoinColumn(name = "adoptor_ssn")
    private List<AdoptHistory> history;

    public AdopterDetails() {
    }

    public AdopterDetails(String ssnNumber, String firstName, String lastName, String phoneNumber, AddressDetails address, String email) {
        this.ssnNumber = ssnNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.history = new ArrayList();
    }

    public String getSsnNumber() {
        return ssnNumber;
    }

    public void setSsnNumber(String ssnNumber) {
        this.ssnNumber = ssnNumber;
    }

    public List<AdoptHistory> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<AdoptHistory> history) {
        this.history = history;
    }


    public String getSsnnumber() {
        return ssnNumber;
    }

    public void setSsnnumber(String ssnnumber) {
        this.ssnNumber = ssnnumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressDetails getAddress() {
        return address;
    }

    public void setAddress(AddressDetails address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
