package model;

import Controller.gestioneFile;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class acquistoProdotto {
    
    private String i, m;
    private int n, q;
    private double spesa;
    private boolean controllo = false;
   
    gestioneFile g1 = new gestioneFile();
    Scanner sc = new Scanner(System.in);
    
    public acquistoProdotto()
    {  
    }
    
    public acquistoProdotto(String indirizzo, String mPagamento, String codProdotto, String quantita, String spesa)
    {
        this.i = indirizzo;
        this.m = mPagamento;
        this.n = parseInt(codProdotto);
        this.q = parseInt(quantita);
        this.spesa = parseDouble(spesa);
    }
    
    @Override
    public String toString() {
        return i + " , " + m + " , " + n + " , " + q + " , " + spesa;
    }

    //----------------------------------------------------------------------------------
    //controllo indirizzo
    public boolean controlloIndirizzo(String indirizzo) {
        if(indirizzo.isEmpty()) {
            return false;
        }
        this.i = indirizzo;
        return true;
    }
    
    //----------------------------------------------------------------------------------
    //controllo metodo di pagamento
    public boolean inserisciMetodoPagamento(String codPagamento, String cvv, String dataScadenza) {
        if(!isValidCreditCardNumber(codPagamento)) {
            return false;
        }

        //inserimento del CVV
        if(!isValidCVV(cvv)) {
            return false;
        }

        //inserimento del MM/YY
        if(!isValidExpirationDate(dataScadenza)) {
            return false;
        }
        
        this.m = codPagamento;
        return true;
    }
    
    //controlli se il codice della carta è giusto
    private boolean isValidCreditCardNumber(String cardNumber) {
        // Controlla se il numero di carta di credito ha esattamente 10 cifre numeriche
        return cardNumber.matches("\\d{10}");
    }
    
    //controllo se il CVV e giusto/valido
    private boolean isValidCVV(String cvv) {
        // Controlla se il CVV ha esattamente 3 cifre numeriche
        return cvv.matches("\\d{3}");
    }

    //controllo se la data non e scaduta
    private boolean isValidExpirationDate(String expirationDate) {
        // Controlla se la data di scadenza è nel formato corretto (MM/YY)
        return expirationDate.matches("^(0[1-9]|1[0-2])/\\d{2}$");
    }
    
    
    //----------------------------------------------------------------------------------
    //controllo codice prodotto
    public boolean controlloProdotto(int varControllo) throws IOException {
        g1.getADisponibili(); // visualizzazione prodotti disponibili per poi sceglierlo
        
        if(g1.controlloCodice(varControllo))
        {
            this.n = varControllo;
            return true;
        }
        return false;
    }
   
    //-------------------------------------------------------------------------------------------------------
    //controllo la quantita
    public boolean controlloQuantitaInserita(int varControllo) throws IOException {

        //controlli se il numero inserito e negativo o maggiore rispetto a quello disponibile
        if (varControllo <= 0) return false;
        if (!g1.controlloQuantita(this.n, varControllo)) return false;
            
        this.q = varControllo;        
        return true;
    }
    
    //-------------------------------------------------------------------------------------------------------
    //calcolo della spesa che abbiamo sostenuto
    public void calcolaSpesa() throws IOException {
        // Calcolo spesa
        this.spesa = q * g1.trovaPrezzo(this.n);
        System.out.println("");
    }
    
    //-------------------------------------------------------------------------------------------------------
    //aggiorniamo i dati presenti nell'array e nel file dei prodotti disponibili
    public void aggiornamentoDati() throws IOException {
        // Funzione che aggiorna i dati dell'arraylist e del file dei prodotti disponibili
        g1.aggioramentoDatiFileArray(this.n, this.q);
    }

    public String getIndirizzo() {
        return i;
    }

    public String getMetodoPagamento() {
        return m;
    }

    public int getCodiceProdotto() {
        return n;
    }

    public int getQuantita() {
        return q;
    }

    public Scanner getScanner() {
        return sc;
    }
    
    public double getSpesaTotale() {
        return spesa;
    }
    
}
