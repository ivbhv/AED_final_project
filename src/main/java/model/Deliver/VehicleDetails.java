/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Deliver;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author vaibhav
 */

@Entity
public class VehicleDetails implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="delivery_id")
    private int vehicleno;
    
    private int vehiclecapacity;

    public VehicleDetails() {
    }

    public VehicleDetails(int vehiclecapacity) {
        this.vehiclecapacity = vehiclecapacity;
    }

    public int getVehiclecapacity() {
        return vehiclecapacity;
    }

    public void setVehiclecapacity(int vehiclecapacity) {
        this.vehiclecapacity = vehiclecapacity;
    }
   
}
