/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.AdoptorRole;


import java.awt.CardLayout;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.AdoptDetails.AdoptHistory;
import model.AdoptDetails.AdoptRecord;
import model.AdoptDetails.AdopterDetails;
import model.AdoptDetails.AdoptionOffered;
import model.Animal.AnimalDetails;
import model.Animal.CatDetails;
import model.Animal.DogDetails;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Network.NetworkDetails;
import model.Organisation.AdoptionOrganisation;
import model.Organisation.OrganisationMain;
import model.RescueRecord.RescueRecordDetails;
import view.Main.Main;

/**
 *
 * @author manohar
 */
public class SeeOfferinginfoPage extends javax.swing.JPanel {

    /**
     * Creates new form SeeOfferinginfoPage
     */
    
    private JPanel container;
    private AdoptionOffered ao;
    private AdopterDetails adoptor;
    
    public SeeOfferinginfoPage(JPanel container, AdopterDetails adoptor, AdoptionOffered ao) {
        initComponents();
        this.container = container;
        this.ao = ao;
        this.adoptor = adoptor;
        
        populateValues();
    }

    public void populateValues() {
        AnimalDetails a = ao.getAnimal();
        lblType.setText(a.getType().toString());
        lblColor.setText(a.getColor());
        lblAge.setText(String.valueOf(a.getAge()));
        if(a instanceof DogDetails) {
            lblBreed.setText(((DogDetails) a).getBreed());
        } 
        else if(a instanceof CatDetails) {
            lblBreed.setText(((CatDetails) a).getBreed());
        }
        else {
            lblBreed.setText("None");
        }
        
        int size = ao.getAnimal().getStatusDirectory().size();
        double weight = ao.getAnimal().getStatusDirectory().get(size-1).getWeight();
        lblWeight.setText(String.valueOf(weight));
        
        String location = "Unknown";
        for(NetworkDetails n: new NetworkDetails().getNetworkList()) {
            for(EnterpriseDetails e: n.getEnterpriseDirectory()) {
                if(e instanceof RescueCenterEntDetails) {
                    for(RescueRecordDetails rr: ((RescueCenterEntDetails) e).getRecordDirectory()) {
                        location = rr.getFoundlocation();
                    }
                }
            }
        }
        lblLocation.setText(location);
        /*
        if(a.isIsSterilized()) {
            lblSterilized.setText("Yes");
        }
        else {
            lblSterilized.setText("No");
        }
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnimalDetails = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTyp = new javax.swing.JLabel();
        lblSterilized = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblsterilize = new javax.swing.JLabel();
        lblLocat = new javax.swing.JLabel();
        lblweight = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        lblAgee = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblBreed = new javax.swing.JLabel();
        lblColour = new javax.swing.JLabel();
        lblbreeed = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        btnAdoption = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnimalDetails.setBackground(new java.awt.Color(255, 255, 255));
        lblAnimalDetails.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAnimalDetails.setForeground(new java.awt.Color(255, 51, 51));
        lblAnimalDetails.setText("ADOPTING ANIMAL DETAILS");
        add(lblAnimalDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        btnPrevious.setForeground(new java.awt.Color(255, 51, 51));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 81, 32));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTyp.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblTyp.setText("Type:");

        lblSterilized.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblSterilized.setText(" Yes");

        lblLocation.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblLocation.setText("<value>");

        lblsterilize.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblsterilize.setText("Sterilized or Not:");

        lblLocat.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblLocat.setText("Location Found:");

        lblweight.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblweight.setText("Weight:");

        lblWeight.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblWeight.setText("<value>");

        lblAgee.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblAgee.setText("Age:");

        lblAge.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblAge.setText("<value>");

        lblBreed.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblBreed.setText("<value>");

        lblColour.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblColour.setText("Color:");

        lblbreeed.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblbreeed.setText("Breed:");

        lblColor.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblColor.setText("<value>");

        lblType.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblType.setText("<value>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAgee)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblbreeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblColour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTyp)))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblBreed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblweight)
                                    .addComponent(lblLocat))
                                .addGap(79, 79, 79))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblsterilize)
                                .addGap(71, 71, 71)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSterilized, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTyp)
                    .addComponent(lblType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColour)
                    .addComponent(lblColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgee)
                    .addComponent(lblAge))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbreeed)
                    .addComponent(lblBreed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblweight)
                    .addComponent(lblWeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocat)
                    .addComponent(lblLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsterilize)
                    .addComponent(lblSterilized))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 430, 240));

        btnAdoption.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnAdoption.setForeground(new java.awt.Color(255, 51, 51));
        btnAdoption.setText("Adopt");
        btnAdoption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptionActionPerformed(evt);
            }
        });
        add(btnAdoption, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jpgtopngconverter-com.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1930, 1090));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdoptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptionActionPerformed
        // TODO add your handling code here:
        AdoptHistory history = new AdoptHistory();
        Date hd = new Date();
        history.setDetails(ao.getAnimal());
        history.setStatus(AdoptHistory.Status.Submitted);
        history.setAdoptDate(hd);
        
        Main.controller.saveObject(history);
        adoptor.getHistory().add(history);
        Main.controller.saveOrUpdate(adoptor);
        ao.setStatus(AdoptionOffered.Status.Close);
        Main.controller.saveOrUpdate(ao);
        
        
        AdoptRecord adoptionRecord = new AdoptRecord();
        adoptionRecord.setAdoptor(adoptor);
        adoptionRecord.setAnimal(ao.getAnimal());
        adoptionRecord.setDate(hd);
        adoptionRecord.setStatus(AdoptRecord.Status.Submitted);
        Main.controller.saveObject(adoptionRecord);
        
        
        for(NetworkDetails n: new NetworkDetails().getNetworkList()) {
            for(EnterpriseDetails e: n.getEnterpriseDirectory()) {
                    for(OrganisationMain o: e.getOrganisationDirectory()) {
                         if(o instanceof AdoptionOrganisation adoptionOrganisation) {
                             adoptionOrganisation.getAdoptionRecordDirectory().add(adoptionRecord);
                             Main.controller.saveOrUpdate(adoptionOrganisation);
                         }
                    }
                
            }
        }
        btnAdoption.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Adoption application has been submitted.");
    }//GEN-LAST:event_btnAdoptionActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AdoptlistPage aljp = (AdoptlistPage) component;
        aljp.populateTable();
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnPreviousActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdoption;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAgee;
    private javax.swing.JLabel lblAnimalDetails;
    private javax.swing.JLabel lblBreed;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblColour;
    private javax.swing.JLabel lblLocat;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblSterilized;
    private javax.swing.JLabel lblTyp;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel lblbreeed;
    private javax.swing.JLabel lblsterilize;
    private javax.swing.JLabel lblweight;
    // End of variables declaration//GEN-END:variables
}
