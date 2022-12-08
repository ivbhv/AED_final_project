/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Main;

import controller.Configure.PreConfigure;
import controller.Hibernate.HibernateController;
import model.AdoptDetails.AddressDetails;
import model.AdoptDetails.AdopterDetails;
import model.UserAccount.VisitorAccount;

/**
 *
 * @author vaibhav
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public static HibernateController controller = new HibernateController();
    public Main() {
        initComponents(); 
        PreConfigure.configure();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        valCreds = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(0, 0, 102));
        lblLogin.setText("Please Login ");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 97, -1, -1));

        lblUsername.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 102));
        lblUsername.setText("Username:");
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 169, -1, -1));

        lblPassword.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 102));
        lblPassword.setText("Password:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 212, -1, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 214, 227, -1));
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 171, 227, -1));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/The-bond-between-humans-and-dogs-dates-back-20000-years.jpg"))); // NOI18N
        jLabel1.setIgnoreRepaint(true);
        jLabel1.setInheritsPopupMenu(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        valCreds.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(valCreds, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 255, 227, 16));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        
//        HibernateController h = new HibernateController();
//        AddressDetails a = new AddressDetails("515", "Indore", "mp");
//        AdopterDetails ad = new AdopterDetails("123324", "Vaibhav", "Mahajan", "1234567892", a, "i.vaibhavmahajan@gmail.com");
//        h.saveObject(ad);
//        VisitorAccount va = new VisitorAccount("vbhv", "vbhv10", "i.vaibhavmahajan@gmail.com", ad);
//        
//        h.saveObject(va);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel valCreds;
    // End of variables declaration//GEN-END:variables
}
