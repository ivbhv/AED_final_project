/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Organisation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import model.Deliver.VehicleDetails;
import model.Role.AllRoles;
import model.Role.DeliveryPersonRole;

/**
 *
 * @author vaibhav
 */

@Entity
public class DeliveryOrganisation extends OrganisationMain{
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<VehicleDetails> vehicleDirectory;
    
    public DeliveryOrganisation() {
        super(OrganisationMain.Type.Delivery.getValue());
        vehicleDirectory = new ArrayList();
    }

    public List<VehicleDetails> getVehicleDirectory() {
        return vehicleDirectory;
    }

    public void setVehicleDirectory(ArrayList<VehicleDetails> vehicleDirectory) {
        this.vehicleDirectory = vehicleDirectory;
    }
    
    public ArrayList<AllRoles> getSupportedRole() {
        ArrayList<AllRoles> roles = new ArrayList<>();
        roles.add(new DeliveryPersonRole());
        return roles;
    }

}
