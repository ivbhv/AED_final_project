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
public class AntibioticsDetails extends MedicineDetails {

    public AntibioticsDetails(String medname, String medvendor, MedicineType medtype) {
        super(medname, medvendor, medtype);
    }

    public AntibioticsDetails() {
    }
    
    public AntibioticsDetails getOrCreateMedicine(String medname, String medvendor, MedicineType medtype) {
        AntibioticsDetails n;
        try (Session s = Main.controller.getSession()) {
            n = (AntibioticsDetails) s.createQuery("from MedicineDetails n where n.medname = :medname and n.medvendor = :medvendor and n.medtype = :medtype").setParameter("medname", medname).setParameter("medvendor", medvendor).setParameter("medtype", medtype).uniqueResult();
            Main.controller.closeSession(s);
        }
        if (n == null) {
            n = new AntibioticsDetails(medname, medvendor, medtype);
        } else {
            return n;
            
        }
        Main.controller.saveObject(n);
        return n;
    }
    
}
