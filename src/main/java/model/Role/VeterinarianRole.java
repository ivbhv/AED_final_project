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
import model.Organisation.OrganisationMain;
import model.Organisation.VeterinarianOrganisation;
import model.UserAccount.UserAccount;
import view.VetRole.VeterinarianWorkAreaJPanel;

/**
 *
 * @author manohar
 */

@Entity
public class VeterinarianRole extends AllRoles 
{
    @Override
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise,
            OrganisationMain organization,
            UserAccount userAccount)
    {
        return new VeterinarianWorkAreaJPanel(container, (RescueCenterEntDetails)enterprise, (VeterinarianOrganisation)organization, userAccount);
    }

    @Override
    public String toString() {
        return "Veterinarian"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
