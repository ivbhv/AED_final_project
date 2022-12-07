/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Role;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.swing.JPanel;

/**
 *
 * @author Sejal
 */

@Embeddable
public abstract class AllRoles implements Serializable {

   
    public enum RoleType{
        SystemAdmin("System Admin"),
        EnterpriseAdmin("Enterprise Admin"),
        CenterReceptionist("Receptionist"),
        Vete("Veterinarian"),
        VeteAssistant("Veterinarian Assistant"),
        Pharmacist("Pharmacist"),
        Delivery("Delivery"),
        ShelterReceptionist("Shelter Receptionist"),
        ShelterStaff("Shelter Staff"),
        AdoptionInspector("Adoption Inspector"),
        Rescuer("Rescuer"),
        StaticsAdmin("Statics Admin");
        
        private String value;
        private RoleType(String value)
        {
            this.value = value;
        }

        public String getValue() 
        {
            return value;
        }

        @Override
        public String toString() 
        {
            return value;
        }
    }
    
   public abstract JPanel createWorkArea(JPanel container, 
            EnterpriseDetails enterprise, 
            OrganisationMain organization, 
            UserAccountDetails account, 
            EcoSystem business);
   

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
