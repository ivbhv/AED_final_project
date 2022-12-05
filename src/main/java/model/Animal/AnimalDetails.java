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
//    private TreatmentRecordDetailsDirectory treatmentDirectory;
//    private AnimalStatusDetailsDirectory statusDirectory;
    

    public AnimalDetails() {
        
//        this.statusDirectory = new AnimalStatusDetailsDirectory();
//        this.animalstatus = UNREADY_STATUS;
//        this.nextcheck = new Date();
//        this.treatmentDirectory = new TreatmentRecordDetailsDirectory();
//        this.statusDirectory = new AnimalStatusDetailsDirectory();
    }
    
    public AnimalDetails(int age, boolean isSterilized, String color, String gender, AnimalType type, String status, Date nextCheck) {
        this.age = age;
        this.isSterilized = isSterilized;
        this.color = color;
        this.gender = gender;
        this.type = type;
        this.status = Status.NOT_READY;
        this.nextCheck = nextCheck;
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
