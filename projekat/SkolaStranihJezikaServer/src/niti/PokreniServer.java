/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milica
 */
public class PokreniServer extends Thread{
    
    ServerskaForma sf;
    boolean kraj=false;
    ServerSocket ss;
    ArrayList<Socket> ls;

    public PokreniServer(ServerskaForma sf) {
        this.sf = sf;
        ls= new ArrayList<>();
    }
    @Override
    public void run() {
        
        try {
             ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut.");
            while(!kraj) {
            
                Socket s =ss.accept();
                ls.add(s);
                System.out.println("Klijent se povezao.");
                ObradiZahtevKlijenta ozk = new ObradiZahtevKlijenta(this,s);
                ozk.start();
            
            }
        } catch (IOException ex) {
            System.out.println("Server je zaustavljen");
            
           // Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//    public boolean zatvoreniSoketi(){
//    
//        for (Socket soket : ls) {
//            if(!soket.isClosed()) 
//                return false;
//        }
//        return true;
//    }
    
    public void zaustavi() throws IOException  {
        
        kraj=true;
       
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
