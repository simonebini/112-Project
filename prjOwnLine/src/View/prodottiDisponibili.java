
package View;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class prodottiDisponibili {
    
    private int ncodice, quantita;
    private String nome;
    private double costo;
    
    
    public prodottiDisponibili(String a, String b, String c, String d)
    {
       this.ncodice = parseInt(a);
       this.nome = b;
       this.costo = parseDouble(c);
       this.quantita = parseInt(d);
    }

    public int getNcodice() {
        return ncodice;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return  ncodice + " , " + nome + " , " + costo + " , " + quantita;
    }
 
}
