/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekcije;

import domen.Korisnik;
import java.util.ArrayList;

/**
 *
 * @author Milica
 */
public class UlogovaniKorisnici {
    
    private static UlogovaniKorisnici instanca;
    private ArrayList<Korisnik> ulogovani;

    public UlogovaniKorisnici() {
        ulogovani=new ArrayList<>();
    }

    public static UlogovaniKorisnici getInstanca() {
        if(instanca==null)
            instanca= new UlogovaniKorisnici();
        return instanca;
    }
    
    public void dodajKorisnika(Korisnik k){
    
        ulogovani.add(k);
    }
    
    public void obrisiKorisnika(Korisnik k) {
    
    
        ulogovani.remove(k);
        
    }

    public ArrayList<Korisnik> getUlogovani() {
        return ulogovani;
    }
    
    
}
