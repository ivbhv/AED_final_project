/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorkQueue;

import javax.persistence.Entity;
import model.Animal.AnimalDetails;

/**
 *
 * @author sejal
 */

@Entity
public class TreatmentWre extends AllWorkRequest
{
    private AnimalDetails animal;

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }
}
