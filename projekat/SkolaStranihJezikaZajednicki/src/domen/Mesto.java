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
public class Mesto implements Serializable, OpstiDomenskiObjekat{
    
    private int mestoID;
    private String naziv;
    private int postanskiBroj;

    public Mesto() {
    }

    public Mesto(int mestoID, String naziv, int postanskiBroj) {
        this.mestoID = mestoID;
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
    }

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return " mesto ";
    }

    @Override
    public String vratiNaziveKolona() {
        return "";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiWhereUslov() {
        return "";
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return " * ";
    }

    @Override
    public String vratiAlijas() {
        return "m";
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
         List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            lista.add(new Mesto(rs.getInt("MestoID"),rs.getString("Naziv"), rs.getInt("PostanskiBroj")));
        }
        
        return lista;
    }

    @Override
    public String vratiMaxPrimarni() {
        return "";
    }

    @Override
    public String toString() {
        return naziv;
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
        final Mesto other = (Mesto) obj;
        if (this.mestoID != other.mestoID) {
            return false;
        }
        return true;
    }

   
    
    

    
    
    
}
