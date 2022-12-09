/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.AdoptorRole;

import Business.Adopt.AdoptHistory;
import Business.Animals.AnimalDetails;
import Business.Animals.CatDetails;
import Business.Animals.DogDetails;
import Business.EcoSystem.EcoSystem;
import Business.Enterprises.EnterpriseDetails;
import Business.Enterprises.RescueCenterEntDetails;
import Business.Network.NetworkDetails;
import Business.RescueRecord.RescueRecordDetails;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class SeeHistoryPage extends javax.swing.JPanel {

    /**
     * Creates new form SeeHistoryJPanel
     */
    
    private JPanel container;
    private EcoSystem business;
    private AdoptHistory history;

    SeeHistoryPage(JPanel container, EcoSystem business, AdoptHistory ah) {
        initComponents();
        this.container = container;
        this.business = business;
        this.history = ah;
        if(history.getStatus() == AdoptHistory.APPROVED_STATUS
                || history.getStatus() == AdoptHistory.INPROGRESS_STATUS) {
            btnDelivery.setEnabled(true);
        }
        else {
            btnDelivery.setEnabled(false);
        }
        
        populateValues();
        
    }

    public void populateValues() {
        AnimalDetails a = history.getAnimalname();
        lblType.setText(a.getAnimaltype().getValue());
        lblColor.setText(a.getAnimalcolor());
        lblDate.setText(history.toString());
        if(a instanceof DogDetails) {
            lblBreed.setText(((DogDetails) a).getDogbreed());
        }
        if(a instanceof CatDetails) {
            lblBreed.setText(((CatDetails) a).getCatbreed());
        }
       
        if(history.getStatus().equals(AdoptHistory.SUBMITTED_STATUS)) {
            lblStatus.setText("Submitted");
        }
        else if(history.getStatus().equals(AdoptHistory.ASSIGNED_STATUS)) {
            lblStatus.setText("Assigned");
        }
        else if(history.getStatus().equals(AdoptHistory.APPROVED_STATUS)) {
            lblStatus.setText("Approved");
        }
        else if(history.getStatus().equals(AdoptHistory.INPROGRESS_STATUS)) {
            lblStatus.setText("In Progress");
        }
        
        if(history.getMessage() == null || history.getMessage().equals("")) {
            lblMessage.setText("No Comments");
        }
        else {
            lblMessage.setText(history.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrevious = new javax.swing.JButton();
        lblAdoptionHistory = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblAnimaltype = new javax.swing.JLabel();
        lblBreeed = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        lblcomment = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblAdoptionSt = new javax.swing.JLabel();
        lblColour = new javax.swing.JLabel();
        lblAdoptionrt = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblBreed = new javax.swing.JLabel();
        btnDelivery = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnPrevious.setBackground(new java.awt.Color(255, 255, 255));
        btnPrevious.setForeground(new java.awt.Color(255, 0, 0));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        lblAdoptionHistory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAdoptionHistory.setForeground(new java.awt.Color(255, 51, 51));
        lblAdoptionHistory.setText("Adoption History Detail");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnimaltype.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblAnimaltype.setText("Animal Type:");

        lblBreeed.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblBreeed.setText("Breed:");

        lblMessage.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblMessage.setText("<value>");

        lblcomment.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblcomment.setText("Comment:");

        lblStatus.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblStatus.setText("<value>");

        lblAdoptionSt.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblAdoptionSt.setText("Adoption Status:");

        lblColour.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblColour.setText("Color:");

        lblAdoptionrt.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblAdoptionrt.setText("Adoption Date:");

        lblDate.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblDate.setText("<value>");

        lblColor.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblColor.setText("<value>");

        lblType.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblType.setText("<value>");

        lblBreed.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        lblBreed.setText("<value>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblColour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBreeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAnimaltype, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBreed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAdoptionrt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAdoptionSt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcomment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblType)
                    .addComponent(lblAnimaltype, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblColor)
                    .addComponent(lblColour))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBreed)
                    .addComponent(lblBreeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdoptionrt)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdoptionSt)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblcomment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(156, 156, 156))
        );

        btnDelivery.setBackground(new java.awt.Color(255, 255, 255));
        btnDelivery.setForeground(new java.awt.Color(255, 51, 51));
        btnDelivery.setText("See Delivery Details");
        btnDelivery.setEnabled(false);
        btnDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(lblAdoptionHistory))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDelivery)
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAdoptionHistory)
                        .addGap(37, 37, 37)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MyAdoptPage majp = (MyAdoptPage) component;
        majp.populateTable();
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("SeeDeliveryInfoJPanel", new SeeDeliverydetailspage(container, business, history));
        layout.next(container);
    }//GEN-LAST:event_btnDeliveryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelivery;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdoptionHistory;
    private javax.swing.JLabel lblAdoptionSt;
    private javax.swing.JLabel lblAdoptionrt;
    private javax.swing.JLabel lblAnimaltype;
    private javax.swing.JLabel lblBreed;
    private javax.swing.JLabel lblBreeed;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblColour;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblcomment;
    // End of variables declaration//GEN-END:variables
}