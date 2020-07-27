/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ypila
 */
public class Registration extends javax.swing.JFrame {

    /**
     * Creates new form Registration
     */
    public Registration() {
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

        r_fname_text = new javax.swing.JTextField();
        r_lname_text = new javax.swing.JTextField();
        r_firstname = new javax.swing.JLabel();
        r_lastname = new javax.swing.JLabel();
        r_email = new javax.swing.JLabel();
        r_email_text = new javax.swing.JTextField();
        r_pwd = new javax.swing.JLabel();
        r_cpwd = new javax.swing.JLabel();
        r_submit = new javax.swing.JButton();
        r_reset = new javax.swing.JButton();
        r_pass = new javax.swing.JPasswordField();
        r_cpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(r_fname_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 47, 163, -1));

        r_lname_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_lname_textActionPerformed(evt);
            }
        });
        getContentPane().add(r_lname_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 98, 163, -1));

        r_firstname.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r_firstname.setText("First Name");
        getContentPane().add(r_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 50, -1, -1));

        r_lastname.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r_lastname.setText("Last Name");
        getContentPane().add(r_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 101, -1, -1));

        r_email.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r_email.setText("Email-Id");
        getContentPane().add(r_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 161, -1, -1));
        getContentPane().add(r_email_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 158, 163, -1));

        r_pwd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r_pwd.setText("Password");
        getContentPane().add(r_pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 201, -1, -1));

        r_cpwd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r_cpwd.setText("Confirm password");
        getContentPane().add(r_cpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 236, -1, -1));

        r_submit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r_submit.setText("Submit");
        r_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_submitActionPerformed(evt);
            }
        });
        getContentPane().add(r_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 283, -1, -1));

        r_reset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r_reset.setText("Reset");
        r_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_resetActionPerformed(evt);
            }
        });
        getContentPane().add(r_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 283, -1, -1));
        getContentPane().add(r_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 195, 163, -1));
        getContentPane().add(r_cpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 233, 163, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("REGISTRATION");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 11, 161, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(846, 13, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/newpackage/global_logo_.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r_lname_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_lname_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_lname_textActionPerformed

    private void r_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_resetActionPerformed
        // TODO add your handling code here
        r_fname_text.setText("");
        r_lname_text.setText("");
        r_cpass.setText("");
        r_pass.setText("");
        r_email_text.setText("");
    }//GEN-LAST:event_r_resetActionPerformed

    private void r_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_submitActionPerformed
        // TODO add your handling code here:
      String fname=  r_fname_text.getText();
      String lname=  r_lname_text.getText();
      String confirmpass = r_cpass.getText();
      String pwd= r_pass.getText();
      String email= r_email_text.getText();
      Component frame = null;
      String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\ @([\\w]+\\.)+[\\w]+[\\w]$";
     String Email_reg= "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";// - See more at: http://www.java2novice.com/java-collections-and-util/regex/valid-email-address/#sthash.rjZeh4wS.dpuf
      Boolean b =email.matches(Email_reg);
      
      if("".equals(fname)) 
      {
          
            JOptionPane.showMessageDialog(frame,"Enter Firstname");
       
      }
      else
      {
          if("".equals(lname))
          {
            JOptionPane.showMessageDialog(frame,"Enter lastname");  
          }
          else
          {
              if("".equals(email))
              {
                  
                  JOptionPane.showMessageDialog(frame,"Enter email");
                  
             }
              else
              {
                 if(b==false)
                  {
                   JOptionPane.showMessageDialog(frame,"Enter Correct email");
                  }
                 else
                 {
                  if("".equals(pwd))
                  {
                      JOptionPane.showMessageDialog(frame,"Enter password");
                  }
                  else
                  {
                      if("".equals(confirmpass))
                      {
                          JOptionPane.showMessageDialog(frame,"Enter Confirm password");
                      }
                      else{
                         if(!pwd.equals(confirmpass))
                         {
                             JOptionPane.showMessageDialog(frame,"password does not match");
                         }
                         else{
                             
      Statement stmt = null;
        try 
        {
            String url = "jdbc:mysql://127.0.0.1:3306/";
            String dbName = "antiphishing";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String dbpassword = "";
            Class.forName(driver);
            // Connection set up with database named as user
            Connection c = DriverManager.getConnection(url+dbName,userName,dbpassword);
            // Creating statement for the connection to use sql queries
           // Statement st = c.createStatement();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "INSERT INTO REGISTER (email,password,fname,lname) "
               + "VALUES ('"+email+"','"+pwd+"','"+fname+"','"+lname+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } 
        catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
                             new Login().setVisible(true);
                             setVisible(false);
                         }
        
                      }
                  }
              }
          }
          }
      }
        
        
    }//GEN-LAST:event_r_submitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                Login l = new Login();
                 l.setVisible(true);
                 setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField r_cpass;
    private javax.swing.JLabel r_cpwd;
    private javax.swing.JLabel r_email;
    private javax.swing.JTextField r_email_text;
    private javax.swing.JLabel r_firstname;
    private javax.swing.JTextField r_fname_text;
    private javax.swing.JLabel r_lastname;
    private javax.swing.JTextField r_lname_text;
    private javax.swing.JPasswordField r_pass;
    private javax.swing.JLabel r_pwd;
    private javax.swing.JButton r_reset;
    private javax.swing.JButton r_submit;
    // End of variables declaration//GEN-END:variables
}