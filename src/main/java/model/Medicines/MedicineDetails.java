/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Medicines;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author manohar
 */

@Entity
public class MedicineDetails implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String medname;
    private String medvendor;
    private MedicineType medtype;

    public MedicineDetails() {
    }

    public MedicineDetails(String medname, String medvendor, MedicineType medtype) {
        this.medname = medname;
        this.medvendor = medvendor;
        this.medtype = medtype;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedvendor() {
        return medvendor;
    }

    public void setMedvendor(String medvendor) {
        this.medvendor = medvendor;
    }

    public MedicineType getMedtype() {
        return medtype;
    }

    public void setMedtype(MedicineType medtype) {
        this.medtype = medtype;
    }
    
    public enum MedicineType {
        Anesthetics, Antibiotics, Vaccination, Other
    }
}
