    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorkQueue;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.UserAccount.UserAccount;

/**
 *
 * @author sejal
 */

@Entity
public class AllWorkRequest implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="work_request_id")
    private int id;
    
    @ManyToOne
    private UserAccount wresender;
    
    @ManyToOne
    private UserAccount wrereceiver;
    
    private String wremessage;
    private String wrestatus;
    
    @Temporal(TemporalType.DATE)
    private Date wrerequestDate;
    
    @Temporal(TemporalType.DATE)
    private Date wreresolveDate;

    public AllWorkRequest() {
    }

    public AllWorkRequest(UserAccount wresender, UserAccount wrereceiver, String wremessage, String wrestatus, Date wreresolveDate) {
        this.wresender = wresender;
        this.wrereceiver = wrereceiver;
        this.wremessage = wremessage;
        this.wrestatus = wrestatus;
        this.wrerequestDate = new Date();
        this.wreresolveDate = wreresolveDate;
    }

    public UserAccount getWresender() {
        return wresender;
    }

    public void setWresender(UserAccount wresender) {
        this.wresender = wresender;
    }

    public UserAccount getWrereceiver() {
        return wrereceiver;
    }

    public void setWrereceiver(UserAccount wrereceiver) {
        this.wrereceiver = wrereceiver;
    }

    public String getWremessage() {
        return wremessage;
    }

    public void setWremessage(String wremessage) {
        this.wremessage = wremessage;
    }

    public String getWrestatus() {
        return wrestatus;
    }

    public void setWrestatus(String wrestatus) {
        this.wrestatus = wrestatus;
    }

    public Date getWrerequestDate() {
        return wrerequestDate;
    }

    public void setWrerequestDate(Date wrerequestDate) {
        this.wrerequestDate = wrerequestDate;
    }

    public Date getWreresolveDate() {
        return wreresolveDate;
    }

    public void setWreresolveDate(Date wreresolveDate) {
        this.wreresolveDate = wreresolveDate;
    }
    
    
}
