/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.AdoptorRole;

import Business.Adopt.AdoptionOfferedList;
import Business.Adopt.AdoptionOffered;
import Business.Adopt.AdopterDetail;
import Business.EcoSystem.EcoSystem;
import Business.Enterprises.EnterpriseDetails;
import Business.Enterprises.RescueCenterEntDetails;
import Business.Network.NetworkDetails;
import Business.UserAccount.UserAccountDetails;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class AdoptlistPage extends javax.swing.JPanel {

    /**
     * Creates new form AdoptlistPage
     */
    
    private JPanel container;
    private EcoSystem business;
    private AdopterDetail adoptor;
    
    public AdoptlistPage(JPanel container, EcoSystem business, AdopterDetail adoptor) {
        initComponents();
        this.container = container;
        this.business = business;
        this.adoptor = adoptor;
        
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel)tblOffering.getModel();
        model.setRowCount(0);
        
        for(NetworkDetails n: business.getNetworkList()) {
            for(EnterpriseDetails e: n.getEnterpriseDirectory().getEnterpriseList()) {
                if(e instanceof RescueCenterEntDetails) {
                    for(AdoptionOffered ao: ((RescueCenterEntDetails) e).getAdoptionList().getAdoptionOfferingList()) {
                        System.out.println(ao.getAnimal().getAnimalid());
                        System.out.println(ao.getPublishDate());
                        System.out.println(ao.getStatus());
                    }
                    AdoptionOfferedList list = ((RescueCenterEntDetails) e).getAdoptionList();
                    for(AdoptionOffered ao: list.getAdoptionOfferingList()) {
                        System.out.println(ao.getStatus());
                        System.out.println(AdoptionOffered.OPEN_STATUS);
                        if(ao.getStatus() != null) {
                            if(ao.getStatus().equals(AdoptionOffered.OPEN_STATUS)) {
                                Object[] row = new Object[5];
                                row[0] = ao;
                                row[1] = ao.getAnimal().getAnimalcolor();
                                row[2] = ao.getAnimal().getAnimalage();

                                int size = ao.getAnimal().getStatusDirectory().getStatusDir().size();
                                row[3] = ao.getAnimal().getStatusDirectory().getStatusDir().get(size-1).getAnimalweight();

                                row[4] = ao.getPublishDate().getMonth()
                                        + "/" + ao.getPublishDate().getDate()
                                        + "/" + ao.getPublishDate().getYear();
                                model.addRow(row);
                            }
                        }
                    }
                }
            }
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

        lblAdoptionlist = new javax.swing.JLabel();
        btnDetails = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOffering = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        lblAdoptionlist.setBackground(new java.awt.Color(255, 255, 255));
        lblAdoptionlist.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAdoptionlist.setForeground(new java.awt.Color(255, 51, 51));
        lblAdoptionlist.setText("ADOPTION DETAILS");

        btnDetails.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails.setForeground(new java.awt.Color(255, 0, 0));
        btnDetails.setText("Check Details");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(255, 255, 255));
        btnPrevious.setForeground(new java.awt.Color(255, 51, 51));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));

        tblOffering.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Animal Type", "Color", "Age", "Weight", "Published Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOffering.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tblOffering.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblOffering);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAdoptionlist)
                        .addGap(175, 175, 175))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(325, 325, 325)
                        .addComponent(btnDetails)
                        .addContainerGap(34, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblAdoptionlist)
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOffering.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        AdoptionOffered ao = (AdoptionOffered)tblOffering.getValueAt(selectedRow, 0);
        
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("SeeOfferingDetailJPanel", new SeeOfferinginfoPage(container, business, adoptor, ao));
        layout.next(container);
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnPreviousActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdoptionlist;
    private javax.swing.JTable tblOffering;
    // End of variables declaration//GEN-END:variables
}
