/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.place;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import model.Employees.EmployeeDetails;

/**
 *
 * @author manohar
 */

@Entity
public class PlaceDetails implements Serializable {
    
    public enum Status {
        AVAILABLE, OCCUPIED
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="place_id")
    private int id;
    
    private String roomNumber;
    
    @OneToOne
    private EmployeeDetails vet;
    
    private Status status;
    
    @Transient
    private static int count;
    
    public PlaceDetails(EmployeeDetails vet) {
        this.status = Status.AVAILABLE;
        this.vet = vet;
        this.roomNumber = "Room " + String.valueOf(count+1);
        count++;
    }

    public PlaceDetails() {
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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

    public EmployeeDetails getVet() {
        return vet;
    }

    public void setVet(EmployeeDetails vet) {
        this.vet = vet;
    }
}
