    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
package model.Role;
import javax.persistence.Entity;
import javax.swing.JPanel;

import model.Enterprises.EnterpriseDetails;
import model.Organisation.CageOrganisation;
import model.Organisation.OrganisationMain;
import model.Organisation.VeterinarianOrganisation;
import model.UserAccount.UserAccount;
import view.VetAssistRole.VeteAssistantWorkAreaJPanel;

    /**
 *
 * @author manohar
 */

@Entity
public class VetAssistantRole extends AllRoles 
{
    @Override
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise,
            OrganisationMain organization,
            UserAccount userAccount) {
        return new VeteAssistantWorkAreaJPanel(container, enterprise, (CageOrganisation)organization, userAccount);
    }
    
    @Override
    public String toString() {
        return "Vet Assistant"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
