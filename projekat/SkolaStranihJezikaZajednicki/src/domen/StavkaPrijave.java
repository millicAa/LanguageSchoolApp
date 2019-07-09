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
public class StavkaPrijave implements OpstiDomenskiObjekat, Serializable {

    private int rbStavke;
    private PrijavaZaKurs prijava;
    private double cena;
    private Kurs kurs;

    public StavkaPrijave() {
    }

    public StavkaPrijave(int rbStavke, PrijavaZaKurs prijava, double cena, Kurs kurs) {
        this.rbStavke = rbStavke;
        this.prijava = prijava;
        this.cena = cena;
        this.kurs = kurs;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public PrijavaZaKurs getPrijava() {
        return prijava;
    }

    public void setPrijava(PrijavaZaKurs prijava) {
        this.prijava = prijava;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaprijave";
    }

    @Override
    public String vratiNaziveKolona() {
        return "RBStavke, PrijavaID, Cena, KursID";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return rbStavke + ", " + prijava.getPrijavaID() + ", " + cena + ", " + kurs.getKursID();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " RBStavke =" + rbStavke + ", PrijavaID=" + prijava.getPrijavaID() + ", Cena=" + cena + " ,KursID=" + kurs.getKursID();
    }

    @Override
    public String vratiWhereUslov() {
        return " RBStavke=" + rbStavke + " and PrijavaID=" + prijava.getPrijavaID();
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return " * ";
    }

    @Override
    public String vratiAlijas() {
        return " sp ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join Kurs ku on ku.KursID=sp.KursID";
    }

    @Override
    public String vratiWhereUslovSelect() {
        if(prijava!=null)
            return " where PrijavaID="+prijava.getPrijavaID();
        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> stavke = new ArrayList<>();
        while (rs.next()) {
            Nivo n = Nivo.valueOf(rs.getString("Nivo"));
            Kurs k = new Kurs(rs.getInt("KursID"), rs.getString("Naziv"), n, rs.getDouble("Cena"), rs.getInt("BrojCasova"), new Date(rs.getDate("DatumPocetka").getTime()), new Date(rs.getDate("DatumZavrsetka").getTime()), rs.getInt("MaksimalanBrKlijenata"));
            StavkaPrijave sp = new StavkaPrijave(rs.getInt("RBStavke"), null, rs.getDouble("Cena"), k);
        }
        return stavke;
    }

    @Override
    public String vratiMaxPrimarni() {
        return "";
    }

}
