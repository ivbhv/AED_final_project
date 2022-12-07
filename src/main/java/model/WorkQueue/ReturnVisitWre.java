/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorkQueue;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import model.AdoptDetails.AdopterDetails;
import model.Animal.AnimalDetails;

/**
 *
 * @author sejal
 */

@Entity
public class ReturnVisitWre extends AllWorkRequest 
{
    @OneToOne
    private AnimalDetails animal;
    
    @OneToOne
    private AdopterDetails adoptorname;
    
    private String result;

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }

    public AdopterDetails getAdoptorname() {
        return adoptorname;
    }

    public void setAdoptorname(AdopterDetails adoptorname) {
        this.adoptorname = adoptorname;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    
}
