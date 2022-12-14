/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.PharmcistRole;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Organisation.PharmacyOrganisation;
import model.UserAccount.UserAccount;
import model.WorkQueue.AllWorkRequest;
import model.WorkQueue.PharmacyWre;
import view.Main.Main;

/**
 *
 * @author manohar
 */
public class PharmacistWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacistWorkAreaJPanel
     */

    private JPanel container;
    private RescueCenterEntDetails enterprise;
    private PharmacyOrganisation organization;
    private UserAccount userAccount;
    
    public PharmacistWorkAreaJPanel(JPanel container, EnterpriseDetails enterprise, PharmacyOrganisation organization, UserAccount userAccount) {
        initComponents();
        this.container = container;
        this.enterprise = (RescueCenterEntDetails)enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        
        populateTable();
    }

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)tblMedicine.getModel();
        model.setRowCount(0);
        for(AllWorkRequest request: organization.getWorkQueue()) {
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getWresender().getEmployee().getName();
            row[2] = request.getWrereceiver() == null ? null : request.getWrereceiver().getEmployee().getName();
            row[3] = request.getWrestatus();

            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        btnAssign = new javax.swing.JButton();
        btnAnalyse = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicine = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("PHARMACIST WORKPLACE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 130, -1, -1));

        btnAssign.setText("Self Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 390, 118, 33));

        btnAnalyse.setText("Analysis");
        btnAnalyse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalyseActionPerformed(evt);
            }
        });
        add(btnAnalyse, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 390, 101, 33));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        tblMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMedicine.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(tblMedicine);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 200, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pharmacy.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 2040, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMedicine.getSelectedRow();
        if (selectedRow < 0){
            return;
        }
        
        PharmacyWre request = (PharmacyWre)tblMedicine.getValueAt(selectedRow, 0);
        request.setWrestatus("Processing");
        
        Main.controller.saveOrUpdate(request);
        
        DispenseMedicineJPanel dispenseMedicineJPanel = new DispenseMedicineJPanel(container, request);
        container.add("dispenseMedicineJPanel", dispenseMedicineJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnAnalyseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalyseActionPerformed
        // TODO add your handling code here:
        MedicineAnalyseJPanel medicineAnalyseJPanel = new MedicineAnalyseJPanel(container, enterprise, organization);
        container.add("dispenseMedicineJPanel", medicineAnalyseJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnAnalyseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalyse;
    private javax.swing.JButton btnAssign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedicine;
    // End of variables declaration//GEN-END:variables
}
