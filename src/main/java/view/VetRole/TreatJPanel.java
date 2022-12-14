/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.VetRole;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Animal.CatDetails;
import model.Animal.DogDetails;
import model.Cages.CageDetail;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.RescueRecord.RescueRecordDetails;
import model.Treatment.TreatmentRecord;
import model.UserAccount.UserAccount;
import view.Main.Main;

/**
 *
 * @author sejal
 */
public class TreatJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TreatJPanel
     */
    
    private JPanel container;
    private RescueCenterEntDetails enterprise;
    //private VeterinarianOrganisation organization;
    private UserAccount userAccount;
    private RescueRecordDetails rescueRecord;
    private TreatmentRecord treatment;
    
    public TreatJPanel(JPanel container, EnterpriseDetails enterprise, UserAccount userAccount, RescueRecordDetails record, TreatmentRecord treatment) {
        initComponents();
        this.container = container;
        this.enterprise = (RescueCenterEntDetails)enterprise;
        //this.organization = organization;
        this.userAccount = userAccount;
        this.rescueRecord = record;
        this.treatment = treatment;
       
        
        rbtnYes.setSelected(true);
        rbtnHealthy.setSelected(true);
        rbtnNone.setSelected(false);
        populateAnimal();
    }

    public void populateAnimal(){
        DefaultTableModel model = (DefaultTableModel)tblAnimal.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        row[0] = rescueRecord.getRescuedanimal().getId();
        row[1] = rescueRecord.getRescuedanimal().getType();
        row[2] = rescueRecord.getRescuedanimal().getColor();
        model.addRow(row);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblanimaltreat = new javax.swing.JLabel();
        btnRequest = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimal = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBreed = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rbtnHealthy = new javax.swing.JRadioButton();
        rbtnNotHealthy = new javax.swing.JRadioButton();
        rbtnNone = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rbtnYes = new javax.swing.JRadioButton();
        rbtnNo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setForeground(new java.awt.Color(255, 0, 0));
        btnBack.setText(" Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 580, 81, 20));

        lblanimaltreat.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblanimaltreat.setForeground(new java.awt.Color(51, 0, 51));
        lblanimaltreat.setText("ANIMAL TREAT");
        add(lblanimaltreat, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, -1, -1));

        btnRequest.setText("Send Request To Pharmacy");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });
        add(btnRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, -1, 20));

        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 580, 70, 20));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        tblAnimal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Animal ID", "Animal Type", "Color"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAnimal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        jLabel3.setText("Age:");

        jLabel5.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        jLabel5.setText("Breed:");

        jLabel6.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        jLabel6.setText("Is Healthy:");

        rbtnHealthy.setText("Yes");
        rbtnHealthy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnHealthyActionPerformed(evt);
            }
        });

        rbtnNotHealthy.setText("No");
        rbtnNotHealthy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNotHealthyActionPerformed(evt);
            }
        });

        rbtnNone.setText("None");
        rbtnNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoneActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        jLabel4.setText("Sterilized Or Not:");

        rbtnYes.setText("Yes");
        rbtnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnYesActionPerformed(evt);
            }
        });

        rbtnNo.setText("No");
        rbtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNone))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtnHealthy)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNotHealthy))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtnYes)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNo)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnNone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbtnHealthy)
                    .addComponent(rbtnNotHealthy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbtnYes)
                    .addComponent(rbtnNo))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, 150));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinary.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 0, 1930, 1200));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        VeterinarianWorkAreaJPanel vwajp = (VeterinarianWorkAreaJPanel) component;
        vwajp.populateTable();
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void rbtnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnYesActionPerformed
        // TODO add your handling code here:
        rbtnNo.setSelected(false);
    }//GEN-LAST:event_rbtnYesActionPerformed

    private void rbtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoActionPerformed
        // TODO add your handling code here:
        rbtnYes.setSelected(false);
    }//GEN-LAST:event_rbtnNoActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        // TODO add your handling code here:
        if( !txtAge.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null,"Age is invalid.");
            return;
        }
        if (rbtnNone.isSelected() == false && txtBreed.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Breed is required.");
            return;
        }
        int age = Integer.parseInt(txtAge.getText());
        boolean sterilized;
        boolean isFull = true;
        
        rescueRecord.getRescuedanimal().setAge(age);
        Main.controller.saveOrUpdate(rescueRecord.getRescuedanimal());
        if(rescueRecord.getRescuedanimal() instanceof CatDetails catDetails) {
            if(rbtnNone.isSelected() == true) {
                catDetails.setBreed("None");
            }
            else {
                catDetails.setBreed(txtBreed.getText());
            }
            Main.controller.saveOrUpdate(catDetails);
        }
        if(rescueRecord.getRescuedanimal() instanceof DogDetails dogDetails) {
            if(rbtnNone.isSelected() == true) {
                dogDetails.setBreed("None");
            }
            else {
                dogDetails.setBreed(txtBreed.getText());
            }
            Main.controller.saveOrUpdate(dogDetails);
        }
        
        if(rbtnHealthy.isSelected() == true) {
            rescueRecord.setHealth(true);
        }
        else {
            rescueRecord.setHealth(false);
        }
        
        sterilized = rbtnYes.isSelected() == true;
        rescueRecord.getRescuedanimal().setIsSterilized(sterilized);
        Main.controller.saveOrUpdate(rescueRecord);
        Main.controller.saveOrUpdate(rescueRecord.getRescuedanimal());
        for(CageDetail c: enterprise.getCageCellDirectory()) {
            if(c.getCagestatus().equals(CageDetail.Status.AVAILABLE)) {
                c.setAnimal(rescueRecord.getRescuedanimal());
                c.setCagestatus(CageDetail.Status.OCCUPIED);
                Main.controller.saveOrUpdate(c);
                isFull = false;
                break;
            }
        }
        if(isFull == true) {
            
        }
        btnRequest.setEnabled(false);
        btnFinish.setEnabled(false);
        JOptionPane.showMessageDialog(null,"Treatment has been recorded.");
    }//GEN-LAST:event_btnFinishActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("RequestMedicineJPanel", new RequestMedicineJPanel(container, enterprise, userAccount, treatment,rescueRecord));
        layout.next(container);
    }//GEN-LAST:event_btnRequestActionPerformed

    private void rbtnHealthyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnHealthyActionPerformed
        // TODO add your handling code here:
        rbtnNotHealthy.setSelected(false);
    }//GEN-LAST:event_rbtnHealthyActionPerformed

    private void rbtnNotHealthyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNotHealthyActionPerformed
        // TODO add your handling code here:
        rbtnHealthy.setSelected(false);
    }//GEN-LAST:event_rbtnNotHealthyActionPerformed

    private void rbtnNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoneActionPerformed
        // TODO add your handling code here:
        if(rbtnNone.isSelected() == true) {
            txtBreed.setEnabled(false);
        }
        else if(rbtnNone.isSelected() == false) {
            txtBreed.setEnabled(true);
        }
    }//GEN-LAST:event_rbtnNoneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblanimaltreat;
    private javax.swing.JRadioButton rbtnHealthy;
    private javax.swing.JRadioButton rbtnNo;
    private javax.swing.JRadioButton rbtnNone;
    private javax.swing.JRadioButton rbtnNotHealthy;
    private javax.swing.JRadioButton rbtnYes;
    private javax.swing.JTable tblAnimal;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBreed;
    // End of variables declaration//GEN-END:variables
}
