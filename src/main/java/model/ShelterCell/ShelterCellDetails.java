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
import model.Animal.AnimalDetails;
import model.Cages.CageDetail;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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

    public ShelterCellDetails getOrCreateByName(String name) {
        Session s = Main.controller.getSession();
        Criteria criteria = s.createCriteria(ShelterCellDetails.class);
        criteria.add(Restrictions.eq("location", name));
        List result = criteria.list();
        s.close();

        if(result.size() < 10){
            ShelterCellDetails shel = new ShelterCellDetails();
            shel.setLocation(name);
            shel.setStatus(Status.AVAILABLE);
            Main.controller.saveObject(s);

            return shel;
        }
        s.close();
        return null;
    }
}
