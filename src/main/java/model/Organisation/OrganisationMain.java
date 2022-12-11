/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Organisation;
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
import model.Employees.EmployeeDetails;
import model.Role.AllRoles;
import model.UserAccount.UserAccount;
import model.WorkQueue.AllWorkRequest;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author vaibhav
 */

@Entity
public abstract class OrganisationMain implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="organisation_id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    private String orgname;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="organisation_id")
    private List<AllWorkRequest> workQueue;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="organisation_id")
    private List<EmployeeDetails> employeeDir;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="organisation_id")
    private List<UserAccount> userAccountDir;

    public OrganisationMain() {
    }
    
    public OrganisationMain(String name) {
        this.orgname = name;
        workQueue = new ArrayList();
        employeeDir = new ArrayList();
        userAccountDir = new ArrayList();
    }
    
    public enum Type{
        EnterpriseAdmin("Enterprise Admin Organization"),
        CenterRegistration("Registration"),
        Vete("Veterinarian Organization"),
        Pharmacy("Pharmacy Organization"),
        Cage("Cage Organization"),
        Delivery("Delivery Organization"),
        Shelter("Shelter Organization"),
        Adoption("Adoption Inspection Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public List<AllWorkRequest> getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(ArrayList<AllWorkRequest> workQueue) {
        this.workQueue = workQueue;
    }

    public List<EmployeeDetails> getEmployeeDir() {
        return employeeDir;
    }

    public void setEmployeeDir(ArrayList<EmployeeDetails> employeeDir) {
        this.employeeDir = employeeDir;
    }

    public List<UserAccount> getUserAccountDir() {
        return userAccountDir;
    }

    public void setUserAccountDir(ArrayList<UserAccount> userAccountDir) {
        this.userAccountDir = userAccountDir;
    }
    
    public UserAccount authenticateUser(String username, String password) {

        for (UserAccount ua : getUserAccountDir())
            if (ua.getUsername().equals(username) && ua.getPass().equals(password)){
                return ua;
            }
        return null;

    }
    public abstract ArrayList<AllRoles> getSupportedRole();

    @Override
    public String toString() {
        return orgname;
    }
}
