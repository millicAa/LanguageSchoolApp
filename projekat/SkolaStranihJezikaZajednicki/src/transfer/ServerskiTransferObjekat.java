/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Milica
 */
public class ServerskiTransferObjekat implements Serializable {

    private String poruka;
    private Object odgovor;
    private boolean uspesno;

    public ServerskiTransferObjekat() {
    }

    public ServerskiTransferObjekat(String poruka, Object odgovor, boolean uspesno) {
        this.poruka = poruka;
        this.odgovor = odgovor;
        this.uspesno = uspesno;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

}
