/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Cages;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import model.Animal.AnimalDetails;

/**
 *
 * @author sejal
 */

@Entity
public class CageDetail implements Serializable {
    
    public enum Status {
        OCCUPIED, AVAILABLE
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cage_number")
    private int cellno;
    
    private String cagelocation;
    private Status cagestatus;
    
    @OneToOne
    private AnimalDetails animal;
    
    public CageDetail() {
    }

    public CageDetail(String cagelocation, AnimalDetails animal) {
        this.cagelocation = cagelocation;
        this.cagestatus = Status.AVAILABLE;
        this.animal = animal;
    }

    public int getCellno() {
        return cellno;
    }

    public void setCellno(int cellno) {
        this.cellno = cellno;
    }

    public String getCagelocation() {
        return cagelocation;
    }

    public void setCagelocation(String cagelocation) {
        this.cagelocation = cagelocation;
    }

    public Status getCagestatus() {
        return cagestatus;
    }

    public void setCagestatus(Status cagestatus) {
        this.cagestatus = cagestatus;
    }

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }

    

}
