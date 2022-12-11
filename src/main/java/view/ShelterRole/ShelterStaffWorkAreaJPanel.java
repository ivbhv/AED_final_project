/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ShelterRole;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Animal.AnimalDetails;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Organisation.ShelterOrganisation;
import model.ShelterCell.ShelterCellDetails;
import model.UserAccount.UserAccount;

/**
 *
 * @author manohar
 */
public class ShelterStaffWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShelterStaffWorkAreaJPanel
     */
    
    private JPanel container;
    private RescueCenterEntDetails enterprise;
    private ShelterOrganisation organization;
    private UserAccount userAccount;
    
    public ShelterStaffWorkAreaJPanel(JPanel container, EnterpriseDetails enterprise, ShelterOrganisation shelterOrg, UserAccount userAccount) {
        initComponents();
        this.container = container;
        this.enterprise = (RescueCenterEntDetails)enterprise;
        this.organization = shelterOrg;
        this.userAccount = userAccount;
        
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel)tblShelter.getModel();
        model.setRowCount(0);
        
        for(ShelterCellDetails sc: enterprise.getShelterCellDirectory()){
            if(sc.getStatus() == ShelterCellDetails.Status.OCCUPIED) {
                Object[] row = new Object[5];
                row[0] = sc;
                row[1] = sc.getLocation();
                row[2] = sc.getAnimal().getType().toString();
                row[3] = sc.getAnimal().getColor();
                if(sc.getAnimal().getStatus() == AnimalDetails.Status.ADOPTED) {
                    row[4] = "Yes";
                }
                else {
                    row[4] = "No";
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShelter = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Shelter Staff WorkArea");

        tblShelter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Shelter", "Location", "Animal Type", "Color", "Adopted or Not"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShelter.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tblShelter.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblShelter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblShelter;
    // End of variables declaration//GEN-END:variables
}
