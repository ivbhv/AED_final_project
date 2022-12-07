/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorkQueue;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import model.AdoptDetails.AdoptRecord;

/**
 *
 * @author sejal
 */

@Entity
public class AdoptionVisitWre extends AllWorkRequest {
    
    private String result;
    
    @OneToOne
    private AdoptRecord adoptiondetails;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public AdoptRecord getAdoptiondetails() {
        return adoptiondetails;
    }

    public void setAdoptiondetails(AdoptRecord adoptiondetails) {
        this.adoptiondetails = adoptiondetails;
    }
    
}
