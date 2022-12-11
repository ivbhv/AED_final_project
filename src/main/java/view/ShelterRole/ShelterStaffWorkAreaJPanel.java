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
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Shelter Staff WorkArea");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

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
        jScrollPane1.setViewportView(tblShelter);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 537, 237));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jpgtopngconverter-com.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 0, 1930, 1090));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblShelter;
    // End of variables declaration//GEN-END:variables
}
