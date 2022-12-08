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
import model.AdoptDetails.AdoptionOffered;
import model.Animal.AnimalDetails;
import model.Cages.CageDetail;
import model.Deliver.DeliveryDetails;
import model.Medicines.MedicineDetails;
import model.Place.PlaceDetails;
import model.RescueRecord.RescueRecordDetails;
import model.Role.AllRoles;
import model.ShelterCell.ShelterCellDetails;

/**
 *
 * @author sejal
 */

@Entity
public class RescueCenterEntDetails extends EnterpriseDetails{
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<PlaceDetails> roomDirectory;
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<RescueRecordDetails> recordDirectory;
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<AnimalDetails> animalDirectory;
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<MedicineDetails> medicineDirectory;
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<CageDetail> cageCellDirectory;
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<ShelterCellDetails> shelterCellDirectory;
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<AdoptionOffered> adoptionList;
    
    @OneToMany
    @JoinColumn(name="organisation_id")
    private List<DeliveryDetails> deliveryHistoryDirectory;

    public RescueCenterEntDetails() {
    }
    
    public RescueCenterEntDetails(String name) {
        super(name, EnterpriseDetails.EnterpriseType.RescueCenter);
        roomDirectory = new ArrayList();
        recordDirectory = new ArrayList();
        animalDirectory = new ArrayList();
        medicineDirectory = new ArrayList();
        cageCellDirectory = new ArrayList();
        shelterCellDirectory = new ArrayList();
        adoptionList = new ArrayList();
        deliveryHistoryDirectory = new ArrayList();
    }
    
    public ArrayList<AllRoles> getSupportedRole() {
        return null;
    }
}
