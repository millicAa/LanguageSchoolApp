/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Klijent;
import domen.Kurs;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelPrikazKurseva extends AbstractTableModel{
    
    ArrayList<Kurs> lista= null;
    String[] kolone = {"Naziv", "Nivo", "Cena", "Broj casova", "datum pocetka", "Datum zavrsetka", "Maksimalan broj  klijenata"};

    public ModelPrikazKurseva(ArrayList<Kurs> lista) {
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
        Kurs k = lista.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch(i1) {
            case 0: return k.getNaziv();
            case 1: return k.getNivo();
            case 2: return k.getCena();
            case 3: return k.getBrojCasova();
            case 4: return sdf.format(k.getDatumPocetka());
            case 5: return sdf.format(k.getDatumZavrsetka());
            case 6: return k.getMaksimalanBrKlijenata();
            default: return "";
        
        }

    }

    @Override
    public String getColumnName(int i) {
        return kolone[i]; 
        
        
    }

    public ArrayList<Kurs> getLista() {
        return lista;
    }
    
 
    
}
