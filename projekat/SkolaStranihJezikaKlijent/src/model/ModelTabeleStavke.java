/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.StavkaPrijave;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelTabeleStavke extends AbstractTableModel{
    
    ArrayList<StavkaPrijave> lista;
    String[] kolone ={"RB", "Kurs","Broj casova", "Cena"};

    public ModelTabeleStavke() {
        lista=new ArrayList<>();
    }

    public ModelTabeleStavke(ArrayList<StavkaPrijave> stavke) {
        lista=stavke;
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

        StavkaPrijave s = lista.get(rowIndex);
        switch(columnIndex) {
            case 0: return ++rowIndex;
            case 1: return s.getKurs();
            case 2: return s.getKurs().getBrojCasova();
            case 3: return s.getKurs().getCena();
            
            default: return "";
        
        }


    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaPrijave sp = lista.get(rowIndex);
        switch(columnIndex) {
            case 0 :
                sp.setRbStavke(++rowIndex);
        
        }
    }
    
    

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<StavkaPrijave> getLista() {
        return lista;
    }
    
    public void dodaj(StavkaPrijave s) {
    
        lista.add(s);
        fireTableDataChanged();
    }
    
    public void obrisi(int row){
    
        lista.remove(row);
        fireTableDataChanged();
    
    }

    public void setLista(ArrayList<StavkaPrijave> lista) {
        this.lista = lista;
    }

    
    
    
    
}
