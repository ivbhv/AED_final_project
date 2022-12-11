/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ShelterCell;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Animal.AnimalDetails;
import org.hibernate.Session;
import view.Main.Main;

/**
 *
 * @author vaibhav
 */
@Entity
public class ShelterCellDetails implements Serializable {
   
    public enum Status {
        OCCUPIED, AVAILABLE
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="shelter_id")
    private int cellno;
    
    private Status status;
    private String location;
    
    @OneToOne
    private AnimalDetails animal;

    public ShelterCellDetails() {
        this.status = Status.AVAILABLE;
    }

    public ShelterCellDetails(String location, AnimalDetails animal) {
        this.status = Status.AVAILABLE;
        this.location = location;
        this.animal = animal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }
    
    @Override
    public String toString() 
    {
        return String.valueOf(cellno);
    }

    public ShelterCellDetails getByLocation(String name) {
        
        
        List<ShelterCellDetails> result;
        try (Session s = Main.controller.getSession()) {
            CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
            CriteriaQuery<ShelterCellDetails> criteriaQuery = criteriaBuilder.createQuery(ShelterCellDetails.class);
            Root<ShelterCellDetails> root = criteriaQuery.from(ShelterCellDetails.class);
            criteriaQuery.where(criteriaBuilder.equal(root.get("location"), name));
            result = s.createQuery(criteriaQuery).getResultList();
            Main.controller.closeSession(s);
        }

        if(result.size() < 10){
            ShelterCellDetails shel = new ShelterCellDetails();
            shel.setLocation(name);
            shel.setStatus(Status.AVAILABLE);
            Main.controller.saveObject(shel);

            return shel;
        }
        
        return null;
    }
}
