/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.OpstiDomenskiObjekat;
import so.klijent.IzmeniKlijenta;
import so.klijent.ObrisiKlijenta;
import so.klijent.SacuvajKlijenta;
import so.korisnik.UlogujKorisnikaSO;
import so.mesta.VratiListuMesta;
import transfer.ServerskiTransferObjekat;
import so.kurs.SacuvajKurs;
import so.kurs.VratiListuKurseva;
import so.kurs.IzmeniKurs;
import so.prijava.VratiPrijave;
import so.prijava.IzmeniPrijavu;
import so.prijava.SacuvajPrijavu;

/**
 *
 * @author Milica
 */
public class Kontroler {
    
    private static Kontroler instance;
    
    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }

    public ServerskiTransferObjekat prijaviKorisnika(OpstiDomenskiObjekat odo) {
        return new UlogujKorisnikaSO().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat vratiListuMesta(OpstiDomenskiObjekat odo) {
        return new VratiListuMesta().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat sacuvajKlijenta(OpstiDomenskiObjekat odo) {
        return new SacuvajKlijenta().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat vratiListuKlijenata(OpstiDomenskiObjekat odo) {
        return new VratiListuMesta().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat izmeniKlijenta(OpstiDomenskiObjekat odo) {
        return new IzmeniKlijenta().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat obrisiKlijenta(OpstiDomenskiObjekat odo) {
        return new ObrisiKlijenta().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat sacuvajKurs(OpstiDomenskiObjekat odo) {
        return new SacuvajKurs().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat vratiKurseve(OpstiDomenskiObjekat odo) {
        return new VratiListuKurseva().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat vratiPrijave(OpstiDomenskiObjekat odo) {
        return new VratiPrijave().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat sacuvajPrijavu(OpstiDomenskiObjekat odo) {
        return new SacuvajPrijavu().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat izmeniPrijavu(OpstiDomenskiObjekat odo) {
        return new IzmeniPrijavu().IzvrsiTransakciju(odo);
    }

    public ServerskiTransferObjekat izmeniKurs(OpstiDomenskiObjekat odo) {
        return new IzmeniKurs().IzvrsiTransakciju(odo);
    }

    

    
    
}
