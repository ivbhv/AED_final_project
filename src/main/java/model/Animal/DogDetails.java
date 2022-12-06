/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Animal;

import javax.persistence.Entity;

/**
 *
 * @author vaibhav
 */

@Entity
public class DogDetails extends AnimalDetails{
    private String breed;
    private String color;
    private String personality;

    public DogDetails() {
    }

    public DogDetails(String breed, String color, String personality) {
        this.breed = breed;
        this.color = color;
        this.personality = personality;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }
    
}
