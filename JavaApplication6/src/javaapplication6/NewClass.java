/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author ypila
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javaapplication6.*;

public class NewClass extends JFrame implements ActionListener 
{
    int selected;
    Connection cn = null;
    Statement stmt = null; 
    ResultSet rs = null;
    JButton jb;
    NewClass() throws SQLException, ClassNotFoundException, Exception 
    {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        String head[] = new String [5]; 
        String data[][]=new String[30][5];
        jb = new JButton("click"); 
        try
        { 
            String url = "jdbc:mysql://127.0.0.1:3306/";
            String dbName = "antiphishing";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String dbpassword = "";
            Class.forName(driver);
            cn = DriverManager.getConnection(url+dbName,userName,dbpassword);
            cn.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt=cn.createStatement();
            String ab= jb.getText();
            System.out.println("heyyyyyyyyyyyy   "+ab);        
            stmt.execute("select * from mail");       
            rs = stmt.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cc= rsmd.getColumnCount();
            //String[] head = null;
            System.out.println("***********"+cc);
            for(int i = 1; i<=cc;i++)
            {        
                head[i-1]= rsmd.getColumnName(i);            
            }
            int row =0;
            while(rs.next())
            {
                for(int col = 0; col<cc;col++)
                {
                    data[row][col]= rs.getString(col+1);                
                }
                row++;            
            }
        }

        catch(Exception e)
        {
    
        }
        DefaultTableModel model = new DefaultTableModel(data,head);
        final JTable table = new JTable(model)
        {
            public boolean isCellEditable(int rowIndex, int colIndex) 
            {
                return false; //Disallow the editing of any cell
            }
        };
//JTable jt = new JTable(model);
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        JScrollPane jp = new JScrollPane(table,v,h);
        c.add(jp,BorderLayout.CENTER);
        c.add(jb,BorderLayout.EAST);
        jb.addActionListener((ActionListener) this);
        table.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
        
        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            String selectedData = null;
            //System.out.println("Selected: " );
            int[] selectedRow = table.getSelectedRows();
            int[] selectedColumns = table.getSelectedColumns();
            selected = table.getSelectedRow();        
            System.out.println("Sele: " + selected);
            try 
            {
                stmt.execute( "SELECT * FROM MAIL WHERE MID="+(selected+1)+";");
            } 
            catch (SQLException ex) {
              Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
       // ResultSet rs = null;  
            try 
            {
                rs = stmt.getResultSet();
            } 
            catch (SQLException ex) {
              Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            try 
            {
                while(rs.next())
                {
                    System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" ");
                }
              /*
              System.out.println("Sel " + selectedRow[0]);
              for (int i = 0; i < selectedRow.length; i++) {
              
              for (int j = 0; j < selectedColumns.length; j++) {
              selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
              }
              }
              System.out.println("Selected: " + selectedData);*/
            } 
            catch (SQLException ex) {
              Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });  
        System.out.println("Sele: " + selected);
        setSize(600,300);
        setVisible(true);
//cn.close();
/*table.setCellSelectionEnabled(true);
 if (table.getCellSelectionEnabled()) {
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      int rowIndex = table.getSelectedRow();
      int colIndex = table.getSelectedColumn();
    Component frame = null;
      JOptionPane.showMessageDialog(frame, rowIndex+ "&"+ colIndex);
    }*/
 
}
   
   public void actionPerformed(ActionEvent e)
    {         
        Object b = e.getSource();
            if(b==jb)
            {System.out.println("Selection: " + selected);
            maildisplay md =new maildisplay();
                md.display(selected,"newclass");
                md.setVisible(true);
                setVisible(false);
            }
             
    }
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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //JButton b = new JButton();
                    int i = 0;
                    int j =1;
                    new NewClass();
                } catch (SQLException ex) {
                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
