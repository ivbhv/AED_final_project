/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.AdoptDetails;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.Animal.AnimalDetails;

/**
 *
 * @author sejal
 */

@Entity
public class AdoptHistory implements Serializable {
    
    public enum Status {
    Submitted, Assigned, Approved, Rejected, InProgress
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String message;
    
    @Temporal(TemporalType.DATE)
    private Date adoptDate;
    
    @OneToOne
    private AnimalDetails details;
    
    private Status status;
    
    public AdoptHistory(String message, Date adoptDate, Status status, AnimalDetails details) {
        this.message = message;
        this.adoptDate = adoptDate;
        this.status = status;
        this.details = details;
    }

    public AnimalDetails getDetails() {
        return details;
    }

    public void setDetails(AnimalDetails details) {
        this.details = details;
    }

    public AdoptHistory() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAdoptDate() {
        return adoptDate;
    }

    public void setAdoptDate(Date adoptDate) {
        this.adoptDate = adoptDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
