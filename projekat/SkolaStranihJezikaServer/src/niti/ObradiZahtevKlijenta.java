/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import kolekcije.UlogovaniKorisnici;
import konstante.Konstante;
import logika.Kontroler;
import transfer.KlijentskiTransferObjekat;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Milica
 */
class ObradiZahtevKlijenta extends Thread {

    Socket s;
    boolean kraj = false;
    PokreniServer ps;

    public ObradiZahtevKlijenta(PokreniServer ps, Socket s) {
        this.s = s;
        this.ps = ps;
    }

    @Override
    public void run() {

        while (!kraj) {

            KlijentskiTransferObjekat kto = primiZahtev();
            ServerskiTransferObjekat sto = new ServerskiTransferObjekat();
            OpstiDomenskiObjekat odo = kto.getParametar();

            switch (kto.getOperacija()) {
                case Konstante.LOGOVANJE:
                    sto = Kontroler.getInstance().prijaviKorisnika(odo);
                    break;
                case Konstante.VRATI_MESTA:
                    sto = Kontroler.getInstance().vratiListuMesta(odo);
                    break;
                case Konstante.SACUVAJ_KLIJENTA:
                    sto = Kontroler.getInstance().sacuvajKlijenta(odo);
                    break;
                case Konstante.VRATI_KLIJENTE:
                    sto = Kontroler.getInstance().vratiListuKlijenata(odo);
                    break;
                case Konstante.IZMENI_KLIJENTA:
                    sto = Kontroler.getInstance().izmeniKlijenta(odo);
                    break;
                case Konstante.OBRISI_KLIJENTA:
                    sto = Kontroler.getInstance().obrisiKlijenta(odo);
                    break;
                case Konstante.IZLOGUJ_KORISNIKA:
                    UlogovaniKorisnici.getInstanca().obrisiKorisnika((Korisnik) odo);
                    kraj = true;
                    sto.setPoruka("Uspesno izlogovan korisnik.");
                    break;
                case Konstante.SACUVAJ_KURS:
                    sto = Kontroler.getInstance().sacuvajKurs(odo);
                    break;
                case Konstante.VRATI_KURSEVE:
                    sto= Kontroler.getInstance().vratiKurseve(odo);
                    break;
                case Konstante.IZMENI_KURS:
                    sto= Kontroler.getInstance().izmeniKurs(odo);
                    break;
                case Konstante.VRATI_PRIJAVE:
                    sto=Kontroler.getInstance().vratiPrijave(odo);
                    break;
                case Konstante.SACUVAJ_PRIJAVU:
                    sto= Kontroler.getInstance().sacuvajPrijavu(odo);
                    break;
                case Konstante.IZMENI_PRIJAVU:
                    sto= Kontroler.getInstance().izmeniPrijavu(odo);
                    break;
                    
            }
            posalji(sto);

        }

    }

    public void posalji(ServerskiTransferObjekat sto) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(sto);
        } catch (IOException ex) {
            Logger.getLogger(ObradiZahtevKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public KlijentskiTransferObjekat primiZahtev() {

        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            kto = (KlijentskiTransferObjekat) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradiZahtevKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradiZahtevKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return kto;
    }

}
