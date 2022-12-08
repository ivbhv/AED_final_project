/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Configure;

import controller.Helper.Helper;
import controller.Hibernate.HibernateController;

import java.util.*;

import model.AdoptDetails.AddressDetails;
import model.AdoptDetails.AdopterDetails;
import model.Animal.AnimalDetails;
import model.Animal.DogDetails;
import model.Cages.CageDetail;
import model.Employees.EmployeeDetails;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Medicines.*;
import model.Network.NetworkDetails;
import model.Organisation.AdoptionOrganisation;
import model.Organisation.OrganisationMain;
import model.RescueRecord.RescueRecordDetails;
import model.Role.*;
import model.ShelterCell.ShelterCellDetails;
import model.UserAccount.UserAccount;
import model.UserAccount.VisitorAccount;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view.Main.Main;

import javax.print.attribute.standard.MediaSize;

/**
 *
 * @author vaibhav
 */
public class PreConfigure {
    public static void configure() {
        
        // Add a network
        NetworkDetails network = new NetworkDetails().getOrCreateByName("New York");

        // Add Enterprise
        RescueCenterEntDetails enterpriseRescueCenter = new RescueCenterEntDetails("Rescue Center");
        Main.controller.saveObject(enterpriseRescueCenter);
        network.getEnterpriseDirectory().add(enterpriseRescueCenter);
        Main.controller.saveOrUpdate(network);

        // Add organisations
        OrganisationMain vetOrg = enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Vete);
        OrganisationMain adoptOrg = enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Adoption);
        OrganisationMain cageOrg = enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Cage);
        OrganisationMain centerOrg = enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.CenterRegistration);
        OrganisationMain deliveryOrg = enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Delivery);
        OrganisationMain pharmacyOrg = enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Pharmacy);
        OrganisationMain shelterOrg = enterpriseRescueCenter.addOrganisation(OrganisationMain.Type.Shelter);

        Main.controller.saveOrUpdate(enterpriseRescueCenter);


        // Add employees

        //1
        EmployeeDetails systemdManager = new EmployeeDetails("Professor");
        UserAccount systemManager = new UserAccount("sysadmin", "sysadmin", new SystemAdministratorRole(), systemdManager);

        Main.controller.saveOrUpdate(systemdManager);
        Main.controller.saveOrUpdate(systemManager);

        //2
        EmployeeDetails reception = new EmployeeDetails("Vaibhav Mahajan");
        UserAccount receptionManager = new UserAccount("reception", "reception", new ReceptionistRole(), reception);

        Main.controller.saveOrUpdate(reception);
        Main.controller.saveOrUpdate(receptionManager);

        centerOrg.getEmployeeDir().add(reception);
        centerOrg.getUserAccountDir().add(receptionManager);
        Main.controller.saveOrUpdate(centerOrg);

        //3
        EmployeeDetails pharmacist = new EmployeeDetails("Manohar Verma");
        UserAccount pharmaUser = new UserAccount("pharmacist", "pharmacist", new PharmacistRole(), pharmacist);
        Main.controller.saveOrUpdate(pharmacist);
        Main.controller.saveOrUpdate(pharmaUser);

        pharmacyOrg.getUserAccountDir().add(pharmaUser);
        pharmacyOrg.getEmployeeDir().add(pharmacist);
        Main.controller.saveOrUpdate(pharmacyOrg);

        //4
        EmployeeDetails shelter = new EmployeeDetails("Sejal Deopura");
        UserAccount shelterManager = new UserAccount("shelter", "shelter", new ShelterEmpRole(), shelter);
        Main.controller.saveOrUpdate(shelter);
        Main.controller.saveOrUpdate(shelterManager);
        shelterOrg.getUserAccountDir().add(shelterManager);
        shelterOrg.getEmployeeDir().add(shelter);
        Main.controller.saveOrUpdate(shelterOrg);


        //5
        EmployeeDetails adopter = new EmployeeDetails("Mahima Rao");
        UserAccount adopterManager = new UserAccount("adopter", "adopter", new AdoptionManagerRole(), adopter);
        Main.controller.saveOrUpdate(adopter);
        Main.controller.saveOrUpdate(adopterManager);
        adoptOrg.getUserAccountDir().add(adopterManager);
        adoptOrg.getEmployeeDir().add(adopter);
        Main.controller.saveOrUpdate(adoptOrg);

        //6
        EmployeeDetails delivery = new EmployeeDetails("Bhavik Bhosle");
        UserAccount deliveryManager = new UserAccount("delivery", "delivery", new DeliveryPersonRole(), delivery);
        Main.controller.saveOrUpdate(delivery);
        Main.controller.saveOrUpdate(deliveryManager);
        deliveryOrg.getUserAccountDir().add(deliveryManager);
        deliveryOrg.getEmployeeDir().add(delivery);
        Main.controller.saveOrUpdate(deliveryOrg);

        //7
        EmployeeDetails veteAssistant = new EmployeeDetails("Mayuri More");
        UserAccount veteAssistantManager = new UserAccount("vete", "vete", new VetAssistantRole(), veteAssistant);
        Main.controller.saveOrUpdate(veteAssistant);
        Main.controller.saveOrUpdate(veteAssistantManager);
        vetOrg.getUserAccountDir().add(veteAssistantManager);
        vetOrg.getEmployeeDir().add(veteAssistant);
        Main.controller.saveOrUpdate(vetOrg);

        // medicine details
        MedicineDetails m1 = new AnestheticsDetails("avil", "jain", MedicineDetails.MedicineType.Anesthetics);
        MedicineDetails m2 = new AntibioticsDetails("kalpol", "shree", MedicineDetails.MedicineType.Anesthetics);
        MedicineDetails m3 = new OtherMedicineDetails("old monk", "ramu", MedicineDetails.MedicineType.Other);
        MedicineDetails m4 = new VaccinationDetails("covaxin", "bharat biotech", MedicineDetails.MedicineType.Vaccination);

        Main.controller.saveOrUpdateArray(new Object[] {m1, m2, m3, m4});
        enterpriseRescueCenter.getMedicineDirectory().addAll(new ArrayList<>(Arrays.asList(m1, m2, m3, m4)));

        List<String> cities = new Helper().getCities();
        Collections.shuffle(cities);



        for(int i=0; i<10; i++) {
            CageDetail c = new CageDetail().getOrCreateByName(cities.get(i));
            if (c != null) {
                enterpriseRescueCenter.getCageCellDirectory().add(c);
                Main.controller.saveOrUpdate(enterpriseRescueCenter);
            }
        }

        Collections.shuffle(cities);

        for(int i=0; i<50; i++) {
            ShelterCellDetails c = new ShelterCellDetails().getOrCreateByName(cities.get(i));
            if (c != null) {
                enterpriseRescueCenter.getShelterCellDirectory().add(c);
                Main.controller.saveOrUpdate(enterpriseRescueCenter);
            }
        }

        AddressDetails address = new AddressDetails("3 Atherton Street", "Boston", "MA");
        Main.controller.saveOrUpdate(address);

        AdopterDetails adopterDetails = new AdopterDetails("jshef923238r", "mohit", "chauhan", "+91 7024892702", address, "i.vaibhavmahajan@gmail.com");
        Main.controller.saveOrUpdate(adopterDetails);

        VisitorAccount v = new VisitorAccount("visitor", "visitor", "i.vaibhavmahajan@gmail", adopterDetails);
        Main.controller.saveOrUpdate(v);
        ((AdoptionOrganisation)adoptOrg).getAdopterDirectory().add(adopterDetails);
        Main.controller.saveOrUpdate(adoptOrg);

        AnimalDetails animal = new DogDetails();
        animal.setColor("white");
        animal.setGender("male");
        animal.setType(AnimalDetails.AnimalType.Dog);
        animal.setStatus(AnimalDetails.Status.NOT_READY);

        Main.controller.saveOrUpdate(animal);

        RescueRecordDetails rr = new RescueRecordDetails();
        rr.setDate(new Date(10,10,2022));
        rr.setRescuedanimal(animal);
        rr.setFoundlocation("Boston");
        Main.controller.saveOrUpdate(rr);
        enterpriseRescueCenter.getRecordDirectory().add(rr);
        Main.controller.saveOrUpdate(enterpriseRescueCenter);
        
        // Close Sessions
        Main.controller.closeFactory();

        // create Main class instance

        
    }
}
