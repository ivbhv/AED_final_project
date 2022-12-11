/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.SysAdminRole;

import java.awt.CardLayout;
import static java.time.InstantSource.system;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.AdoptDetails.AdoptRecord;
import model.Animal.AnimalDetails;
import model.Animal.CatDetails;
import model.Animal.DogDetails;
import model.Enterprises.EnterpriseDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Network.NetworkDetails;
import model.Organisation.AdoptionOrganisation;
import model.Organisation.OrganisationMain;
import model.UserAccount.VisitorAccount;

/**
 *
 * @author user
 */
public class AnalyseAdoptionsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalyseAdoptionsJPanel
     */
    
    private JPanel userProcessContainer;
    
    public AnalyseAdoptionsJPanel(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        populateTypeTable();
        populateValues();
    }
    
    public void populateValues() {
        lblAdoptions.setText(String.valueOf(getTotalAdoptions()));
        lblAdopters.setText(String.valueOf(getAdoptersCount()));
        lblPercentage.setText(String.valueOf((getAdoptedCount() / getTotalValue()) * 100) + "%");
    }
    
    public void populateTypeTable() {
        DefaultTableModel model = (DefaultTableModel) tblTypes.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        row[0] = "Dogs";
        row[1] = String.valueOf((getDogCount() / getTotalAdoptions()) * 100) + "%";
        model.addRow(row);
        
        row[0] = "Male";
        row[1] = String.valueOf((getMaleCount() / getTotalAdoptions()) * 100) + "%";
        model.addRow(row);
        
        row[0] = "Has Breed";
        row[1] = String.valueOf((getBreedCount() / getTotalAdoptions()) * 100) + "%";
        model.addRow(row);
    }
    
    public int getTotalAdoptions() {
        int count = 0;
        for (NetworkDetails network : new NetworkDetails().getNetworkList()) {
            for (EnterpriseDetails enterprise : network.getEnterpriseDirectory()) {
                if(enterprise instanceof RescueCenterEntDetails) {
                    for(OrganisationMain org: enterprise.getOrganisationDirectory()) {
                        if(org instanceof AdoptionOrganisation) {
                            for(AdoptRecord ar: ((AdoptionOrganisation) org).getAdoptionRecordDirectory()) {
                                count++;
                            }
                        }
                    }
                    
                }
            }
        }
        return count;
    }
    
    public int getAdoptersCount() {
        int count = 0;
        for(VisitorAccount va: new VisitorAccount().getVisitorList()) {
            count++;
        }
        /*
        for (NetworkDetails network : system.getNetworkList()) {
            for (EnterpriseDetails enterprise : network.getEnterpriseDir().getEnterpriseList()) {
                if(enterprise instanceof RescueCenterEntDetails) {
                    for(OrganisationMain org: enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if(org instanceof AdoptionOrganisation) {
                            for(AdopterDetail a: ((AdoptionOrganisation) org).getAdopterDir().getAdoptorList()) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        */
        return count;
    }
    
    public float getAdoptedCount() {
        float count = 0;
        for (NetworkDetails network : new NetworkDetails().getNetworkList()) {
            for (EnterpriseDetails enterprise : network.getEnterpriseDirectory()) {
                if(enterprise instanceof RescueCenterEntDetails) {
                    for(AnimalDetails a: ((RescueCenterEntDetails) enterprise).getAnimalDirectory()) {
                        if(a.getStatus().equals(AnimalDetails.Status.ADOPTED)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    public int getTotalValue() {
        int sum = 0;
        for (NetworkDetails network : new NetworkDetails().getNetworkList()) {
            for (EnterpriseDetails enterprise : network.getEnterpriseDirectory()) {
                if(enterprise instanceof RescueCenterEntDetails) {
                    sum += ((RescueCenterEntDetails) enterprise).getRecordDirectory().size();
                }
            }
        }
        return sum;
    }
    
    
    public float getDogCount() {
        float count = 0;
        for (NetworkDetails network : new NetworkDetails().getNetworkList()) {
            for (EnterpriseDetails enterprise : network.getEnterpriseDirectory()) {
                if(enterprise instanceof RescueCenterEntDetails) {
                    for(OrganisationMain org: enterprise.getOrganisationDirectory()) {
                        if(org instanceof AdoptionOrganisation) {
                            for(AdoptRecord ar: ((AdoptionOrganisation) org).getAdoptionRecordDirectory()) {
                                if(ar.getAnimal().getType().equals(AnimalDetails.AnimalType.Dog)) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    
    public float getMaleCount() {
        float count = 0;
        for (NetworkDetails network : new NetworkDetails().getNetworkList()) {
            for (EnterpriseDetails enterprise : network.getEnterpriseDirectory()) {
                if(enterprise instanceof RescueCenterEntDetails) {
                    for(OrganisationMain org: enterprise.getOrganisationDirectory()) {
                        if(org instanceof AdoptionOrganisation) {
                            for(AdoptRecord ar: ((AdoptionOrganisation) org).getAdoptionRecordDirectory()) {
                                if(ar.getAnimal().getGender() != null) {
                                    if(ar.getAnimal().getGender().equals("M")) {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    
    public float getBreedCount() {
        float count = 0;
        for (NetworkDetails network : new NetworkDetails().getNetworkList()) {
            for (EnterpriseDetails enterprise : network.getEnterpriseDirectory()) {
                if(enterprise instanceof RescueCenterEntDetails) {
                    for(OrganisationMain org: enterprise.getOrganisationDirectory()) {
                        if(org instanceof AdoptionOrganisation) {
                            for(AdoptRecord ar: ((AdoptionOrganisation) org).getAdoptionRecordDirectory()) {
                                AnimalDetails a = ar.getAnimal();
                                if(a.getType().equals(AnimalDetails.AnimalType.Dog)) {
                                    if(!((DogDetails)a).getBreed().equals("None")) {
                                        count++;
                                    }
                                }
                                else if(a.getType().equals(AnimalDetails.AnimalType.Cat)) {
                                    if(!((CatDetails)a).getBreed().equals("None")) {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPercentage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAdoptions = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAdopters = new javax.swing.JLabel();
        lblanalyzeadoptions = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTypes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setBackground(new java.awt.Color(204, 204, 255));
        backJButton.setText("Previous");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 660, 93, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel4.setText("Percentage of Adopted Animal:");

        lblPercentage.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblPercentage.setText("<Value>");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel2.setText("Total Applied Adoptions:");

        lblAdoptions.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblAdoptions.setText("<Value>");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel3.setText("Total Number of Adopters:");

        lblAdopters.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblAdopters.setText("<Value>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 123, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAdoptions, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(lblAdopters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPercentage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAdoptions)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdopters)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPercentage)
                    .addComponent(jLabel4))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 587, -1));

        lblanalyzeadoptions.setBackground(new java.awt.Color(255, 255, 255));
        lblanalyzeadoptions.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblanalyzeadoptions.setForeground(new java.awt.Color(153, 204, 255));
        lblanalyzeadoptions.setText("ADOPTIONS ANALYSIS");
        add(lblanalyzeadoptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ANIMAL STATUS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 15), new java.awt.Color(255, 51, 51))); // NOI18N

        tblTypes.setBackground(new java.awt.Color(204, 204, 255));
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
        tblTypes.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(tblTypes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Analysis.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1930, 1090));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdopters;
    private javax.swing.JLabel lblAdoptions;
    private javax.swing.JLabel lblPercentage;
    private javax.swing.JLabel lblanalyzeadoptions;
    private javax.swing.JTable tblTypes;
    // End of variables declaration//GEN-END:variables
}
