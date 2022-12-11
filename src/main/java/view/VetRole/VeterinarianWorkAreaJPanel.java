/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.VetRole;

import java.awt.CardLayout;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Animal.AnimalDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Organisation.VeterinarianOrganisation;
import model.Place.PlaceDetails;
import model.RescueRecord.RescueRecordDetails;
import model.Treatment.TreatmentRecord;
import model.UserAccount.UserAccount;
import view.Main.Main;

/**
 *
 * @author manohar
 */
public class VeterinarianWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VeterinarianWorkAreaJPanel
     */
    
    private JPanel container;
    private RescueCenterEntDetails enterprise;
    private VeterinarianOrganisation organization;
    private UserAccount userAccount;

    public VeterinarianWorkAreaJPanel(JPanel container, RescueCenterEntDetails enterprise, VeterinarianOrganisation veterinarianOrg, UserAccount userAccount) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        this.organization = veterinarianOrg;
        this.userAccount = userAccount;
        
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)tblTreatmentRequest.getModel();
        model.setRowCount(0);
        
        for(RescueRecordDetails r: enterprise.getRecordDirectory()){
            if(r.getRescueroom() == null && r.getRescuedanimal().getStatus() == AnimalDetails.Status.NOT_READY) {
                Object[] row = new Object[4];
                row[0] = r;
                row[1] = r.getRescuedanimal();
                row[2] = r.getRescuedanimal().getType();
                row[3] = r.getRescuedanimal().getColor();
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

        lblveterwork = new javax.swing.JLabel();
        btnAssign = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTreatmentRequest = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblveterwork.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblveterwork.setForeground(new java.awt.Color(51, 0, 51));
        lblveterwork.setText("VETERINARIAN WORKPLACE");
        add(lblveterwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, -1));

        btnAssign.setText("Self Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 90, 30));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        tblTreatmentRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Animal Id", "Animal Type", "Color"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTreatmentRequest.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(tblTreatmentRequest);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinary.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 0, 1930, 1200));
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTreatmentRequest.getSelectedRow();
        
        if (selectedRow < 0){
            
            return;
        }
        
        RescueRecordDetails record = (RescueRecordDetails)tblTreatmentRequest.getValueAt(selectedRow, 0);
        UserAccount ua = userAccount;
        for(PlaceDetails r: enterprise.getRoomDirectory()) {
            if(r.getVet().getId() == ua.getEmployee().getId()) {
                record.setRescueroom(r);
            }
        }
        
        Main.controller.saveOrUpdate(record);
        
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(record.getDate());  
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        record.getRescuedanimal().setNextCheck(calendar.getTime());
        
        Main.controller.saveOrUpdate(record.getRescuedanimal());
        
        TreatmentRecord treatment = new TreatmentRecord();
        treatment.setAnimalDeatils(record.getRescuedanimal());
        treatment.setRoom(record.getRescueroom());
        treatment.setDate(record.getDate());
        treatment.getAnimalDeatils().getTreatmentRecord().add(treatment);
        
        Main.controller.saveOrUpdate(treatment);
        Main.controller.saveOrUpdate(treatment.getAnimalDeatils());
        
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("TreatJPanel", new TreatJPanel(container, enterprise, userAccount, record, treatment));
        layout.next(container);
        
    }//GEN-LAST:event_btnAssignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblveterwork;
    private javax.swing.JTable tblTreatmentRequest;
    // End of variables declaration//GEN-END:variables
}
