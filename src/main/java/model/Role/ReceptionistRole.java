/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Role;
import javax.persistence.Entity;
import javax.swing.JPanel;

import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Organisation.CenterRegistrationOrganisation;
import model.Organisation.OrganisationMain;
import model.UserAccount.UserAccount;
import view.ReceptionistRole.ReceptionistWorkAreaJPanel;

/**
 *
 * @author manohar
 */

@Entity
public class ReceptionistRole extends AllRoles
{
     @Override
     
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise,
            OrganisationMain organization,
            UserAccount userAccount) 
    {
        return new ReceptionistWorkAreaJPanel(container, (RescueCenterEntDetails)enterprise, (CenterRegistrationOrganisation)organization, userAccount);
    }
    
    @Override
    public String toString() {
        return "Receptionist"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
