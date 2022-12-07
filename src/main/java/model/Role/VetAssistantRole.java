    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
package model.Role;
import javax.swing.JPanel;

    /**
 *
 * @author manohar
 */
public class VetAssistantRole extends AllRoles 
{
    public JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise, 
            OrganisationMain organization, 
            UserAccountDetails userAccount, 
            EcoSystem business) {
        return new VeteAssistantWorkAreaJPanel(container, enterprise, (CageOrganisation)organization, userAccount);
    }
}
