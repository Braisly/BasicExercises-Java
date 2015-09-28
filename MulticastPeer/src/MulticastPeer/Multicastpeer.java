/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Multicastpeer;

/**
 *
 * @author Brais
 */
import MulticastPeer.Interfaz;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Multicastpeer{
public static void main(String[] args) throws UnknownHostException, IOException{ 
// args give message contents & destination multicast group (e.g. "228.5.6.7")

    
    InetAddress group = InetAddress.getByName("224.0.0.100");
    MulticastSocket s = new MulticastSocket(5000);
try {
    

    s.joinGroup(group);
    
    //Abrimos a interfaz
    Interfaz interfaz = new Interfaz(s,group); 
    interfaz.setVisible(true);

}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
}catch (IOException e){System.out.println("IO: " + e.getMessage());
}finally{
   }
}
}
