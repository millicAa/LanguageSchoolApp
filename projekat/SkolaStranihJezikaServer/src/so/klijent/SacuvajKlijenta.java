/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
public class SacuvajKlijenta extends OpstaSistemskaOperacija {
    
    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {
            
            DBBroker.getInstance().insert(odo);
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je zapamtio klijenta");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Sistem ne moze da zapamti klijenta");
        }
        return transferObjekat;
    }
    
    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }
}
