    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Medicines;

import javax.persistence.Entity;

/**
 *
 * @author sejal
 */

@Entity 
public class AnestheticsDetails extends MedicineDetails {

    public AnestheticsDetails(String medname, String medvendor, MedicineType medtype) {
        super(medname, medvendor, medtype);
    }

    public AnestheticsDetails() {
    }
}
