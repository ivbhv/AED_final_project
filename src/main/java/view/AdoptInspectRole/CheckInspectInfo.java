/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.AdoptInspectRole;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import model.AdoptDetails.AdoptRecord;
import model.AdoptDetails.AdopterDetails;
import model.Animal.AnimalDetails;
import model.Enterprises.RescueCenterEntDetails;
import view.AdoptorRole.AdoptorPage;

/**
 *
 * @author sejal
 */
public class CheckInspectInfo extends javax.swing.JPanel {

    /**
     * Creates new form CheckInspectInfo
     */
    
    private JPanel container;
    private AdoptRecord ar;
    private RescueCenterEntDetails enterprise;
    
    CheckInspectInfo(JPanel container, RescueCenterEntDetails enterprise, AdoptRecord ar) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        this.ar = ar;
        btnEval.setVisible(false);
        
        populateButton();
        populateValues();
    }
    
    public void populateButton() {
        if(ar.getStatus().equals(AdoptRecord.Status.Approved) 
                || ar.getStatus().equals(AdoptRecord.Status.Rejected )
                || ar.getStatus().equals(AdoptRecord.Status.In_Progress)) {
            btnEval.setVisible(false);
        }
        else {
            btnEval.setVisible(true);
        }
    }
    
    public void populateValues() {
        AnimalDetails animal = ar.getAnimal();
        AdopterDetails adopter = ar.getAdoptor();
        
        lblAnimalId.setText(String.valueOf(animal.getId()));
        lblType.setText(animal.getType().toString());
        lblColor.setText(animal.getColor());
        
        lblSsn.setText(adopter.getSsnnumber());
        lblFirstName.setText(adopter.getFirstName());
        lblLastName.setText(adopter.getLastName());
        lblPhone.setText(adopter.getPhoneNumber());
        lblEmail.setText(adopter.getEmail());
        lblStreet.setText(adopter.getAddress().getStreetName());
        lblCity.setText(adopter.getAddress().getCityName());
        lblState.setText(adopter.getAddress().getStateName());
        
        int size = adopter.getHistory().size();
        if(size == 1) {
            lblHasHistory.setText("No");
        }
        else {
            lblHasHistory.setText("Yes");
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

        jPanel2 = new javax.swing.JPanel();
        lblAnimalDetails = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblAnimalIdentity = new javax.swing.JLabel();
        lblAnimalId = new javax.swing.JLabel();
        lblAnimalType = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblColour = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        btnEval = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblSocialsec = new javax.swing.JLabel();
        lblFirstN = new javax.swing.JLabel();
        lblLastN = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblSsn = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        LblEmailadd = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        lblStreet = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblHasHistory = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnimalDetails.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAnimalDetails.setForeground(new java.awt.Color(255, 0, 0));
        lblAnimalDetails.setText("INSPECTION DETAILS");
        add(lblAnimalDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        btnPrevious.setForeground(new java.awt.Color(255, 51, 51));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, -1, 29));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Animal Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 15), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnimalIdentity.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblAnimalIdentity.setText("Animal ID:");
        jPanel1.add(lblAnimalIdentity, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 26, 107, -1));

        lblAnimalId.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblAnimalId.setText("<value>");
        jPanel1.add(lblAnimalId, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 26, 161, -1));

        lblAnimalType.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblAnimalType.setText("Type of Animal:");
        jPanel1.add(lblAnimalType, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 54, 107, -1));

        lblType.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblType.setText("<value>");
        jPanel1.add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 54, 161, -1));

        lblColour.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblColour.setText("Colour:");
        jPanel1.add(lblColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 82, 107, -1));

        lblColor.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblColor.setText("<value>");
        jPanel1.add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 82, 161, -1));

        btnEval.setText("Evaluate");
        btnEval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvalActionPerformed(evt);
            }
        });
        jPanel1.add(btnEval, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 54, -1, 33));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 654, 110));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adopter Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 15), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSocialsec.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblSocialsec.setText("Social Security:");
        jPanel3.add(lblSocialsec, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 44, 181, -1));

        lblFirstN.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblFirstN.setText("First Name:");
        jPanel3.add(lblFirstN, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 66, 181, -1));

        lblLastN.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblLastN.setText("Last Name:");
        jPanel3.add(lblLastN, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 88, 181, -1));

        lblLastName.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblLastName.setText("<value>");
        jPanel3.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 88, 161, -1));

        lblFirstName.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblFirstName.setText("<value>");
        jPanel3.add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 66, 161, -1));

        lblSsn.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblSsn.setText("<value>");
        jPanel3.add(lblSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 44, 161, -1));

        lblAddress.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblAddress.setText("Address:");
        jPanel3.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 154, 181, -1));

        LblEmailadd.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        LblEmailadd.setText("Email:");
        jPanel3.add(LblEmailadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 132, 181, -1));

        lblPhoneNo.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblPhoneNo.setText("Phone Number:");
        jPanel3.add(lblPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 110, 181, -1));

        lblStreet.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblStreet.setText("<value>");
        jPanel3.add(lblStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 154, 161, -1));

        lblEmail.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblEmail.setText("<value>");
        jPanel3.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 132, 161, -1));

        lblPhone.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblPhone.setText("<value>");
        jPanel3.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 110, 161, -1));

        jLabel13.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        jLabel13.setText("Adoption History:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 220, 181, -1));

        lblHasHistory.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblHasHistory.setText("<value>");
        jPanel3.add(lblHasHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 220, 161, -1));

        lblCity.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblCity.setText("<value>");
        jPanel3.add(lblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 176, 161, -1));

        lblState.setFont(new java.awt.Font("??????", 0, 14)); // NOI18N
        lblState.setText("<value>");
        jPanel3.add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 198, 161, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 654, 247));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_2.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1660, 1060));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MyInspectPanel mijp = (MyInspectPanel) component;
        mijp.populateTable();
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnEvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvalActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("EvaluateJPanel", new EvaluationPage(container, enterprise, ar));
        layout.next(container);
    }//GEN-LAST:event_btnEvalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblEmailadd;
    private javax.swing.JButton btnEval;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAnimalDetails;
    private javax.swing.JLabel lblAnimalId;
    private javax.swing.JLabel lblAnimalIdentity;
    private javax.swing.JLabel lblAnimalType;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblColour;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstN;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblHasHistory;
    private javax.swing.JLabel lblLastN;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblSocialsec;
    private javax.swing.JLabel lblSsn;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblType;
    // End of variables declaration//GEN-END:variables
}
