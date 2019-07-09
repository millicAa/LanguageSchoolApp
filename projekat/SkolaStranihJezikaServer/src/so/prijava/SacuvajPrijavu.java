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
public class SacuvajPrijavu extends OpstaSistemskaOperacija {

    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {

            DBBroker.getInstance().insert(odo);
            PrijavaZaKurs p = (PrijavaZaKurs) odo;
            p.setPrijavaID(DBBroker.getInstance().vratiID(odo));
            for (StavkaPrijave sp : p.getStavke()) {
                sp.setPrijava(p);
                DBBroker.getInstance().insert(sp);
            }
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je zapamtio prijavu");

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Sistem ne moze da zapamti prijavu");
        }
        return transferObjekat;
    }

    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }

}
