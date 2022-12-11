/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.AdoptorRole;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.AdoptDetails.AdopterDetails;
import view.Main.Main;

/**
 *
 * @author manohar
 */
public class AdoptInfoPage extends javax.swing.JPanel {

    /**
     * Creates new form AdoptInfoPage
     */
    
    private JPanel container;
    private AdopterDetails adoptor;
    
    AdoptInfoPage(JPanel container, AdopterDetails adoptor) {
        initComponents();
        this.container  = container;
        this.adoptor = adoptor;
        
        populateValues();
        disableFields();
    }

    public void populateValues() {
        txtFirstN.setText(adoptor.getFirstName());
        txtLastN.setText(adoptor.getLastName());
        txtSsn.setText(adoptor.getSsnnumber());
        txtPhone.setText(adoptor.getPhoneNumber());
        txtEmail.setText(adoptor.getEmail());
        txtStreet.setText(adoptor.getAddress().getStreetName());
        txtCity.setText(adoptor.getAddress().getCityName());
        txtState.setText(adoptor.getAddress().getStateName());
    }
    
    public void clearFields() {
        txtFirstN.setText("");
        txtLastN.setText("");
        txtSsn.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtStreet.setText("");
        txtCity.setText("");
        txtState.setText("");
    }
    
    public void enableFields(){
        txtFirstN.setEnabled(true);
        txtLastN.setEnabled(true);
        txtSsn.setEnabled(true);
        txtPhone.setEnabled(true);
        txtEmail.setEnabled(true);
        txtStreet.setEnabled(true);
        txtCity.setEnabled(true);
        txtState.setEnabled(true);
        txtFirstN.setEditable(true);
        txtLastN.setEditable(true);
        txtSsn.setEditable(true);
        txtPhone.setEditable(true);
        txtEmail.setEditable(true);
        txtStreet.setEditable(true);
        txtCity.setEditable(true);
        txtState.setEditable(true);
    }
    
    public void disableFields() {
        txtFirstN.setEditable(false);
        txtLastN.setEditable(false);
        txtSsn.setEditable(false);
        txtPhone.setEditable(false);
        txtEmail.setEditable(false);
        txtStreet.setEditable(false);
        txtCity.setEditable(false);
        txtState.setEditable(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdopterInfo = new javax.swing.JLabel();
        btnPrevios = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCity = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtSsn = new javax.swing.JTextField();
        txtLastN = new javax.swing.JTextField();
        txtFirstN = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        lblSSN = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        lblLname = new javax.swing.JLabel();
        lblFname = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAdopterInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblAdopterInfo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAdopterInfo.setForeground(new java.awt.Color(255, 51, 51));
        lblAdopterInfo.setText("ADOPTER DETAILS");
        add(lblAdopterInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        btnPrevios.setForeground(new java.awt.Color(255, 0, 0));
        btnPrevios.setText("Back");
        btnPrevios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviosActionPerformed(evt);
            }
        });
        add(btnPrevios, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 32, 60, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCity.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtPhone.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtSsn.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtSsn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSsnActionPerformed(evt);
            }
        });

        txtLastN.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtLastN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNActionPerformed(evt);
            }
        });

        txtFirstN.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtFirstN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblEmail.setText("Email:");

        lblAddress.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblAddress.setText("Address:");

        lblPhoneNo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblPhoneNo.setText("Phone Number:");

        lblSSN.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblSSN.setText("Social Security:");

        txtState.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        lblLname.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblLname.setText("Last Name:");

        lblFname.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblFname.setText("First Name:");

        txtStreet.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("State");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("City");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Street");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLname)
                    .addComponent(lblFname)
                    .addComponent(lblSSN)
                    .addComponent(lblAddress)
                    .addComponent(lblEmail)
                    .addComponent(lblPhoneNo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFirstN, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPhone)
                                .addComponent(txtEmail)
                                .addComponent(txtStreet)
                                .addComponent(txtCity)
                                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)))
                    .addComponent(txtLastN, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFname))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLname))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSSN))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNo))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(54, 54, 54))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 730, 540));

        btnClear.setForeground(new java.awt.Color(255, 51, 51));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 80, 31));

        btnUpdate.setForeground(new java.awt.Color(255, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 80, 31));

        btnSave.setForeground(new java.awt.Color(255, 0, 0));
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 80, 31));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/372974.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1930, 1090));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviosActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnPreviosActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(txtFirstN.getText().equals("") || txtLastN.getText().equals("")
                || txtStreet.getText().equals("") || txtCity.getText().equals("")
                || txtState.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }
        if(!txtSsn.getText().matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Ssn should be a 9 digit number.");
            return;
        }
        if(!txtPhone.getText().matches("\\d{3}-?\\d{3}-?\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Phone Number should be a 10 digit number.");
            return;
        }
        if(!txtEmail.getText().matches("\\S+@\\w+\\.\\w+(.\\w+)*")) {
            JOptionPane.showMessageDialog(null, "Email is invalid.");
            return;
        }
        adoptor.setFirstName(txtFirstN.getText());
        adoptor.setLastName(txtLastN.getText());
        adoptor.setSsnnumber(txtSsn.getText());
        adoptor.setPhoneNumber(txtPhone.getText());
        adoptor.setEmail(txtEmail.getText());
        adoptor.getAddress().setStreetName(txtStreet.getText());
        adoptor.getAddress().setCityName(txtCity.getText());
        adoptor.getAddress().setStateName(txtState.getText());
        
        Main.controller.saveOrUpdate(adoptor);
               
        
        btnUpdate.setEnabled(true);
        disableFields();
        JOptionPane.showMessageDialog(null, "Updated successfully!");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        btnSave.setEnabled(true);
        enableFields();
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtLastNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNActionPerformed

    private void txtSsnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSsnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSsnActionPerformed

    private void txtFirstNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPrevios;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAdopterInfo;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblLname;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblSSN;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstN;
    private javax.swing.JTextField txtLastN;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSsn;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreet;
    // End of variables declaration//GEN-END:variables
}
