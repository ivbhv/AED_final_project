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
import model.Organisation.PharmacyOrganisation;
import model.UserAccount.UserAccount;
import view.PharmcistRole.PharmacistWorkAreaJPanel;

/**
 *
 * @author manohar
 */

@Entity
public class PharmacistRole extends AllRoles
{
    @Override
    
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise,
            OrganisationMain organization,
            UserAccount userAccount)
    {
        return new PharmacistWorkAreaJPanel(container, enterprise, (PharmacyOrganisation)organization, userAccount);
    }
    
    @Override
    public String toString() {
        return "Pharmacist"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
