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
import model.Cages.CageDetail;
import model.Role.AllRoles;
import model.Role.VetAssistantRole;

/**
 *
 * @author vaibhav
 */

@Entity
public class CageOrganisation extends OrganisationMain{
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<CageDetail> cageCellDirectory;
    
    public CageOrganisation() {
        super(OrganisationMain.Type.Cage.getValue());
        cageCellDirectory = new ArrayList();
    }

    public List<CageDetail> getCageCellDirectory() {
        return cageCellDirectory;
    }

    public void setCageCellDirectory(ArrayList<CageDetail> cageCellDirectory) {
        this.cageCellDirectory = cageCellDirectory;
    }

//    public ArrayList<AllRoles> getSupportedRole() {
//        ArrayList<AllRoles> roles = new ArrayList<>();
//        roles.add(new VetAssistantRole());
//        return roles;
//    }

}
