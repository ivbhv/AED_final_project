/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.UserAccount;

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
import javax.persistence.OneToOne;
import model.Employees.EmployeeDetails;
import model.Role.AllRoles;
import model.WorkQueue.AllWorkRequest;

/**
 *
 * @author sejal
 */

@Entity
public class UserAccount implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id")
    private int id;
    
    @Column(unique = true)  
    private String username;
    
    private String pass;
    
    @OneToOne
    private AllRoles roles;
    
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<AllWorkRequest> workQueue;
    
    @OneToOne
    private EmployeeDetails employee;

    public UserAccount() {
    }

    public UserAccount(String username, String pass, AllRoles role, EmployeeDetails employee) {
        this.username = username;
        this.pass = pass;
        this.roles = role;
        this.workQueue = new ArrayList<>();
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public AllRoles getRole() {
        return roles;
    }

    public void setRole(AllRoles role) {
        this.roles = role;
    }

    public List<AllWorkRequest> getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(List<AllWorkRequest> workQueue) {
        this.workQueue = workQueue;
    }

    public EmployeeDetails getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDetails employee) {
        this.employee = employee;
    }
    
}
