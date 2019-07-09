/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.PrijavaZaKurs;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelTabelePrijave extends AbstractTableModel{
    
    ArrayList<PrijavaZaKurs> lista=null;
    String[] kolone ={"RB","Klijent", "Ukupan iznos", "Uneo korisnik"};

    public ModelTabelePrijave(ArrayList<PrijavaZaKurs> lista) {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        PrijavaZaKurs p = lista.get(rowIndex);
        switch(columnIndex) {
        
            case 0: return ++rowIndex;
            case 1: return p.getKlijent();
            case 2: return p.getUkupanIznos();
            case 3: return p.getKorisnik().getUsername();
            default : return "";
        
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<PrijavaZaKurs> getLista() {
        return lista;
    }
     
    
    
    
}
