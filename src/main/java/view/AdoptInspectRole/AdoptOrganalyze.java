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
import model.AdoptDetails.AdopterDetails;
import model.Animal.AnimalDetails;
import model.Animal.CatDetails;
import model.Animal.DogDetails;
import model.Enterprises.RescueCenterEntDetails;
import model.Organisation.AdoptionOrganisation;
import model.UserAccount.UserAccount;

/**
 *
 * @author sejal
 */
public class AdoptOrganalyze extends javax.swing.JPanel {

    /**
     * Creates new form AdoptOrganalyze
     */
    
    private JPanel container;
    private RescueCenterEntDetails enterprise;
    private AdoptionOrganisation organization;
    private UserAccount userAccount;
    
    public AdoptOrganalyze(JPanel container, RescueCenterEntDetails enterprise, AdoptionOrganisation organization, UserAccount userAccount) {
        initComponents();
        this.container = container;
        this.enterprise = (RescueCenterEntDetails)enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        
        populateValues();
        populateTypeTable();
    }
    
    private void populateValues() {
        lblAdoptions.setText(String.valueOf(getTotalAdoptions()));
        lblAdopters.setText(String.valueOf(getAdoptersCount()));
        lblPercentage.setText(String.valueOf((getAdoptedCount() / getTotalValue()) * 100) + "%");
    }
    
    private void populateTypeTable() {
        DefaultTableModel model = (DefaultTableModel) tblTypes.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        row[0] = "Dogs";
        row[1] = (getDogCount() / getTotalAdoptions()) * 100 + "%";
        model.addRow(row);
        
        row[0] = "Male";
        row[1] = (getMaleCount() / getTotalAdoptions()) * 100 + "%";
        model.addRow(row);
        
        row[0] = "Has Breed";
        row[1] = (getBreedCount() / getTotalAdoptions()) * 100 + "%";
        model.addRow(row);
    }
    
    public int getTotalAdoptions() {
        int count = 0;
        for(AdoptRecord ar: organization.getAdoptionRecordDirectory()) {
            count++;
        }
        return count;
    }
    
    public int getAdoptersCount() {
        int count = 0;
        for(AdopterDetails a: organization.getAdopterDirectory()) {
            count++;
        }
        return count;
    }
    
    public float getAdoptedCount() {
        float count = 0;
        for(AnimalDetails a: enterprise.getAnimalDirectory()) {
            if(a.getStatus().equals(AnimalDetails.Status.ADOPTED)) {
                count++;
            }
        }
        return count;
    }
    
    public int getTotalValue() {
        int sum = 0;
        sum += enterprise.getRecordDirectory().size();
           
        return sum;
    }
    
    
    public float getDogCount() {
        float count = 0;
        for(AdoptRecord ar: organization.getAdoptionRecordDirectory()) {
            if(ar.getAnimal().getType().equals(AnimalDetails.AnimalType.Dog)) {
                count++;
            }
        } 
        return count;
    }
    
    public float getMaleCount() {
        float count = 0;
        for(AdoptRecord ar: organization.getAdoptionRecordDirectory()) {
            if(ar.getAnimal().getGender() != null) {
                if(ar.getAnimal().getGender().equals("M")) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public float getBreedCount() {
        float count = 0;
        for(AdoptRecord ar: organization.getAdoptionRecordDirectory()) {
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

        lblAdoption = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblAdoptionApplied = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        lblPercentageadoption = new javax.swing.JLabel();
        lblPercentage = new javax.swing.JLabel();
        lblAdopters = new javax.swing.JLabel();
        lblAdoptions = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTypes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 51, 51));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAdoption.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblAdoption.setForeground(new java.awt.Color(255, 51, 51));
        lblAdoption.setText("ADOPTION ANALYSIS");
        add(lblAdoption, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        btnBack.setForeground(new java.awt.Color(255, 51, 51));
        btnBack.setText("Previous");
        btnBack.setToolTipText("");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, -1, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAdoptionApplied.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblAdoptionApplied.setText("Total Adoptions Applications:");

        lblQty.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQty.setText("Total number of Adopters:");

        lblPercentageadoption.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblPercentageadoption.setText("Animal Adopted in percentage:");

        lblPercentage.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblPercentage.setText("<Value>");

        lblAdopters.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblAdopters.setText("<Value>");

        lblAdoptions.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblAdoptions.setText("<Value>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblAdoptionApplied, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPercentageadoption, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblAdopters, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdoptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdoptionApplied)
                    .addComponent(lblAdoptions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQty)
                    .addComponent(lblAdopters))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPercentage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPercentageadoption))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status of Animal", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 15), new java.awt.Color(255, 51, 51))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_2.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1930, 1090));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdopters;
    private javax.swing.JLabel lblAdoption;
    private javax.swing.JLabel lblAdoptionApplied;
    private javax.swing.JLabel lblAdoptions;
    private javax.swing.JLabel lblPercentage;
    private javax.swing.JLabel lblPercentageadoption;
    private javax.swing.JLabel lblQty;
    private javax.swing.JTable tblTypes;
    // End of variables declaration//GEN-END:variables
}
