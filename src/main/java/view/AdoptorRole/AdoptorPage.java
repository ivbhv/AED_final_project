/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.AdoptorRole;

import java.awt.CardLayout;
import javax.swing.JPanel;
import model.AdoptDetails.AdopterDetails;

/**
 *
 * @author manohar
 */
public class AdoptorPage extends javax.swing.JPanel {

    /**
     * Creates new form AdoptorPage
     */
    private JPanel container;
    private AdopterDetails adoptor;
    
    public AdoptorPage(JPanel container, AdopterDetails adoptor) {
        initComponents();
        this.container  = container;
        this.adoptor = adoptor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnimal = new javax.swing.JLabel();
        btnMyAdoptionlist = new javax.swing.JButton();
        btnAdoptList = new javax.swing.JButton();
        btnEditInfo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblAnimal.setBackground(new java.awt.Color(255, 255, 255));
        lblAnimal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAnimal.setForeground(new java.awt.Color(255, 51, 51));
        lblAnimal.setText("ANIMAL RESCUE CENTER");

        btnMyAdoptionlist.setBackground(new java.awt.Color(255, 255, 255));
        btnMyAdoptionlist.setText("My Adoption list");
        btnMyAdoptionlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyAdoptionlistActionPerformed(evt);
            }
        });

        btnAdoptList.setBackground(new java.awt.Color(255, 255, 255));
        btnAdoptList.setText("Adoption details");
        btnAdoptList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptListActionPerformed(evt);
            }
        });

        btnEditInfo.setBackground(new java.awt.Color(255, 255, 255));
        btnEditInfo.setText("Edit Details");
        btnEditInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lblAnimal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnAdoptList, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnMyAdoptionlist, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnEditInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblAnimal)
                .addGap(36, 36, 36)
                .addComponent(btnAdoptList, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnMyAdoptionlist, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEditInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyAdoptionlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyAdoptionlistActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("MyAdoptionsJPanel", new MyAdoptPage(container, adoptor));
        layout.next(container);
    }//GEN-LAST:event_btnMyAdoptionlistActionPerformed

    private void btnAdoptListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptListActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("AdoptorListJPanel", new AdoptlistPage(container, adoptor));
        layout.next(container);
    }//GEN-LAST:event_btnAdoptListActionPerformed

    private void btnEditInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditInfoActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("AdoptorInformationJPanel", new AdoptInfoPage(container, adoptor));
        layout.next(container);
    }//GEN-LAST:event_btnEditInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdoptList;
    private javax.swing.JButton btnEditInfo;
    private javax.swing.JButton btnMyAdoptionlist;
    private javax.swing.JLabel lblAnimal;
    // End of variables declaration//GEN-END:variables
}
