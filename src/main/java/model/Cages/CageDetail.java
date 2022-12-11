/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Cages;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Animal.AnimalDetails;
import org.hibernate.Session;
import view.Main.Main;

/**
 *
 * @author sejal
 */

@Entity
public class CageDetail implements Serializable {

    public enum Status {
        OCCUPIED, AVAILABLE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cage_number")
    private int cellno;

    private String cagelocation;
    private Status cagestatus;

    @OneToOne
    private AnimalDetails animal;

    public CageDetail() {
    }

    public CageDetail(String cagelocation, AnimalDetails animal) {
        this.cagelocation = cagelocation;
        this.cagestatus = Status.AVAILABLE;
        this.animal = animal;
    }

    public int getCellno() {
        return cellno;
    }

    public void setCellno(int cellno) {
        this.cellno = cellno;
    }

    public String getCagelocation() {
        return cagelocation;
    }

    public void setCagelocation(String cagelocation) {
        this.cagelocation = cagelocation;
    }

    public Status getCagestatus() {
        return cagestatus;
    }

    public void setCagestatus(Status cagestatus) {
        this.cagestatus = cagestatus;
    }

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }

    public CageDetail getByName(String name) {
        
        List<CageDetail> result;
        try (Session s = Main.controller.getSession()) {
            CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
            CriteriaQuery<CageDetail> criteriaQuery = criteriaBuilder.createQuery(CageDetail.class);
            Root<CageDetail> root = criteriaQuery.from(CageDetail.class);
            criteriaQuery.where(criteriaBuilder.equal(root.get("cagelocation"), name));
            result = s.createQuery(criteriaQuery).getResultList();
            Main.controller.closeSession(s);
        }

        if(result.size() < 100){
            CageDetail cageDetail = new CageDetail();
            cageDetail.setCagelocation(name);
            cageDetail.setCagestatus(Status.AVAILABLE);
            Main.controller.saveObject(cageDetail);

            return cageDetail;
        }

        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(cellno);
    }
}

