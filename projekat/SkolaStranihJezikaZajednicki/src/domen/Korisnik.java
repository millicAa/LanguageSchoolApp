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
public class Korisnik implements Serializable, OpstiDomenskiObjekat{
    
    private int korisnikID;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String username, String password) {
        this.korisnikID = korisnikID;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String vratiNazivTabele() {
        return " korisnik ";
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
        return " k ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String vratiWhereUslovSelect() {
       return " where Username='"+username+"' and Password='"+password+"' LIMIT 1";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
         List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            lista.add(new Korisnik(rs.getInt("KorisnikID"),rs.getString("Username"), rs.getString("Password")));
        }
        
        return lista;
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
        final Korisnik other = (Korisnik) obj;
        if (this.korisnikID != other.korisnikID) {
            return false;
        }
        return true;
    }

   
    
    
}
