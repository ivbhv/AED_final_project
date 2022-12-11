/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Deliver;

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
import model.AdoptDetails.AdopterDetails;
import model.Animal.AnimalDetails;
import model.Employees.EmployeeDetails;

/**
 *
 * @author vaibhav
 */

@Entity
public class DeliveryDetails implements Serializable {
    
    public enum Status {
        WAITING, ASSIGNED, RECEIVED
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="delivery_id")
    private int id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="delivery_date")
    private Date date;
    
    @OneToOne
    private EmployeeDetails courierdetail;
    
    @OneToOne
    private AnimalDetails animal;
    
    @OneToOne
    private AdopterDetails adoptername;
    
    private Status status;

    public DeliveryDetails() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date d) {
        this.date = d;
    }

    public EmployeeDetails getCourierdetail() {
        return courierdetail;
    }

    public void setCourierdetail(EmployeeDetails courierdetail) {
        this.courierdetail = courierdetail;
    }

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }

    public AdopterDetails getAdoptername() {
        return adoptername;
    }

    public void setAdoptername(AdopterDetails adoptername) {
        this.adoptername = adoptername;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return date.toString();
    }
    
}
