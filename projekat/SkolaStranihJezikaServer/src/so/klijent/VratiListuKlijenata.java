/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
public class VratiListuKlijenata extends OpstaSistemskaOperacija{

    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        
        ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {
            
            List<OpstiDomenskiObjekat> lista = odo.ucitajListu(DBBroker.getInstance().select(odo));
            
            if(lista.isEmpty())
                throw new Exception("Nema unetih klijenata");
            transferObjekat.setOdgovor(lista);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Uspesno ucitana lista klijenata");
            
        } catch (Exception ex) {
            Logger.getLogger(VratiListuKlijenata.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nije moguce prikazati podatke o klijentima");
        }
        return transferObjekat;
    }

    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
