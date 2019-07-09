/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milica
 */
public class PrijavaZaKurs implements Serializable, OpstiDomenskiObjekat {

    private int prijavaID;
    private double ukupanIznos;
    private Korisnik korisnik;
    private Klijent klijent;
    private ArrayList<StavkaPrijave> stavke;

    public PrijavaZaKurs() {
        stavke = new ArrayList<>();
    }

    public PrijavaZaKurs(int prijavaID, double ukupanIznos, Korisnik korisnik, Klijent klijent, ArrayList<StavkaPrijave> stavke) {
        this.prijavaID = prijavaID;
        this.ukupanIznos = ukupanIznos;
        this.korisnik = korisnik;
        this.klijent = klijent;
        this.stavke = stavke;
    }

    public ArrayList<StavkaPrijave> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaPrijave> stavke) {
        this.stavke = stavke;
    }

    public int getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(int prijavaID) {
        this.prijavaID = prijavaID;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    @Override
    public String vratiNazivTabele() {
        return "prijava";
    }

    @Override
    public String vratiNaziveKolona() {
        return "UkupanIznos, KorisnikID, KlijentID";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return ukupanIznos + ", " + korisnik.getKorisnikID() + ", " + klijent.getKlijentID();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "UkupanIznos=" + ukupanIznos + ", KorisnikID=" + korisnik.getKorisnikID() + ", KlijentID=" + klijent.getKlijentID();
    }

    @Override
    public String vratiWhereUslov() {
        return " PrijavaID=" + prijavaID;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "pr";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join korisnik ko on ko.KorisnikID=pr.KorisnikID join klijent kl on pr.KlijentID=kl.KlijentID join mesto m on m.MestoID=kl.MestoID";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> prijave = new ArrayList<>();
        while (rs.next()) {
            Korisnik korisnik = new Korisnik(rs.getInt("KorisnikID"), rs.getString("Username"), rs.getString("Password"));
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getString("Naziv"), rs.getInt("PostanskiBroj"));

            Klijent klijent = new Klijent(rs.getInt("KlijentID"), rs.getString("Ime"), rs.getString("Prezime"), new java.util.Date(rs.getDate("DatumRodjenja").getTime()), m);

            prijave.add(new PrijavaZaKurs(rs.getInt("PrijavaID"), rs.getDouble("UkupanIznos"), korisnik, klijent, null));
        }
        return prijave;

    }

    @Override
    public String vratiMaxPrimarni() {
        return "PrijavaID";
    }

}
