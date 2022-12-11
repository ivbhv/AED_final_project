/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.AdoptInspectRole;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.AdoptDetails.AdoptRecord;
import model.Employees.EmployeeDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Organisation.AdoptionOrganisation;
import model.UserAccount.UserAccount;

/**
 *
 * @author sejal
 */
public class MyInspectPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyInspectPanel
     */
    private JPanel container;
    private RescueCenterEntDetails enterprise;
    private AdoptionOrganisation organization;
    private UserAccount userAccount;
    
    MyInspectPanel(JPanel container, RescueCenterEntDetails enterprise, AdoptionOrganisation organization, UserAccount userAccount) {
        initComponents();
        this.container = container;
        this.enterprise = (RescueCenterEntDetails)enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        
        populateTable();
    }
    
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel)tblMyInspections.getModel();
        model.setRowCount(0);
        EmployeeDetails me = userAccount.getEmployee();
        
        for(AdoptRecord ar: organization.getAdoptionRecordDirectory()) {
            if(ar.getEmployee() != null)  {
                if(ar.getStatus().equals(AdoptRecord.Status.Processing) && ar.getEmployee().getId() == me.getId()) {
                    Object[] row = new Object[4];
                    row[0] = ar;
                    row[1] = ar.getAdoptor().getFirstName() + " " + ar.getAdoptor().getLastName();
                    row[2] = ar.getAnimal().getId();
                    row[3] = "Processing";
                    model.addRow(row);
                }
            }
        }
        for(AdoptRecord ar: organization.getAdoptionRecordDirectory()) {
            if( (ar.getStatus().equals(AdoptRecord.Status.Approved) 
                    || ar.getStatus().equals(AdoptRecord.Status.Rejected)) 
                    && ar.getEmployee().getId() == me.getId() ) {
                Object[] row = new Object[4];
                row[0] = ar;
                row[1] = ar.getAdoptor().getFirstName() + " " + ar.getAdoptor().getLastName();
                row[2] = ar.getAnimal().getId();
                switch (ar.getStatus()) {
                    case Approved:
                        row[3] = "Approved";
                        break;
                    case Rejected:
                        row[3] = "Rejected";
                        break;
                    case In_Progress:
                        row[3] = "Adopting";
                        break;
                    default:
                        break;
                }
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
        btnDetail = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMyInspections = new javax.swing.JTable();
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
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("INSPECTION DETAIL");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        btnDetail.setText("View Details");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });
        add(btnDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 221, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblMyInspections.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Submitted Date", "Applicant Name", "Animal ID", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMyInspections.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(tblMyInspections);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OBl3g7.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1930, 1090));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMyInspections.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        AdoptRecord ar = (AdoptRecord)tblMyInspections.getValueAt(selectedRow, 0);
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("SeeInspectionDetailJPanel", new CheckInspectInfo(container, enterprise, ar));
        layout.next(container);
    }//GEN-LAST:event_btnDetailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMyInspections;
    // End of variables declaration//GEN-END:variables
}
