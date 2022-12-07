/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Animal;

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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.Treatment.TreatmentRecord;

/**
 *
 * @author sejal
 */

@Entity
public class AnimalDetails implements Serializable {
    
    public enum Status {
        READY, NOT_READY, ADOPTED
    }
    
    public enum AnimalType {
        Dog, Cat, Other
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="animal_id")
    private int id;
    
    private int age;
    private boolean isSterilized;
    private String color;
    private String gender;
    private AnimalType type;
    private Status status;
    
    @Temporal(TemporalType.DATE)
    private Date nextCheck;
    
    @OneToMany(mappedBy = "animalDeatils")
    private List<TreatmentRecord> treatmentRecord;
    
    @OneToMany
    @JoinColumn(name = "animal_id")
    private List<AnimalStatusDetails> statusDirectory;

    public AnimalDetails() {
    }
    
    public AnimalDetails(int age, boolean isSterilized, String color, String gender, AnimalType type) {
        this.age = age;
        this.isSterilized = isSterilized;
        this.color = color;
        this.gender = gender;
        this.type = type;
        this.status = Status.NOT_READY;
        this.nextCheck = new Date();
        this.treatmentRecord = new ArrayList();
        this.statusDirectory = new ArrayList();
    }

    public List<AnimalStatusDetails> getStatusDirectory() {
        return statusDirectory;
    }

    public void setStatusDirectory(ArrayList<AnimalStatusDetails> statusDirectory) {
        this.statusDirectory = statusDirectory;
    }
    
    public List<TreatmentRecord> getTreatmentRecord() {
        return treatmentRecord;
    }

    public void setTreatmentRecord(List<TreatmentRecord> treatmentRecord) {
        this.treatmentRecord = treatmentRecord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIsSterilized() {
        return isSterilized;
    }

    public void setIsSterilized(boolean isSterilized) {
        this.isSterilized = isSterilized;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getNextCheck() {
        return nextCheck;
    }

    public void setNextCheck(Date nextCheck) {
        this.nextCheck = nextCheck;
    }

    
}
