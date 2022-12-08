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
        roomDirectory = new ArrayList<>();
        recordDirectory = new ArrayList<>();
        animalDirectory = new ArrayList<>();
        medicineDirectory = new ArrayList<>();
        cageCellDirectory = new ArrayList<>();
        shelterCellDirectory = new ArrayList<>();
        adoptionList = new ArrayList<>();
        deliveryHistoryDirectory = new ArrayList<>();
    }

    public List<PlaceDetails> getRoomDirectory() {
        return roomDirectory;
    }

    public void setRoomDirectory(List<PlaceDetails> roomDirectory) {
        this.roomDirectory = roomDirectory;
    }

    public List<RescueRecordDetails> getRecordDirectory() {
        return recordDirectory;
    }

    public void setRecordDirectory(List<RescueRecordDetails> recordDirectory) {
        this.recordDirectory = recordDirectory;
    }

    public List<AnimalDetails> getAnimalDirectory() {
        return animalDirectory;
    }

    public void setAnimalDirectory(List<AnimalDetails> animalDirectory) {
        this.animalDirectory = animalDirectory;
    }

    public List<MedicineDetails> getMedicineDirectory() {
        return medicineDirectory;
    }

    public void setMedicineDirectory(List<MedicineDetails> medicineDirectory) {
        this.medicineDirectory = medicineDirectory;
    }

    public List<CageDetail> getCageCellDirectory() {
        return cageCellDirectory;
    }

    public void setCageCellDirectory(List<CageDetail> cageCellDirectory) {
        this.cageCellDirectory = cageCellDirectory;
    }

    public List<ShelterCellDetails> getShelterCellDirectory() {
        return shelterCellDirectory;
    }

    public void setShelterCellDirectory(List<ShelterCellDetails> shelterCellDirectory) {
        this.shelterCellDirectory = shelterCellDirectory;
    }

    public List<AdoptionOffered> getAdoptionList() {
        return adoptionList;
    }

    public void setAdoptionList(List<AdoptionOffered> adoptionList) {
        this.adoptionList = adoptionList;
    }

    public List<DeliveryDetails> getDeliveryHistoryDirectory() {
        return deliveryHistoryDirectory;
    }

    public void setDeliveryHistoryDirectory(List<DeliveryDetails> deliveryHistoryDirectory) {
        this.deliveryHistoryDirectory = deliveryHistoryDirectory;
    }
}
