/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.AdoptDetails;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import model.Animal.AnimalDetails;
import model.Employees.EmployeeDetails;

/**
 *
 * @author vaibhav
 */

@Entity
public class AdoptRecord implements Serializable {
    
    public enum Status {
        Submitted, Processing, Approved, Rejected, In_Progress
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="record_id")
    private int id;
    
    @OneToOne
    private AdopterDetails adoptor;
    
    @OneToOne
    private EmployeeDetails employee;
    
    @OneToOne
    private AnimalDetails animal;
    
    private Date date;
    
    private Status status;

    public AdoptRecord() {
    }

    public AdoptRecord(AdopterDetails adoptor, EmployeeDetails employee, AnimalDetails animal, Date date, Status status) {
        this.adoptor = adoptor;
        this.employee = employee;
        this.animal = animal;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdopterDetails getAdoptor() {
        return adoptor;
    }

    public void setAdoptor(AdopterDetails adoptor) {
        this.adoptor = adoptor;
    }

    public EmployeeDetails getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDetails employee) {
        this.employee = employee;
    }

    public AnimalDetails getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDetails animal) {
        this.animal = animal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    
}
