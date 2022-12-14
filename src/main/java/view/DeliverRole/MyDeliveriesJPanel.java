/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.DeliverRole;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Deliver.DeliveryDetails;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Organisation.DeliveryOrganisation;
import model.UserAccount.UserAccount;

/**
 *
 * @author vaibhav
 */
public class MyDeliveriesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyDeliveriesJPanel
     */
    
    private JPanel container;
    private RescueCenterEntDetails enterprise;
    private DeliveryOrganisation organization;
    private UserAccount userAccount;
    
    MyDeliveriesJPanel(JPanel container, EnterpriseDetails enterprise, DeliveryOrganisation organization, UserAccount userAccount) {
        initComponents();
        this.container = container;
        this.enterprise = (RescueCenterEntDetails)enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        
        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel)tblMyDeliveries.getModel();
        model.setRowCount(0);
        
        for(DeliveryDetails dh: enterprise.getDeliveryHistoryDirectory()) {
            if(dh.getCourierdetail().getId() == userAccount.getEmployee().getId()) {
                Object[] row = new Object[4];
                row[0] = dh;
                row[1] = dh.getAnimal().getType();
                row[2] = dh.getAdoptername().getAddress().getCityName();
                row[3] = dh.getStatus();
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

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSeeDetail = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMyDeliveries = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setText("Previous");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 610, 81, 32));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("PREVIOUS DELIVERIES");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, -1, -1));

        btnSeeDetail.setText("See Detail");
        btnSeeDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeDetailActionPerformed(evt);
            }
        });
        add(btnSeeDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 610, -1, 31));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));

        tblMyDeliveries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assigned Date", "Animal Type", "City", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMyDeliveries.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(tblMyDeliveries);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, 270));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ezgif-1-421fde06f4.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 1930, 1080));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSeeDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeDetailActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMyDeliveries.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        DeliveryDetails dh = (DeliveryDetails)tblMyDeliveries.getValueAt(selectedRow, 0);

        CardLayout layout = (CardLayout) container.getLayout();
        container.add("SeeDeliveryDetailJPanel", new SeeDeliveryDetailJPanel(container, dh));
        layout.next(container);
    }//GEN-LAST:event_btnSeeDetailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSeeDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMyDeliveries;
    // End of variables declaration//GEN-END:variables
}
