/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Role;
import javax.persistence.Entity;
import javax.swing.JPanel;

import model.Enterprises.EnterpriseDetails;
import model.Organisation.OrganisationMain;
import model.Organisation.ShelterOrganisation;
import model.UserAccount.UserAccount;
import view.ShelterRole.ShelterStaffWorkAreaJPanel;

/**
 *
 * @author manohar
 */

@Entity
public class ShelterEmpRole extends AllRoles
{
    @Override
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise,
            OrganisationMain organization,
            UserAccount userAccount)
    {
        return new ShelterStaffWorkAreaJPanel(container,  enterprise,  (ShelterOrganisation)organization,  userAccount);
    }
    
    @Override
    public String toString() {
        return "shelter Employee"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
