/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorkQueue;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author sejal
 */

@Entity
public class PharmacyWre extends AllWorkRequest {
    
    private boolean assigned;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "work_request_id")
    private List<PharmacyUnitWre> medicineList;

    public PharmacyWre() {
    }

    public PharmacyWre(boolean assigned) {
        this.assigned = assigned;
        this.medicineList = new ArrayList();
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public List<PharmacyUnitWre> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(ArrayList<PharmacyUnitWre> medicineList) {
        this.medicineList = medicineList;
    }
    
    

}
