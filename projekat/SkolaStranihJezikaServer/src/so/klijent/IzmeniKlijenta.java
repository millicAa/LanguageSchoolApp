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
public class IzmeniKlijenta extends OpstaSistemskaOperacija{

    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        
        ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {
            
            DBBroker.getInstance().update(odo);
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je izmenio klijenta");
            
        } catch (Exception ex) {
            
            throw new Exception("Sistem ne moze da izmeni klijenta");
        }
        return transferObjekat;
    }

    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }
    
}
