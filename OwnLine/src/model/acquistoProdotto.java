
package model;

import View.gestioneFile;
import java.io.IOException;
import java.util.Scanner;

public class acquistoProdotto {
    
    private String e, i, m;
    private int n, q;
    private boolean controllo = false;
    
    
    gestioneFile g1 = new gestioneFile();
    Scanner sc = new Scanner(System.in);
    
    public void acquisto() throws IOException
    {
        System.out.print("Inserisci la tua email: ");
        String email = sc.nextLine();
        this.e = email;
        
        System.out.print("Inserisci il tuo indirizzo: ");
        String indirizzo = sc.nextLine();
        this.i = indirizzo;
               
        g1.getADisponibili();//visualizzazione prodotti disponibili per poi sceglierlo        
        
        int ncodice = 0;
        controllo = false;
        while(controllo==false)
        {
            System.out.print("Inserisci il codice del prodotto: ");
            ncodice = sc.nextInt();
            controllo = g1.controlloCodice(ncodice);
        }
        this.n = ncodice;
        
        System.out.print("Inserisci la quantita: ");
        int quantita = sc.nextInt();
        this.q = quantita;
        
        System.out.print("Inserisci il metodo di pagamento: ");
        String metodoPagamento = sc.nextLine();
        this.m = metodoPagamento;
    }

    @Override
    public String toString() {
        return "acquistoProdotto{" + "e=" + e + ", i=" + i + ", m=" + m + ", n=" + n + ", q=" + q + '}';
    }

    public String getE() {
        return e;
    }

    public String getI() {
        return i;
    }

    public String getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int getQ() {
        return q;
    }

    public Scanner getSc() {
        return sc;
    }
    
    
    
}
