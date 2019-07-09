/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiTransferObjekat;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
public class Komunikacija {
    
    private static Komunikacija instanca;
    Socket s;

    private Komunikacija() {
        try {
            s = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Komunikacija getInstanca() {
        if(instanca == null)
            instanca = new Komunikacija();
        return instanca;
    }
    
    public void posaljiZahtev(KlijentskiTransferObjekat kto){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kto);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerskiTransferObjekat primiOdgovor(){
        ServerskiTransferObjekat sto = new ServerskiTransferObjekat();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            sto = (ServerskiTransferObjekat) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sto;
    }

    public Socket getS() {
        return s;
    }
    
}
