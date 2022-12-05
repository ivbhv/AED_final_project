/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Animal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manohar
 */

@Entity
public class AnimalStatusDetails implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="status_id")
    private int id;
    
    public enum Status{
        GOOD, RESERVED, BAD
    }
    
    @Temporal(TemporalType.DATE)
    private Date status_date;
    
    private double weight;
    private Status status;

    public AnimalStatusDetails(double weight, Status status) {
        this.status_date = new Date();
        this.weight = weight;
        this.status = status;
    }

    public AnimalStatusDetails() {
    }

    public Date getDate() {
        return status_date;
    }

    public void setDate(Date date) {
        this.status_date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
