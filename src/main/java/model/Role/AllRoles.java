/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Role;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JPanel;
import model.Enterprises.EnterpriseDetails;
import model.Organisation.OrganisationMain;
import model.UserAccount.UserAccount;

/**
 *
 * @author Sejal
 */

@Entity
public abstract class AllRoles implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="role_id")
    private int id;
    
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
            UserAccount account);
    

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
