/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.DeliverRole;

import model.Deliver.DeliveryDetails;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Organisation.DeliveryOrganisation;
import model.UserAccount.UserAccount;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import view.Main.Main;

/**
 *
 * @author vaibhav
 */
public class DeliveryWorkspace extends javax.swing.JPanel {

    /**
     * Creates new form DeliveryWorkspace
     */
    
    private JPanel container;
    private RescueCenterEntDetails enterprise;
    private DeliveryOrganisation organization;
    private UserAccount userAccount;
    

    public DeliveryWorkspace(JPanel container, EnterpriseDetails enterprise, DeliveryOrganisation deliveryOrg, UserAccount userAccount) {
        initComponents();
        this.container = container;
        this.enterprise = (RescueCenterEntDetails) enterprise;
        this.organization = deliveryOrg;
        this.userAccount = userAccount;
        
        populateTable();
    }

    
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel)tblDelivery.getModel();
        model.setRowCount(0);
        
        for(DeliveryDetails dh: this.enterprise.getDeliveryHistoryDirectory()) {
            if(dh.getStatus().equals(DeliveryDetails.Status.WAITING)) {
                Object[] row = new Object[4];
                row[0] = dh;
                row[1] = dh.getAnimal().getType();
                row[3] = dh.getAdoptername().getAddress().getCityName();
                row[3] = dh.getAdoptername().getFirstName() + " " + dh.getAdoptername().getLastName();
                model.addRow(row);
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

        DeliveryServices = new javax.swing.JLabel();
        btnAssign = new javax.swing.JButton();
        btndeliveries = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDelivery = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeliveryServices.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryServices.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DeliveryServices.setForeground(new java.awt.Color(51, 0, 51));
        DeliveryServices.setText("DELIVERY SERVICES");
        add(DeliveryServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));

        btnAssign.setText("Assign To Myself");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 600, -1, 32));

        btndeliveries.setText("Previous Deliveries");
        btndeliveries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeliveriesActionPerformed(evt);
            }
        });
        add(btndeliveries, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, -1, 32));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        tblDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Delivery Date", "Animal Type", "City", "Receiver Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDelivery.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(tblDelivery);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ezgif-1-421fde06f4.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 0, 1930, 1090));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDelivery.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        DeliveryDetails dh = (DeliveryDetails)tblDelivery.getValueAt(selectedRow, 0);
        UserAccount ua = userAccount;
        dh.setCourierdetail(ua.getEmployee());
        dh.setStatus(DeliveryDetails.Status.ASSIGNED);
        Main.controller.saveOrUpdate(dh);

        populateTable();

        JOptionPane.showMessageDialog(null, "Work has been assigned to you. Please view it in My Deliveries panel.");
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btndeliveriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeliveriesActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("MyDeliveriesJPanel", new MyDeliveriesJPanel(container, enterprise, organization, userAccount));
        layout.next(container);
    }//GEN-LAST:event_btndeliveriesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DeliveryServices;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btndeliveries;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDelivery;
    // End of variables declaration//GEN-END:variables
}
