/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Enterprises;

import controller.Hibernate.HibernateController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Organisation.AdoptionOrganisation;
import model.Organisation.CageOrganisation;
import model.Organisation.CenterRegistrationOrganisation;
import model.Organisation.DeliveryOrganisation;
import model.Organisation.OrganisationMain;
import model.Organisation.PharmacyOrganisation;
import model.Organisation.ShelterOrganisation;
import model.Organisation.VeterinarianOrganisation;
import model.UserAccount.UserAccount;
import org.hibernate.Session;
import view.Main.Main;

/**
 *
 * @author sejal
 */

@Entity
public class EnterpriseDetails extends OrganisationMain{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="enterprise_id")
    private int id;
    
    private EnterpriseType enterpriseType;
    
    @OneToMany
    @JoinColumn(name="enterprise_id")
    private List<OrganisationMain> organisationDirectory;

    public EnterpriseDetails() {
    }
    
    public EnterpriseDetails(String name, EnterpriseType type) {
//        super(name);
        this.enterpriseType = type;
        organisationDirectory = new ArrayList<>();
    }   

    public List<OrganisationMain> getOrganisationDirectory() {
        return organisationDirectory;
    }

    public void setOrganisationDirectory(ArrayList<OrganisationMain> organisationDirectory) {
        this.organisationDirectory = organisationDirectory;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }
    
    public OrganisationMain addOrganisation(OrganisationMain.Type type) {
        OrganisationMain organization = null;
        if (type.getValue().equals(OrganisationMain.Type.CenterRegistration.getValue())){
            organization = new CenterRegistrationOrganisation();
        }
        else if (type.getValue().equals(OrganisationMain.Type.Vete.getValue())){
            organization = new VeterinarianOrganisation();
        }
        else if (type.getValue().equals(OrganisationMain.Type.Pharmacy.getValue())){
            organization = new PharmacyOrganisation();
        }
        else if (type.getValue().equals(OrganisationMain.Type.Cage.getValue())){
            organization = new CageOrganisation();
        }
        else if (type.getValue().equals(OrganisationMain.Type.Delivery.getValue())){
            organization = new DeliveryOrganisation();
        }
        else if (type.getValue().equals(OrganisationMain.Type.Shelter.getValue())){
            organization = new ShelterOrganisation();
        }
        else if (type.getValue().equals(OrganisationMain.Type.Adoption.getValue())){
            organization = new AdoptionOrganisation();
        }
        Main.controller.saveObject(organization);
        this.organisationDirectory.add(organization);
        
        return organization;
    }
    
    public enum EnterpriseType {
        RescueCenter("Rescue");
            
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value;
        }
        
    }
    
    public UserAccount authenticateUser(String username, String password) {

        for (UserAccount ua : getUserAccountDir())
            if (ua.getUsername().equals(username) && ua.getPass().equals(password)){
                return ua;
            }
        return null;

    }
}
