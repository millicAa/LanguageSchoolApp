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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Milica
 */
public class Klijent implements Serializable, OpstiDomenskiObjekat {

    private int klijentID;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private Mesto mesto;

    public Klijent() {
    }

    public Klijent(int klijentID, String ime, String prezime, Date datumRodjenja, Mesto mesto) {
        this.klijentID = klijentID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.mesto = mesto;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String vratiNazivTabele() {
        return "klijent";
    }

    @Override
    public String vratiNaziveKolona() {
        return "Ime, Prezime, DatumRodjenja, MestoID";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'" + ime + "','" + prezime + "','" + new java.sql.Date(datumRodjenja.getTime()) + "'," + mesto.getMestoID();

    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " Ime='" + ime + "',Prezime='" + prezime + "',DatumRodjenja='" + new java.sql.Date(datumRodjenja.getTime()) + "',MestoID=" + mesto.getMestoID();

    }

    @Override
    public String vratiWhereUslov() {
        return "KlijentID="+klijentID;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return " * ";
    }

    @Override
    public String vratiAlijas() {
        return " kl ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join Mesto m on kl.mestoID=m.mestoID ";
    }

    @Override
    public String vratiWhereUslovSelect() {
        if(ime!=null && prezime!= null ){
            return " where ime LIKE '%"+ime+"%' OR prezime LIKE '%"+prezime+"%' ";
        }
        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> klijenti= new ArrayList<>();
        while(rs.next()) {
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getString("Naziv"), rs.getInt("PostanskiBroj"));
            klijenti.add(new Klijent(rs.getInt("KlijentID"), rs.getString("Ime"), rs.getString("Prezime"), new java.util.Date(rs.getDate("DatumRodjenja").getTime()), m));
        }
        return klijenti;
    }

    @Override
    public String vratiMaxPrimarni() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klijent other = (Klijent) obj;
        if (this.klijentID != other.klijentID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    
}
