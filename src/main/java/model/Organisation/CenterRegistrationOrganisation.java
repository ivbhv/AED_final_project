/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Organisation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import model.RescueRecord.RescueRecordDetails;
import model.Role.AllRoles;
import model.Role.ReceptionistRole;

/**
 *
 * @author vaibhav
 */
public class CenterRegistrationOrganisation extends OrganisationMain {
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<RescueRecordDetails> rescueRecordDirectory;
    
    public CenterRegistrationOrganisation() {
        super(OrganisationMain.Type.CenterRegistration.getValue());
        rescueRecordDirectory = new ArrayList();
    }

    public List<RescueRecordDetails> getRescueRecordDirectory() {
        return rescueRecordDirectory;
    }

    public void setRescueRecordDirectory(ArrayList<RescueRecordDetails> rescueRecordDirectory) {
        this.rescueRecordDirectory = rescueRecordDirectory;
    }
    
//    public ArrayList<AllRoles> getSupportedRole() {
//        ArrayList<AllRoles> roles = new ArrayList<>();
//        roles.add(new ReceptionistRole());
//        return roles;
//    }

}
