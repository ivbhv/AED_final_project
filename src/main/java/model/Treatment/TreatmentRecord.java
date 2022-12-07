/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Treatment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.Animal.AnimalDetails;
import model.Medicines.MedicineDetails;
import model.Place.PlaceDetails;

/**
 *
 * @author manohar
 */

@Entity
public class TreatmentRecord implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="treatment_id")
    private int id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="treatment_date")
    private Date date;
    
    @ManyToOne
    private AnimalDetails animalDeatils;
    
    @OneToOne
    private PlaceDetails room;
    
    @OneToMany
    @JoinColumn(name = "treatment_id")
    private List<MedicineDetails> medicineList;
    
    private boolean isReviewed;

    public TreatmentRecord(AnimalDetails animalDeatils, PlaceDetails room) {
        this.date = new Date();
        this.animalDeatils = animalDeatils;
        this.room = room;
        this.medicineList = new ArrayList();
        this.isReviewed = false;
    }

    public TreatmentRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AnimalDetails getAnimalDeatils() {
        return animalDeatils;
    }

    public void setAnimalDeatils(AnimalDetails animalDeatils) {
        this.animalDeatils = animalDeatils;
    }

    public PlaceDetails getRoom() {
        return room;
    }

    public void setRoom(PlaceDetails room) {
        this.room = room;
    }

    public List<MedicineDetails> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<MedicineDetails> medicineList) {
        this.medicineList = medicineList;
    }

    public boolean isIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(boolean isReviewed) {
        this.isReviewed = isReviewed;
    }
}
