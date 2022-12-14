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
import model.Role.ShelterEmpRole;
import model.ShelterCell.ShelterCellDetails;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author vaibhav
 */
@Entity
public class ShelterOrganisation extends OrganisationMain{
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="organisation_id")
    private List<ShelterCellDetails> shelterCellDirectory;
    
    public ShelterOrganisation() {
        super(OrganisationMain.Type.Shelter.getValue());
        shelterCellDirectory = new ArrayList();
    }

    public List<ShelterCellDetails> getShelterCellDirectory() {
        return shelterCellDirectory;
    }

    public void setShelterCellDirectory(ArrayList<ShelterCellDetails> shelterCellDirectory) {
        this.shelterCellDirectory = shelterCellDirectory;
    }
    
    @Override
    public AllRoles getSupportedRole() {
        
        return new ShelterEmpRole();
    }
}
