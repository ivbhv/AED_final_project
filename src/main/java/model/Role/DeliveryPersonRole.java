/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Role;

import javax.persistence.Entity;
import javax.swing.JPanel;

import model.Enterprises.EnterpriseDetails;
import model.Organisation.DeliveryOrganisation;
import model.Organisation.OrganisationMain;
import model.UserAccount.UserAccount;
import view.DeliverRole.DeliveryWorkspace;

/**
 *
 * @author manohar
 */

@Entity
public class DeliveryPersonRole  extends AllRoles
{
    @Override
    
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise,
            OrganisationMain organization,
            UserAccount userAccount)
    {
        return new DeliveryWorkspace(container, enterprise, (DeliveryOrganisation)organization, userAccount);
    }
}
