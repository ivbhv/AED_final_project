/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author vaibhav
 */

@Entity
public class AdoptionOffered implements Serializable {
    
    public enum Status {
        Open, Close
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="offered_id")
    private int id;
    
    @OneToOne
    private AnimalDetails animal;
    
    @Temporal(TemporalType.DATE)
    @Column(name="offered_date")
    private Date publishDate;
    
    private Status status;

    public AdoptionOffered(AnimalDetails animal, Date publishDate) {
        this.animal = animal;
        this.publishDate = publishDate;
        this.status = Status.Open;
    }

    public AdoptionOffered() {
        this.status = Status.Open;
    }

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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
    
    @Override
    public String toString() {
        return animal.getType().toString();
    }
    
}
