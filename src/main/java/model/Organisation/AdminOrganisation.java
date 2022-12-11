/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Organisation;
import java.util.ArrayList;
import javax.persistence.Entity;
import model.Role.AllRoles;
import model.Role.EnterpriseAdministratorRole;

/**
 *
 * @author vaibhav
 */

@Entity
public class AdminOrganisation extends OrganisationMain{
    public AdminOrganisation() {
        super(OrganisationMain.Type.EnterpriseAdmin.getValue());
    }
    
    @Override
    public ArrayList<AllRoles> getSupportedRole() {
        ArrayList<AllRoles> roles = new ArrayList();
        roles.add(new EnterpriseAdministratorRole());
        return roles;
    }

}
