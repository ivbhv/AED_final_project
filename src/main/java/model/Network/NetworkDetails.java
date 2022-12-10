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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import model.Enterprises.EnterpriseDetails;
import org.hibernate.Session;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import view.Main.Main;

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
    
    @Column(unique = true)
    private String name;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="network_id")
    private List<EnterpriseDetails> enterpriseDirectory;

    public NetworkDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setEnterpriseDirectory(List<EnterpriseDetails> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public NetworkDetails getOrCreateByName(String name) {
        NetworkDetails n;
        try (Session s = Main.controller.getSession()) {
            n = (NetworkDetails) s.createQuery("from NetworkDetails n where n.name = :name ").setParameter("name", name).uniqueResult();
        }
        if (n != null) {
            return n;

        } else {
            n = new NetworkDetails(name);
        }
        Main.controller.saveObject(n);
        
        return n;
    }

    public List<NetworkDetails> getNetworkList() {
        List<NetworkDetails> networkList;
        try (Session s = Main.controller.getSession()) {
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<NetworkDetails> criteria = builder.createQuery(NetworkDetails.class);
            criteria.from(NetworkDetails.class);
            networkList = s.createQuery(criteria).getResultList();
        }
        return networkList;

    }
}
