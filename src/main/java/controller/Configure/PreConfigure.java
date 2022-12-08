/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Configure;

import controller.Hibernate.HibernateController;
import java.util.List;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Network.NetworkDetails;
import model.Organisation.OrganisationMain;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view.Main.Main;

/**
 *
 * @author vaibhav
 */
public class PreConfigure {
    public static void configure() {
        
        // Add a network
        NetworkDetails network = new NetworkDetails("Boston");
        Main.controller.saveOrUpdate(network); 
        
        // Add Enterprise
        EnterpriseDetails enterpriseRescueCenter = new RescueCenterEntDetails("Rescue Center");
        Main.controller.saveOrUpdate(enterpriseRescueCenter);
        network.getEnterpriseDirectory().add(enterpriseRescueCenter);
        Main.controller.saveOrUpdate(network);
        
        // Add organisations    
        enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Vete);
        enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Adoption);
        enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Cage);
        enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.CenterRegistration);
        enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Delivery);
        enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.EnterpriseAdmin);
        enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Pharmacy);
        enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Shelter);
        
        Main.controller.saveObject(enterpriseRescueCenter);
        
        
        // Close Sessions
        Main.controller.closeFactory();
        
    }
}
