
package model;

import View.gestioneFile;
import java.io.IOException;
import java.util.Scanner;

public class acquistoProdotto {
    
    private String e, i, m;
    private int n, q;
    private double spesa;
    private boolean controllo = false;
    
    
    gestioneFile g1 = new gestioneFile();
    Scanner sc = new Scanner(System.in);
    
    public void acquisto() throws IOException
    {
        //inserimento dell'email
        System.out.print("Inserisci la tua email: ");
        String email = sc.nextLine();
        this.e = email;
        
        //inserimento dell'indirizzo
        System.out.print("Inserisci il tuo indirizzo: ");
        String indirizzo = sc.nextLine();
        this.i = indirizzo;
        
        //inserisci metodo di pagamento
        System.out.print("Inserisci il metodo di pagamento: ");
        String mPagamento = sc.nextLine();
        this.m = mPagamento;
               
        g1.getADisponibili();//visualizzazione prodotti disponibili per poi sceglierlo        
        
        //controllo se il codice inserito coincide con uno presente
        int varControllo = 0;
        controllo = false;
        while(controllo==false)
        {
            System.out.print("Inserisci il codice del prodotto: ");
            varControllo = sc.nextInt();
            controllo = g1.controlloCodice(varControllo);
        }
        this.n = varControllo;
        
        //inseriamo la quantita
        controllo = false;
        while(controllo==false)
        {
            System.out.print("Inserisci la quantita: ");
            varControllo = sc.nextInt();
            controllo = g1.controlloQuantita(this.n, varControllo);
        }
        this.q = varControllo;
        
        //calcolo spesa
        this.spesa = varControllo*g1.trovaPrezzo(this.n);
        System.out.println("");
        
        //funzione che aggiorna i dati dell'arraylist e del file dei prodotti disponibili
        g1.aggioramentoDatiFileArray(this.n, this.q);
        
    }

    @Override
    public String toString() {
        return e + " , " + i + " , " + m + " , " + n + " , " + q + " , " + spesa;
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
    
    public double getSpesa() {
        return spesa;
    }
    
    
    
}
