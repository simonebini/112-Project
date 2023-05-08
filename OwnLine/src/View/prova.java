/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author padureand
 */
public class prova {
    
    private String e, ind, nc, s, q;
    
    public prova(String email, String indirizzo, String ncivico, String spesa, String quantita)
    {
        this.e = email;
        this.ind = indirizzo;
        this.nc = ncivico;
        this.s = spesa;
        this.q = quantita;
    }
    
    



    public String getE() {
        return e;
    }

    public String getInd() {
        return ind;
    }

    public String getNc() {
        return nc;
    }

    public String getS() {
        return s;
    }

    public String getQ() {
        return q;
    }
    
    
}
