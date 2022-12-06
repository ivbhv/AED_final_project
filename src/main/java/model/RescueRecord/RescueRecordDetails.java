/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.RescueRecord;

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
import model.Employees.EmployeeDetails;
import model.Place.PlaceDetails;

/**
 *
 * @author manohar
 */

@Entity
public class RescueRecordDetails implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="record_id")
    private int id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="rescue_date")
    private Date date;
    
    @OneToOne
    private AnimalDetails rescuedanimal;
    
    @OneToOne
    private PlaceDetails rescueroom;
    
    @OneToOne
    private EmployeeDetails rescuername;
    
    private String foundlocation;
    private boolean health;

    public RescueRecordDetails() {
    }

    public RescueRecordDetails(AnimalDetails rescuedanimal, PlaceDetails rescueroom, EmployeeDetails rescuername, String foundlocation, boolean health) {
        this.date = new Date();
        this.rescuedanimal = rescuedanimal;
        this.rescueroom = rescueroom;
        this.rescuername = rescuername;
        this.foundlocation = foundlocation;
        this.health = health;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AnimalDetails getRescuedanimal() {
        return rescuedanimal;
    }

    public void setRescuedanimal(AnimalDetails rescuedanimal) {
        this.rescuedanimal = rescuedanimal;
    }

    public PlaceDetails getRescueroom() {
        return rescueroom;
    }

    public void setRescueroom(PlaceDetails rescueroom) {
        this.rescueroom = rescueroom;
    }

    public EmployeeDetails getRescuername() {
        return rescuername;
    }

    public void setRescuername(EmployeeDetails rescuername) {
        this.rescuername = rescuername;
    }

    public String getFoundlocation() {
        return foundlocation;
    }

    public void setFoundlocation(String foundlocation) {
        this.foundlocation = foundlocation;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }
           
    @Override
    public String toString() {
        return date.toString();
    }
}
