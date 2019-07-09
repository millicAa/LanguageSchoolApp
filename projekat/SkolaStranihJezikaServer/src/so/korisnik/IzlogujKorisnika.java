/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
public class IzlogujKorisnika {
    
    public ServerskiTransferObjekat IzvrsiOperaciju(OpstiDomenskiObjekat odo) {
    
        kolekcije.UlogovaniKorisnici.getInstanca().obrisiKorisnika((Korisnik) odo);
        ServerskiTransferObjekat sto = new ServerskiTransferObjekat();
        
        return sto;
    }

   
    
}
