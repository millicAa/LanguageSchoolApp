/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import db.DBBroker;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kolekcije.UlogovaniKorisnici;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
public class UlogujKorisnikaSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        
         ServerskiTransferObjekat transferObjekat = new ServerskiTransferObjekat();
        try {
           
            List<OpstiDomenskiObjekat> lista = odo.ucitajListu(DBBroker.getInstance().select(odo));
            if(lista.isEmpty())
                throw new Exception("Neuspesno prijavljivanje na sistem");
            transferObjekat.setOdgovor(lista);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Uspesno ste se prijavili na sistem");
            UlogovaniKorisnici.getInstanca().dodajKorisnika((Korisnik) odo);
            
            
        } catch (Exception ex) {
            Logger.getLogger(UlogujKorisnikaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno prijavljivanje na sistem");
        }
        return transferObjekat;
        }

    @Override
    public void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }
    }

    
    

