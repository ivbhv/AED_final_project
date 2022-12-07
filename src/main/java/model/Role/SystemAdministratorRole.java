/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Role;
import javax.swing.JPanel;
import model.UserAccount.UserAccount;

/**
 *
 * @author manohar
 */
public class SystemAdministratorRole extends AllRoles 
{
    @Override
    
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise, 
            OrganisationMain organization, 
            UserAccount userAccount, 
            EcoSystem business) {
        return new SystemAdminWorkAreaJPanel(container, business);
    }
}
