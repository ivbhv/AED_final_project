/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Role;

import javax.swing.JPanel;
import model.Enterprises.EnterpriseDetails;
import model.Organisation.AdoptionOrganisation;
import model.Organisation.OrganisationMain;
import model.UserAccount.UserAccount;

/**
 *
 * @author manohar
 */
public class AdoptionManagerRole extends AllRoles
{
    @Override
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise, 
            OrganisationMain organization, 
            UserAccount userAccount) 
    {
        
        return new AdoptInspectorWorkpage(container, enterprise, (AdoptionOrganisation)organization, userAccount);
        
    }
}
