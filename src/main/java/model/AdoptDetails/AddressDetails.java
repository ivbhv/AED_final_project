/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.AdoptDetails;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author vaibhav
 */

@Embeddable
public class AddressDetails implements Serializable {
    
    private String streetName;
    private String cityName;
    private String stateName;

    public AddressDetails(String streetName, String cityName, String stateName) {
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateName = stateName;
    }

    public AddressDetails() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public AddressDetails getAddressByName(String cityName) {
        return null;
    }
    
    
}

