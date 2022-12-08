/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Enterprises;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import model.Organisation.OrganisationMain;

/**
 *
 * @author sejal
 */

@Entity
public class EnterpriseDetails extends OrganisationMain{
    
    private EnterpriseType enterpriseType;
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<OrganisationMain> organisationDirectory;

    public EnterpriseDetails() {
    }
    
    public EnterpriseDetails(String name, EnterpriseType type) {
        super(name);
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
}
