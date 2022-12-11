 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Configure;

import controller.Helper.Helper;

import java.util.*;

import model.AdoptDetails.AddressDetails;
import model.AdoptDetails.AdopterDetails;
import model.Animal.AnimalDetails;
import model.Animal.DogDetails;
import model.Cages.CageDetail;
import model.Employees.EmployeeDetails;
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
import view.Main.Main;


/**
 *
 * @author vaibhav
 */
public class PreConfigure {
    public static void configure() {
        
        // Add a network
        NetworkDetails network = new NetworkDetails().getOrCreateByName("New York");

        // Add Enterprise
        RescueCenterEntDetails enterpriseRescueCenter = new RescueCenterEntDetails().addOrGetByName("Rescue Center");
        Main.controller.saveOrUpdate(enterpriseRescueCenter);
        network.addOrUpdateEnterprise(enterpriseRescueCenter);
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
        EmployeeDetails systemdManager = new EmployeeDetails().getOrCreateByEmail("Professor", "professor@gmail.com");
        Main.controller.saveOrUpdate(systemdManager);
        AllRoles sar = new SystemAdministratorRole();
        Main.controller.saveOrUpdate(sar);

        UserAccount systemManager = new UserAccount().getOrCreate("sysadmin", "sysadmin", sar, systemdManager);
        Main.controller.saveOrUpdate(systemManager);
        
        //2
        EmployeeDetails reception = new EmployeeDetails().getOrCreateByEmail("Vaibhav Mahajan", "vaibhav@gmail.com");
        Main.controller.saveOrUpdate(reception);
        AllRoles rr = new ReceptionistRole();
        Main.controller.saveOrUpdate(rr);

        UserAccount receptionManager = new UserAccount().getOrCreate("reception", "reception", rr, reception);
        Main.controller.saveOrUpdate(receptionManager);
        centerOrg.getEmployeeDir().add(reception);
        centerOrg.getUserAccountDir().add(receptionManager);
        Main.controller.saveOrUpdate(centerOrg);

        //3
        EmployeeDetails pharmacist = new EmployeeDetails().getOrCreateByEmail("Manohar Verma", "manohar@gmail.com");
        Main.controller.saveOrUpdate(pharmacist);
        AllRoles pr = new PharmacistRole();
        Main.controller.saveOrUpdate(pr);

        UserAccount pharmaUser = new UserAccount().getOrCreate("pharmacist", "pharmacist", pr, pharmacist);
        Main.controller.saveOrUpdate(pharmaUser);
        pharmacyOrg.getUserAccountDir().add(pharmaUser);
        pharmacyOrg.getEmployeeDir().add(pharmacist);
        Main.controller.saveOrUpdate(pharmacyOrg);

        //4
        EmployeeDetails shelter = new EmployeeDetails().getOrCreateByEmail("Sejal Deopura", "sejal@gmail.com");
        Main.controller.saveOrUpdate(shelter);
        AllRoles sr = new ShelterEmpRole();
        Main.controller.saveOrUpdate(sr);

        UserAccount shelterManager = new UserAccount().getOrCreate("shelter", "shelter", sr, shelter);
        Main.controller.saveOrUpdate(shelterManager);
        shelterOrg.getUserAccountDir().add(shelterManager);
        shelterOrg.getEmployeeDir().add(shelter);
        Main.controller.saveOrUpdate(shelterOrg);

        //5
        EmployeeDetails adopter = new EmployeeDetails().getOrCreateByEmail("Mahima Rao", "mahima@gmail.com");
        Main.controller.saveOrUpdate(adopter);
        AllRoles ar = new AdoptionManagerRole();
        Main.controller.saveOrUpdate(ar);

        UserAccount adopterManager = new UserAccount().getOrCreate("adopter", "adopter", ar, adopter);
        Main.controller.saveOrUpdate(adopterManager);
        adoptOrg.getUserAccountDir().add(adopterManager);
        adoptOrg.getEmployeeDir().add(adopter);
        Main.controller.saveOrUpdate(adoptOrg);

        //6
        EmployeeDetails delivery = new EmployeeDetails().getOrCreateByEmail("Bhavik Bhosle", "bhavik@gmail.com");
        Main.controller.saveOrUpdate(delivery);
        AllRoles dpr = new DeliveryPersonRole();
        Main.controller.saveOrUpdate(dpr);

        UserAccount deliveryManager = new UserAccount().getOrCreate("delivery", "delivery", dpr, delivery);
        Main.controller.saveOrUpdate(deliveryManager);
        deliveryOrg.getUserAccountDir().add(deliveryManager);
        deliveryOrg.getEmployeeDir().add(delivery);
        Main.controller.saveOrUpdate(deliveryOrg);

        //7
        EmployeeDetails veteAssistant = new EmployeeDetails().getOrCreateByEmail("Mayuri More", "mayuri@gmail.com");
        Main.controller.saveOrUpdate(veteAssistant);
        AllRoles vr = new VetAssistantRole();
        Main.controller.saveOrUpdate(vr);
        UserAccount veteAssistantManager = new UserAccount().getOrCreate("vete", "vete", vr, veteAssistant);

        Main.controller.saveOrUpdate(veteAssistantManager);
        cageOrg.getUserAccountDir().add(veteAssistantManager);
        cageOrg.getEmployeeDir().add(veteAssistant);
        Main.controller.saveOrUpdate(cageOrg);
        
        //8
        EmployeeDetails enterpriseAdmin = new EmployeeDetails().getOrCreateByEmail("payal neema", "payal@gmail.com");
        Main.controller.saveOrUpdate(enterpriseAdmin);
        AllRoles mr = new EnterpriseAdministratorRole();
        Main.controller.saveOrUpdate(mr);
        UserAccount enterpriseAdminManager = new UserAccount().getOrCreate("ea", "ea", mr, enterpriseAdmin);
        Main.controller.saveOrUpdate(enterpriseAdminManager);
        cageOrg.getUserAccountDir().add(enterpriseAdminManager);
        cageOrg.getEmployeeDir().add(enterpriseAdmin);
        Main.controller.saveOrUpdate(cageOrg);

        //9
        EmployeeDetails vete = new EmployeeDetails().getOrCreateByEmail("payal More", "payal.m@gmail.com");
        Main.controller.saveOrUpdate(vete);
        AllRoles ve = new VeterinarianRole();
        Main.controller.saveOrUpdate(ve);
        UserAccount veteManager = new UserAccount().getOrCreate("vet", "vete", ve, vete);

        Main.controller.saveOrUpdate(veteManager);
        vetOrg.getUserAccountDir().add(veteManager);
        vetOrg.getEmployeeDir().add(vete);
        Main.controller.saveOrUpdate(vetOrg);


        // medicine details
        MedicineDetails m1 = new AnestheticsDetails().getOrCreateMedicine("avil", "jain", MedicineDetails.MedicineType.Anesthetics);
        MedicineDetails m2 = new AntibioticsDetails().getOrCreateMedicine("kalpol", "shree", MedicineDetails.MedicineType.Antibiotics);
        MedicineDetails m3 = new OtherMedicineDetails().getOrCreateMedicine("old monk", "ramu", MedicineDetails.MedicineType.Other);
        MedicineDetails m4 = new VaccinationDetails().getOrCreateMedicine("covaxin", "bharat biotech", MedicineDetails.MedicineType.Vaccination);

        enterpriseRescueCenter.addOrUpdateMedicineList(new ArrayList<>(Arrays.asList(m1, m2, m3, m4)));

        List<String> cities = new Helper().getCities();
        Collections.shuffle(cities);



        for(int i=0; i<10; i++) {
            CageDetail c = new CageDetail().getByName(cities.get(i));
            if (c != null) {
                enterpriseRescueCenter.getCageCellDirectory().add(c);
                Main.controller.saveOrUpdate(enterpriseRescueCenter);
            }
        }

        Collections.shuffle(cities);

        for(int i=0; i<50; i++) {
            ShelterCellDetails c = new ShelterCellDetails().getByLocation(cities.get(i));
            if (c != null) {
                enterpriseRescueCenter.getShelterCellDirectory().add(c);
                Main.controller.saveOrUpdate(enterpriseRescueCenter);
            }
        }

        AddressDetails address = new AddressDetails("3 Atherton Street", "Boston", "MA");
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

        Main.controller.saveObject(animal);

        RescueRecordDetails rrd = new RescueRecordDetails();
        rrd.setDate(new Date());
        rrd.setRescuedanimal(animal);
        rrd.setFoundlocation("Boston");
        Main.controller.saveOrUpdate(rrd);
        enterpriseRescueCenter.getRecordDirectory().add(rrd);
        Main.controller.saveOrUpdate(enterpriseRescueCenter);
        
        // Close Sessions
        Main.controller.closeFactory();

        // create Main class instance

        
    }
}
