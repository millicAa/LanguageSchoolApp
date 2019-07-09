/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Klijent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelPrikazKlijenata extends AbstractTableModel{
    
    ArrayList<Klijent> lista= null;
    String[] kolone = {"RB", "Ime", "Prezime", "Datum rodjenja", "Mesto"};

    public ModelPrikazKlijenata(ArrayList<Klijent> lista) {
        this.lista=lista;
    }

    @Override
    public int getRowCount() {
        
        return lista.size();
        
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Klijent k = lista.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch(i1) {
            case 0: return ++i;
            case 1: return k.getIme();
            case 2: return k.getPrezime();
            case 3: return sdf.format(k.getDatumRodjenja());
            case 4: return k.getMesto().getNaziv();
            default: return "";
        
        }

    }

    @Override
    public String getColumnName(int i) {
        return kolone[i]; 
        
        
    }

    public ArrayList<Klijent> getLista() {
        return lista;
    }
    
 
    
}
