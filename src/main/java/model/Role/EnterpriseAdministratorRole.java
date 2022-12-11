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
import model.UserAccount.UserAccount;
import view.EntAdminRole.AdminWorkAreaJPanel;

/**
 *
 * @author manohar
 */

@Entity
public class EnterpriseAdministratorRole extends AllRoles
{
    @Override
    
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise,
            OrganisationMain organization,
            UserAccount userAccount)
    {
        return new AdminWorkAreaJPanel(container, enterprise);
    }

    @Override
    public String toString() {
        return "Enterprise Admin"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
