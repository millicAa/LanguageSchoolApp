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
public class Kurs implements Serializable, OpstiDomenskiObjekat{
    
    private int kursID;
    private String naziv;
    private Nivo nivo;
    private double cena;
    private int brojCasova;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private int maksimalanBrKlijenata;

    public Kurs() {
    }

    public Kurs(int kursID, String naziv, Nivo nivo, double cena, int brojCasova, Date datumPocetka, Date datumZavrsetka, int maksimalanBrKlijenata) {
        this.kursID = kursID;
        this.naziv = naziv;
        this.nivo = nivo;
        this.cena = cena;
        this.brojCasova = brojCasova;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.maksimalanBrKlijenata = maksimalanBrKlijenata;
    }

    public int getKursID() {
        return kursID;
    }

    public void setKursID(int kursID) {
        this.kursID = kursID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Nivo getNivo() {
        return nivo;
    }

    public void setNivo(Nivo nivo) {
        this.nivo = nivo;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(int brojCasova) {
        this.brojCasova = brojCasova;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public int getMaksimalanBrKlijenata() {
        return maksimalanBrKlijenata;
    }

    public void setMaksimalanBrKlijenata(int maksimalanBrKlijenata) {
        this.maksimalanBrKlijenata = maksimalanBrKlijenata;
    }

    @Override
    public String vratiNazivTabele() {
        return " kurs ";
    }

    @Override
    public String vratiNaziveKolona() {
        return "Naziv, Nivo, Cena, BrojCasova, DatumPocetka, DatumZavrsetka, MaksimalanBrKlijenata";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'" + naziv + "','" + nivo + "','" + cena + "','" +brojCasova + "','" + new java.sql.Date(datumPocetka.getTime()) + "','" + new java.sql.Date(datumZavrsetka.getTime()) + "','" + maksimalanBrKlijenata +"'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "Naziv= '"+naziv+"' , Nivo= '"+nivo+"' , Cena= "+cena+" , BrojCasova= "+brojCasova+" , DatumPocetka= '"+new java.sql.Date(datumPocetka.getTime())+"' , DatumZavrsetka= '"+new java.sql.Date(datumZavrsetka.getTime())+"' , MaksimalanBrKlijenata= "+maksimalanBrKlijenata;
    }

    @Override
    public String vratiWhereUslov() {
        return "KursID="+kursID;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "ku";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
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
        List<OpstiDomenskiObjekat> kursevi= new ArrayList<>();
        while(rs.next()) {
            Nivo n = Nivo.valueOf(rs.getString("Nivo"));
            kursevi.add(new Kurs(rs.getInt("KursID"), rs.getString("Naziv"), n, rs.getDouble("Cena"), rs.getInt("BrojCasova"), new Date(rs.getDate("DatumPocetka").getTime()), new Date(rs.getDate("DatumZavrsetka").getTime()), rs.getInt("MaksimalanBrKlijenata")));
        }
        return kursevi;
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
        final Kurs other = (Kurs) obj;
        if (this.kursID != other.kursID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv+" "+nivo;
    }

    
    
}
