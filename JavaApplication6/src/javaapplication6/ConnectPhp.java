/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
/**
 *
 * @author ypilav
 */
public class ConnectPhp {
   public static void main(String[] args) throws IOException {
 try {
                    InetAddress inetAddress = InetAddress.getByName("www.gmail.com");
                    System.out.println("ip:"+inetAddress.getHostAddress());
                    System.out.print(inetAddress.getHostName());
			URL url = new URL("http://localhost/antiphishing/tt.php?ip="+inetAddress.getHostAddress());
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = "";
			while (null != (str = br.readLine())) {
				System.out.println(str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    
}
}
