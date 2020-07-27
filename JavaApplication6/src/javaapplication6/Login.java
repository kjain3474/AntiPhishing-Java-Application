/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.awt.Color;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author ypila
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
     setSize(500,400);
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

        jLabel1 = new javax.swing.JLabel();
        label_userid = new javax.swing.JLabel();
        user_id = new javax.swing.JTextField();
        register = new javax.swing.JButton();
        Label_password = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        l_fp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 116, -1));

        label_userid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_userid.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_userid.setText("User ID");
        getContentPane().add(label_userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 50, 27));

        user_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_idActionPerformed(evt);
            }
        });
        getContentPane().add(user_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 145, 30));

        register.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        register.setText("REGISTER");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 110, -1));

        Label_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Label_password.setText("Password");
        getContentPane().add(Label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 70, 33));

        signup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signup.setText("SIGN-IN");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, -1));

        l_fp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l_fp.setText("Forgot Password");
        l_fp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_fpActionPerformed(evt);
            }
        });
        getContentPane().add(l_fp, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel2.setText("Have Not signup Yet ?");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 180, 30));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 140, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/newpackage/global_logo_.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 380));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/newpackage/splash.gif"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 790, 380));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        // TODO add your handling code here:
        final String userid = user_id.getText();
        final String pass = password.getText();
        Component frame = null;
        if("".equals(userid) || "".equals(pass))
        {

            JOptionPane.showMessageDialog(frame,"Enter User ID and password");
        }
        else {
             
       Statement stmt = null;
       try {
            String url = "jdbc:mysql://127.0.0.1:3306/";
            String dbName = "antiphishing";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String dbpassword = "";
            Class.forName(driver);
            // Connection set up with database named as user
            Connection c = DriverManager.getConnection(url+dbName,userName,dbpassword);
            // Creating statement for the connection to use sql queries
             c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
                 ResultSet rs= stmt.executeQuery( "SELECT * FROM register WHERE email='"+userid+"'AND password='"+pass+"';");
                  
         if(rs.next())
         {
          new MailFetch(userid,pass);
          new MainUI(userid,pass).setVisible(true);
          setVisible(false);
          JOptionPane.showMessageDialog(frame, "LOGIN SUCCESSFUL");
         }
         else
         {
             JOptionPane.showMessageDialog(frame, "LOGIN UNSUCCESSFUL");
         }
         rs.close();
         stmt.close();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Operation done successfully");

            }
    }//GEN-LAST:event_signupActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        // TODO add your handling code here:
        
        new Registration().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_registerActionPerformed

    private void user_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_idActionPerformed

    private void l_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_fpActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ForgotPassword().setVisible(true);
    }//GEN-LAST:event_l_fpActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        //</editor-fold>
      //  JFrame frame = new JFrame();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               Login l = new Login();
                 l.setVisible(true);
                 
 
// adding created component to the JFrame using my backImage class
 
                 
            }
        });
    }
    public String userid = "";
     public  String pass = "";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_password;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton l_fp;
    private javax.swing.JLabel label_userid;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton register;
    private javax.swing.JButton signup;
    public javax.swing.JTextField user_id;
    // End of variables declaration//GEN-END:variables
    
}