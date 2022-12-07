/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorkQueue;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import model.Medicines.MedicineDetails;

/**
 *
 * @author sejal
 */

@Entity
public class PharmacyUnitWre implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pharmacy_id")
    private int id;
    
    @OneToOne
    private MedicineDetails medicine;
    
    private int quantity;

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public MedicineDetails getMedicine() 
    {
        return medicine;
    }

    public void setMedicine(MedicineDetails medicine) 
    {
        this.medicine = medicine;
    }
    
}
