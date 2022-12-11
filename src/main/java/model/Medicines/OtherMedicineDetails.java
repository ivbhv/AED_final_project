/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Medicines;

import javax.persistence.Entity;
import org.hibernate.Session;
import view.Main.Main;

/**
 *
 * @author sejal
 */

@Entity
public class OtherMedicineDetails extends MedicineDetails{

    public OtherMedicineDetails(String medname, String medvendor, MedicineType medtype) {
        super(medname, medvendor, medtype);
    }

    public OtherMedicineDetails() {


    }
    
    public OtherMedicineDetails getOrCreateMedicine(String medname, String medvendor, MedicineType medtype) {
        OtherMedicineDetails n;
        try (Session s = Main.controller.getSession()) {
            n = (OtherMedicineDetails) s.createQuery("from MedicineDetails n where n.medname = :medname and n.medvendor = :medvendor and n.medtype = :medtype").setParameter("medname", medname).setParameter("medvendor", medvendor).setParameter("medtype", medtype).uniqueResult();
            Main.controller.closeSession(s);
        }
        if (n == null) {
            n = new OtherMedicineDetails(medname, medvendor, medtype);
        } else {
            return n;
            
        }
        Main.controller.saveObject(n);
        return n;
    }
    
}
