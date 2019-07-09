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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
public class VratiPrijave extends OpstaSistemskaOperacija{

    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
         ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {
            
            List<OpstiDomenskiObjekat> lista = odo.ucitajListu(DBBroker.getInstance().select(odo));
            if(lista.isEmpty())
                throw new Exception("Nema unetih prijava");
            ArrayList<PrijavaZaKurs> listaPrijava= new ArrayList<>();
            
            for (OpstiDomenskiObjekat od : lista) {
                
                ArrayList<StavkaPrijave> listaStavki = new ArrayList<>();
                PrijavaZaKurs p = (PrijavaZaKurs) od;
                StavkaPrijave sp = new StavkaPrijave(0, p, 0, null);
                List<OpstiDomenskiObjekat> listaSt = sp.ucitajListu(DBBroker.getInstance().select(sp));
                
                for (OpstiDomenskiObjekat stavka : listaSt) {
                    StavkaPrijave stav= (StavkaPrijave) stavka;
                    stav.setPrijava(p);
                    listaStavki.add(stav);
                }
                
                p.setStavke(listaStavki);
                listaPrijava.add(p);
                
            }
            
            
            transferObjekat.setOdgovor(listaPrijava);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Uspesno ucitana lista prijava");
            
        } catch (Exception ex) {
            Logger.getLogger(VratiPrijave.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nije moguce prikazati podatke o prijava");
        }
        return transferObjekat;
    }

    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }
    
}
