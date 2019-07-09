/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.prijava;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.PrijavaZaKurs;
import domen.StavkaPrijave;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
public class IzmeniPrijavu extends OpstaSistemskaOperacija{

    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {
            
            DBBroker.getInstance().update(odo);
            PrijavaZaKurs p =(PrijavaZaKurs) odo;
            for(StavkaPrijave stavka : p.getStavke()) {
            
                DBBroker.getInstance().update(stavka);
            
            }
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je izmenio prijavu");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Sistem ne moze da izmeni prijavu");
        }
        return transferObjekat;
    }

    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }
    
}
