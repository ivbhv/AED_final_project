/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Network;

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
import model.Enterprises.EnterpriseDetails;

/**
 *
 * @author sejal
 */

@Entity
public class NetworkDetails implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="network_id")
    private int id;
    
    private String name;
    
    @OneToMany
    @JoinColumn(name="network_id")
    private List<EnterpriseDetails> enterpriseDirectory;

    public NetworkDetails() {
    }

    public NetworkDetails(String name) {
        this.name = name;
        enterpriseDirectory = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EnterpriseDetails> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(ArrayList<EnterpriseDetails> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
