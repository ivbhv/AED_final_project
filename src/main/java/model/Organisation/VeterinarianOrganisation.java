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
import model.Role.AllRoles;
import model.Role.VeterinarianRole;
import model.Treatment.TreatmentRecord;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author vaibhav
 */

@Entity
public class VeterinarianOrganisation extends OrganisationMain{
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="organisation_id")
    private List<TreatmentRecord> treatmentRecordDir;
    
    public VeterinarianOrganisation() {
        super(OrganisationMain.Type.Vete.getValue());
        treatmentRecordDir = new ArrayList();
    }

    public List<TreatmentRecord> getTreatmentRecordDir() {
        return treatmentRecordDir;
    }

    public void setTreatmentRecordDir(ArrayList<TreatmentRecord> treatmentRecordDir) {
        this.treatmentRecordDir = treatmentRecordDir;
    }
    
    @Override
    public AllRoles getSupportedRole() {
        
        return new VeterinarianRole();
    }

}
