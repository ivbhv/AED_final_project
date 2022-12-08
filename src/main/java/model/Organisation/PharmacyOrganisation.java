/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Organisation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import model.Medicines.MedicineDetails;
import model.Role.AllRoles;
import model.Role.PharmacistRole;

/**
 *
 * @author vaibhav
 */

@Entity
public class PharmacyOrganisation extends OrganisationMain{
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<MedicineDetails> medicine;
    
    
    public PharmacyOrganisation() {
        super(OrganisationMain.Type.Pharmacy.getValue());
        medicine = new ArrayList();
    }
    
//    public ArrayList<AllRoles> getSupportedRole() {
//        ArrayList<AllRoles> roles = new ArrayList();
//        roles.add(new PharmacistRole());
//        return roles;
//    }

    public List<MedicineDetails> getMedicine() {
        return medicine;
    }

    public void setMedicine(ArrayList<MedicineDetails> medicine) {
        this.medicine = medicine;
    }

    
}
