/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.EntAdminRole;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Animal.AnimalDetails;
import model.Animal.CatDetails;
import model.Animal.DogDetails;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.RescueRecord.RescueRecordDetails;

/**
 *
 * @author manohar
 */
public class EnterpriseAnalyseJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalyseJPanel
     */
    
    private JPanel container;
    private RescueCenterEntDetails enterprise;
    
    public EnterpriseAnalyseJPanel(JPanel userProcessContainer, EnterpriseDetails enterprise) {
        initComponents();
        this.container = userProcessContainer;
        this.enterprise = (RescueCenterEntDetails)enterprise;
        lblTotal.setText(String.valueOf(getTotalValue()));
        populateTypeTable();
        populateRatioTable();
    }

    public int getTotalValue() {
        int sum;
        sum = enterprise.getRecordDirectory().size();
        return sum;
    }
    
    public void populateTypeTable() {
        DefaultTableModel model = (DefaultTableModel) tblTypes.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        row[0] = "Dogs";
        row[1] = (getDogCount() / getTotalValue()) * 100 + "%";
        model.addRow(row);
        
        row[0] = "Cats";
        row[1] = (getCatCount() / getTotalValue()) * 100 + "%";
        model.addRow(row);
        
        row[0] = "Others";
        row[1] = ((getTotalValue() - getDogCount() - getCatCount()) 
                / getTotalValue()) * 100 + "%";
        model.addRow(row);
    }
    
    public void populateRatioTable() {
        DefaultTableModel model = (DefaultTableModel) tblRatios.getModel();
        model.setRowCount(0);
        Object[] row = new Object[2];
        row[0] = "Female";
        row[1] = getFemaleRatio()*100 + "%";
        model.addRow(row);
        
        row[0] = "No Breed";
        row[1] = getNoBreedRatio()*100 + "%";
        model.addRow(row);
        
        row[0] = "Unhealthy Before Rescued";
        row[1] = getUnhealthyRatio()*100 + "%";
        model.addRow(row);
    }
    
    public float getDogCount() {
        float count = 0;
        for(RescueRecordDetails rr: enterprise.getRecordDirectory()) {
            AnimalDetails a = rr.getRescuedanimal();
            if(a.getType().equals(AnimalDetails.AnimalType.Dog)) {
                count++;
            }
        }
        return count;
    }
    
    public float getCatCount() {
        float count = 0;
        for(RescueRecordDetails rr: enterprise.getRecordDirectory()) {
            AnimalDetails a = rr.getRescuedanimal();
            System.out.println(a.getType());
            if(a.getType().equals(AnimalDetails.AnimalType.Cat)) {
                count++;
            }
        }
        return count;
    }
    
    public float getFemaleRatio() {
        float ratio;
        float fCount = 0;
        for(RescueRecordDetails rr: enterprise.getRecordDirectory()) {
            if(rr.getRescuedanimal().getGender() != null) {
                if(rr.getRescuedanimal().getGender().equals("F")) {
                    fCount++;
                }
            }
        }
        ratio = fCount / getTotalValue();
        return ratio;     
    }
    
    public float getNoBreedRatio() {
        float ratio;
        float count = 0;
        
        if(enterprise.getRecordDirectory() != null) {
            return 0;
        }
        else{
            for(RescueRecordDetails rr: enterprise.getRecordDirectory()) {
                AnimalDetails a = rr.getRescuedanimal();
                if(a.getType().equals(AnimalDetails.AnimalType.Cat)
                        ||  a.getType().equals(AnimalDetails.AnimalType.Dog)) {
                    if(a.getType().equals(AnimalDetails.AnimalType.Cat)) {
                        if( ((CatDetails)a).getBreed().equals("None")) {
                            count++;
                        }
                    }
                    else if(a.getType().equals(AnimalDetails.AnimalType.Dog)) {
                        if( ((DogDetails)a).getBreed().equals("None")) {
                            count++;
                        }
                    }
                }
            }
        }
        ratio = count / getTotalValue();
        return ratio;     
    }
    
    public float getUnhealthyRatio() {
        float ratio;
        float count = 0;
        for(RescueRecordDetails rr: enterprise.getRecordDirectory()) {
            if(rr.isHealth() == false) {
                count++;
            }
        }
        ratio = count / getTotalValue();
        return ratio;    
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
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTypes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRatios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setForeground(new java.awt.Color(255, 51, 51));
        btnBack.setText("Previous");
        btnBack.setToolTipText("");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 700, -1, 25));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Enterprise Level Analysis");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel2.setText("Total Quantity Rescued:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, -1));

        lblTotal.setBackground(new java.awt.Color(255, 255, 255));
        lblTotal.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblTotal.setText("<Value>");
        add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 98, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Types", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        tblTypes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Percentage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTypes.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane2.setViewportView(tblTypes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ratios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        tblRatios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Percentage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRatios.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(tblRatios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 580, 200));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system-administrator.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -10, 1930, 1130));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblRatios;
    private javax.swing.JTable tblTypes;
    // End of variables declaration//GEN-END:variables
}
