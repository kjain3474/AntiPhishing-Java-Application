
package javaapplication6;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import javax.mail.*;    
import java.net.InetAddress;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class MailFetch {
    Vector from = new Vector(10);
    Vector subject = new Vector(10);
    Vector date = new Vector(10);
    Vector msgs = new Vector(10);
    Vector type = new Vector(10);
    Vector pfrom = new Vector(10);
    Vector psubject = new Vector(10);
    Vector pdate = new Vector(10);
    Vector pmsgs = new Vector(10);
    Vector ptype = new Vector(10);
    boolean check;
    String url = "jdbc:mysql://127.0.0.1:3306/";
    String dbName = "antiphishing";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String dbpassword = "";
    Statement stmt = null;
    String words1[] = new String[20];
    
    private static final String IPADDRESS_PATTERN = 
		"^\\(?\\b(http://|www[.])([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*$";
    public static String  mail[] = new String[10];
    public static String  pmail[] = new String[10];
    
    //constructor used for fetcing mail from GMAIL also implementation of algorithm.     
    public MailFetch(String userid , String password) throws ClassNotFoundException, SQLException 
    {
        String emaild ="";
        int flag = 0;
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ypila\\Desktop\\chromedriver.exe");
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            // creating session for connecting with GMAIL
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com",userid,password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            
            //Looping for top 4 mails
            outer :for(int i=0;i<4;i++)
            { 
                int param=0;int found=0;
                //READING EMAILS
                Message msg = inbox.getMessage(inbox.getMessageCount()-i);
                Address[] in = msg.getFrom(); 
                for (Address address : in) 
                {
                    System.out.println("FROM:" + address.toString());
                }
                System.out.println("SENT DATE:" + msg.getSentDate());
                System.out.println("SUBJECT:" + msg.getSubject()); 
                System.out.println("c:" + msg.getContentType());
                System.out.println("----------------------------");
                System.out.println();
                emaild = in[0].toString();
                /* stmt = cn.createStatement();
                 String sql = "INSERT INTO MAIL (fr,subject,date,content,type) "+ "VALUES ('"+in[0].toString()+"','"+msg.getSubject()+"','"+msg.getSentDate()+"','"+"Hello"+"','"+msg.getContentType()+"');";
                 stmt.executeUpdate(sql);
                 System.out.println("UPDATED");

                 stmt.close();
                 cn.commit();*/
                String str="";
                String s="",Text="";
                //Check if msg has html content and print it
                if (msg.isMimeType("multipart/*"))
                {
                    Multipart mp = (Multipart) msg.getContent();
                    int count = mp.getCount();
                    s=writePart1(mp.getBodyPart(count-1));
                    System.out.println(s);
                    // msgs.add(s);
                    //get header domain 
                }   
                else
                {
                    System.out.println("Text Part");
                    Text=writePart(msg);
                    //msgs.add(Text);
                    System.out.println(Text);
                }
                ////////////////////////////////////
                //   ALGORITHM IMPLEMENTATION
                ////////////////////////////////
            
                /// Read Domain name of the user who sent the mail.
                if(in[0].toString().contains("<") && in[0].toString().contains(">"))
                {
                    int index=in[0].toString().indexOf('@');
                    int index1=in[0].toString().indexOf(">");
                    str=in[0].toString().substring(index+1,index1);
                    System.out.println(str);
                }
                else 
                {
                    int index = in[0].toString().indexOf('@');
                    str=in[0].toString().substring(index+1,in[0].toString().length()-1);
                    System.out.println(str);
                }
                int dotIndex[]=new int[3];
                int c=0;
                for(int a=0;a<str.length();a++)
                {
                    if(str.charAt(a)=='.')
                    {
                       dotIndex[c]=a;
                       c++;                      
                    }
                }
                if(c==2)
                {
                    str=str.substring(dotIndex[0]+1);
                }
                //get ip address
                InetAddress inetAddress = InetAddress.getByName("www."+str);
                System.out.println("IP adress : "+inetAddress.getHostAddress());
                //whitelisting
                String whitelist[]={"uber.com","google.com","accounts.google.com","youtube.com","facebook.com","ola.com","facebookmail.com","uber.com","myntra.com","flipkart.com","twitter.com","e.twitter.com"};
                // int flag=0;
                for (String whitelist1 : whitelist) 
                {
                    if (str.contains(whitelist1)) 
                    {
                        flag=1;
                        System.err.println("FLAG!!!");
                        break;
                        
                    }
                    else
                        flag=0;
                }
               
                //header
                if(flag==1)
                {
                    param = 0;
                    System.out.println("******************************");
                    System.out.println("Domain "+inetAddress.getHostName()+" is white listed");
                    System.out.println("******************************");
                    from.add(in[0].toString());
                    date.add(msg.getSentDate());
                    subject.add(msg.getSubject());
                    type.add(msg.getContentType());
                    msgs.add(s);
                    continue outer;        
                }
                else
                {
                
                // check black list  
                    check = checkBlacklist(inetAddress.getHostAddress());
                    System.out.println(check);
                    if(check == true)
                    {
                        System.out.println("******************************");
                        System.out.println("Domain "+inetAddress.getHostName()+" is black listed");
                        System.out.println("******************************");
                    }

                    System.out.println();
                    System.out.println("Printing links");
                    System.out.println();
                    String str1="";
                    ArrayList links = new ArrayList(); 
                    String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(s);
                    while(m.find()) 
                    {
                        String urlStr = m.group();
                        if (urlStr.startsWith("(") && urlStr.endsWith(")"))
                        {
                            urlStr = urlStr.substring(1, urlStr.length() - 1);
                        }
                        links.add(urlStr);
                    }
                    //Check for other conditions
                    for (Iterator it = links.iterator(); it.hasNext();) 
                    {
                        Object x = it.next();
                        String s1=(String)x;
                        System.out.println("s1 : "+s1);
                    
                        //for IP URL
                        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
                        Matcher matcher = pattern.matcher(s1);
                        if(matcher.find())
                        {
                            param+=1;
                            System.out.println("\"***************Phishing2**********\"");
                            //save in phishbox 
                            continue;
                        }
                        if(s1.contains("http") )
                        {
                            int index=s1.indexOf("http://");
                            System.out.println("index: "+index);
                            str1 = s1.substring(index+7,s1.indexOf('/', 8));
                            System.out.println("address: "+str1);
                        }
                        else if(s1.contains(inetAddress.getHostName()) )
                        {
                            str1=s1;
                        }
                        else //if(!s1.contains("http") && s1.contains("www"))
                        {
                            int index=s1.indexOf('/');
                            str1=s1.substring(0,index);
                            System.out.println("address: "+str1);
                        }
                        //special characters
                        String seq[]={"@","#","$","%","&","-","_","%"};
                        for(int j=0;j<seq.length;j++)
                        {
                            if(str1.contains(seq[j]))
                            {   
                                param+=1;
                                System.out.println("\"***************Phishing3**********\"");
                                //phisings   
                                continue;
                            }
                        }
                        //no. of dots in url >=3
                        int count1=0; 
                        for(int k=0;k<str1.length();k++)
                        {
                            if(str1.charAt(k)=='.')
                            {
                                count1++;
                            }
                        }
                        if(count1>=3)
                        {
                            param+=1;
                            System.out.println("\"***************Phishing4**********\"");
                            //phishing 
                            continue;
                        }
                        //contain phishing words
                        int count2=0;
//                        Class.forName(driver);            
//                        Connection c1 = DriverManager.getConnection(url+dbName,userName,dbpassword);
//            
//                        c1.setAutoCommit(false);
//                        System.out.println("Opened database successfully");
//
//                        stmt = c1.createStatement();
//                        ResultSet rs= stmt.executeQuery( "SELECT * FROM whitelist ;");
//                        
//                        int col=1;
//                        if(rs.next())
//                        {
//                            words1[col] = rs.getString("domain_name");
//                            System.out.println(words1[col]);
//                            col++;
//                        }
//                        rs.close();
//                        stmt.close();
//                        c1.close();
                        String words[]={"Update","Confirm","Client","Verify","Account","Login","Password","bank","Bank","CVV","Claim","reward","Customer","Credit","Debit","REWARD","Reward","authentication","Authentication"};
                        for(String matches: words)
                        {
                            if(s.contains(matches))
                            {
                                count2+=1;  
                            }
                        }
                        if(count2>=3)
                        {
                            param+=1;
                            System.out.println("\"***************Phishing5**********\"");
                            //phishing 
                            continue;
                        }
                        
                    }//for iteration
                    if(param==0)
                    {
                        //System.out.println("whiteLIST");
                        from.add(emaild);
                        date.add(msg.getSentDate());
                        subject.add(msg.getSubject());
                        type.add(msg.getContentType());
                        msgs.add(s);
                        System.out.println("NO PHISHIIIIINNGG");
                    }
                    else
                    {
                        pfrom.add(emaild);
                        pdate.add(msg.getSentDate());
                        psubject.add(msg.getSubject());
                        ptype.add(msg.getContentType());
                        pmsgs.add(s);
                        System.out.println(" PHISHIIIIINNGG");
                   }
                }//else flag = 0 check for conditions 
                ////////////
                System.out.println(i);
        }
             
            
            inbox.close(false);
            store.close();
            
        } catch (Exception mex) {
                mex.printStackTrace();
        }
        
        
        System.out.println("\n");
        System.out.println("output NO PHISHIIIIINNGG**********" + from.size());
        System.out.println("output NO PHISHIIIIINNGG**********" + pfrom.size()); 
        for(int i=0;i <from.size();i++)
        {
            System.out.println(from.elementAt(i) +"*****" + i);
            System.out.println("\n");
            mail[i] = msgs.elementAt(i).toString();
            //Connection cn = null;
            
            
            Class.forName(driver);
            // Connection set up with database named as user
            Connection c = DriverManager.getConnection(url+dbName,userName,dbpassword);
            stmt = c.createStatement();
            String sql = "INSERT INTO MAIL (mid,fr,subject,date,content) "+ "VALUES ("+i+",'"+from.elementAt(i)+"','"+subject.elementAt(i)+"','"+date.elementAt(i)+"','"+type.elementAt(i)+"');";
            stmt.executeUpdate(sql);         
            stmt.close();
           // c.commit();
            c.close();
        }
        for(int k=0;k <pfrom.size();k++)
        {
            System.out.println(pfrom.elementAt(k));            
            pmail[k] = pmsgs.elementAt(k).toString(); 
            
            Class.forName(driver);
            // Connection set up with database named as user
            Connection c = DriverManager.getConnection(url+dbName,userName,dbpassword);
            
            stmt = c.createStatement();
            String sql = "INSERT INTO PHISH (pid,fr,subject,date,content) "+ "VALUES ("+k+",'"+pfrom.elementAt(k)+"','"+psubject.elementAt(k)+"','"+pdate.elementAt(k)+"','"+ptype.elementAt(k)+"');";
            stmt.executeUpdate(sql); 
            stmt.close();
           // c.commit();
            c.close();
        
        } 
          
            
        
        
        
    }
    
     public static String writePart(Part p) throws Exception {
    return (String) p.getContent();
   }

    public static String writePart1(BodyPart bodyPart) throws Exception {
        
         Object o = bodyPart.getContent();
         return (String) o;
     }
    public static boolean checkBlacklist(String ip)
    {
        boolean value =false;
        try 
        {
            
            
            URL url = new URL("http://localhost/antiphishing/tt.php?ip="+ip);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while (null != (str = br.readLine())) 
                {
		System.out.println(str);
                if(str.toLowerCase().contains("list"))
                {
                    value= true;
                }
                else
                {
                  value = false;  
                }
                   // return false;
                }
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return value;
    }
    public static void main(String arg[]) throws ClassNotFoundException, SQLException
    {
        new MailFetch("antiphishing544@gmail.com","@ntiPhishing");
    }

}


 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    





   



    
    

