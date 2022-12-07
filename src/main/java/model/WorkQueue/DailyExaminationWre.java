/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorkQueue;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import model.Animal.AnimalDetails;

/**
 *
 * @author sejal
 */

@Entity
public class DailyExaminationWre extends AllWorkRequest {
    
    private String result;
    
    @OneToOne
    private AnimalDetails animal;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }

    
}
