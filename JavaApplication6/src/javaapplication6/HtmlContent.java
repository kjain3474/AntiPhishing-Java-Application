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
import javax.swing.JEditorPane; 
import javax.swing.JFrame;
import javaapplication6.*;
import static javaapplication6.MailFetch.mail;
import static javaapplication6.MailFetch.pmail;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
public class HtmlContent extends JFrame 
{ 
    public static void main(String args[]) 
{       int sel = 0 ;
String s ="newclass";
  HtmlContent htmlContent = new HtmlContent(sel,s); 
} 
HtmlContent(int sel,String clas) 
{ 
    String html ="";
            try { 
    if(clas.equals("newclass1"))
   html =pmail[sel];
    else
        html=mail[sel];
    
    JEditorPane ed1=new JEditorPane("text/html",html); 
    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

JScrollPane jp = new JScrollPane(ed1,v,h);
    add(jp);
    setVisible(true); 
    setSize(600,600); 
    
    //setDefaultCloseOperation(new maildisplay().display(sel,"newclass")); 
} 
catch(Exception e) {
    e.printStackTrace(); 
System.out.println("Some problem has occured"+e.getMessage()); } } }


