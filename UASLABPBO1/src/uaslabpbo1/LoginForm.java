/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uaslabpbo1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fransisca
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        DBConnector.initDBConnection();
        initComponents();
    }
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_username = new javax.swing.JTextField();
        tf_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_username.setBackground(new java.awt.Color(253, 206, 4));
        tf_username.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        tf_username.setText("Username");
        tf_username.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tf_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_usernameFocusLost(evt);
            }
        });
        getContentPane().add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 340, 50));

        tf_password.setBackground(new java.awt.Color(253, 206, 4));
        tf_password.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        tf_password.setText("Password");
        tf_password.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tf_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_passwordFocusLost(evt);
            }
        });
        getContentPane().add(tf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 340, 50));

        btn_login.setBackground(new java.awt.Color(253, 206, 4));
        btn_login.setFont(new java.awt.Font("Segoe Script", 3, 24)); // NOI18N
        btn_login.setText("Log In");
        btn_login.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 589, 190, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String uss = tf_username.getText();
        String pass = tf_password.getText();
        
       try{
           DBConnector.initDBConnection();
            Statement stmt = DBConnector.connection.createStatement();
            String sql = "SELECT * FROM login Where username = '"+uss+"' AND password = '"+pass+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
               JOptionPane.showMessageDialog(this, "Berhasil Login");
               DetailMenu frame = new DetailMenu();
               frame.setVisible(true);
               this.dispose();
            } else{
                 JOptionPane.showMessageDialog(this, "Username atau Password salah","Gagal Login",JOptionPane.ERROR_MESSAGE);
            }
       } catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
           
       }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void tf_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_usernameFocusGained
        String uss = tf_username.getText();
        if(uss.equals("Username")){
            tf_username.setText("");
        }
    }//GEN-LAST:event_tf_usernameFocusGained

    private void tf_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_usernameFocusLost
        String uss = tf_username.getText();
        if(uss.equals("")){
            tf_username.setText("Username");
        }
    }//GEN-LAST:event_tf_usernameFocusLost

    private void tf_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_passwordFocusGained
        String uss = tf_password.getText();
        if(uss.equals("Password")){
            tf_password.setText("");
        }
    }//GEN-LAST:event_tf_passwordFocusGained

    private void tf_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_passwordFocusLost
        String uss = tf_password.getText();
        if(uss.equals("")){
            tf_password.setText("Password");
        }
    }//GEN-LAST:event_tf_passwordFocusLost

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}