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
import model.AdoptDetails.AdoptRecord;
import model.AdoptDetails.AdopterDetails;
import model.AdoptDetails.AdoptionOffered;
import model.Role.AdoptionManagerRole;
import model.Role.AllRoles;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author vaibhav
 */

@Entity
public class AdoptionOrganisation extends OrganisationMain{
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="organisation_id")
    private List<AdoptRecord> adoptionRecordDirectory;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="organisation_id")
    private List<AdopterDetails> adopterDirectory;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="organisation_id")
    private List<AdoptionOffered> adoptionlist;
    
    public AdoptionOrganisation() {
        super(OrganisationMain.Type.Adoption.getValue());
        adoptionRecordDirectory = new ArrayList();
        adopterDirectory = new ArrayList();
        adoptionlist = new ArrayList();
    }

    public List<AdoptRecord> getAdoptionRecordDirectory() {
        return adoptionRecordDirectory;
    }

    public void setAdoptionRecordDirectory(ArrayList<AdoptRecord> adoptionRecordDirectory) {
        this.adoptionRecordDirectory = adoptionRecordDirectory;
    }

    public List<AdopterDetails> getAdopterDirectory() {
        return adopterDirectory;
    }

    public void setAdopterDirectory(ArrayList<AdopterDetails> adopterDirectory) {
        this.adopterDirectory = adopterDirectory;
    }

    public List<AdoptionOffered> getAdoptionlist() {
        return adoptionlist;
    }

    public void setAdoptionlist(ArrayList<AdoptionOffered> adoptionlist) {
        this.adoptionlist = adoptionlist;
    }

//    public ArrayList<AllRoles> getSupportedRole() {
//        ArrayList<AllRoles> roles = new ArrayList<>();
//        roles.add(new AdoptionManagerRole());
//        return roles;
//    }
 
}
