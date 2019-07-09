/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kurs;

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
public class VratiListuKurseva extends OpstaSistemskaOperacija{

    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        
         ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {
            
            List<OpstiDomenskiObjekat> lista = odo.ucitajListu(DBBroker.getInstance().select(odo));
            
            if(lista.isEmpty())
                throw new Exception("Nema unetih kurseva");
            transferObjekat.setOdgovor(lista);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Uspesno ucitana lista kurseva");
            
        } catch (Exception ex) {
            Logger.getLogger(VratiListuKurseva.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nije moguce prikazati podatke o kursevima");
        }
        return transferObjekat;
    }

    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }
    
}
