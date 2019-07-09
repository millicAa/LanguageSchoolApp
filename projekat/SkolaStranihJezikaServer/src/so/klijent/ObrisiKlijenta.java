/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.PrijavaZaKurs;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
public class ObrisiKlijenta extends OpstaSistemskaOperacija{

    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {
            
            DBBroker.getInstance().delete(odo);
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je obrisao klijenta");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Sistem ne moze da obrise klijenta");
        }
        return transferObjekat;
    }

    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
       
    }
    
    
}
