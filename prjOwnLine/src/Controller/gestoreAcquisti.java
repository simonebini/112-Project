package Controller;

import java.io.IOException;
import java.util.ArrayList;
import model.acquistoProdotto;

public class gestoreAcquisti {
    
    ArrayList<acquistoProdotto> vettore = new ArrayList<>();
    
    public void aggiungiAcquisto() throws IOException {
        acquistoProdotto p = new acquistoProdotto();
        p.inserisciEmail();
        p.inserisciIndirizzo();
        p.inserisciMetodoPagamento();
        p.selezionaProdotto();
        p.inserisciQuantita();
        p.calcolaSpesa();
        p.aggiornaDatiFileArray();
        
        System.out.println("Grazie per l'acquisto! Ecco il reso conto:");
        System.out.println(p);
        System.out.println("");
        
        vettore.add(p);
    }  
}
