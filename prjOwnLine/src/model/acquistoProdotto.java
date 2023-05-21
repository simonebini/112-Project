package model;

import Controller.gestioneFile;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class acquistoProdotto {
    
    private String e, i, m;
    private int n, q;
    private double spesa;
    private boolean controllo = false;
   
    gestioneFile g1 = new gestioneFile();
    Scanner sc = new Scanner(System.in);
    
    public acquistoProdotto()
    {  
    }
    
    public acquistoProdotto(String email, String indirizzo, String mPagamento, String codProdotto, String quantita, String spesa)
    {
        this.e = email;
        this.i = indirizzo;
        this.m = mPagamento;
        this.n = parseInt(codProdotto);
        this.q = parseInt(quantita);
        this.spesa = parseDouble(spesa);
    }
    
    @Override
    public String toString() {
        return e + " , " + i + " , " + m + " , " + n + " , " + q + " , " + spesa;
    }
    
    //----------------------------------------------------------------------------------
    //inserimento email
    public void inserisciEmail() {
        System.out.print("Inserisci la tua email: ");
        String email = sc.nextLine();
        while (!isValidEmail(email)) {
            System.out.print("!ERRORE! Inserisci una mail valida: ");
            email = sc.nextLine();
        }
        this.e = email;
    }

    //controllo email se è valida 
    private boolean isValidEmail(String email) {
        String check = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(check); //passiamo come parametro la mail per effettuare la corrispondenza
        Matcher matcher = pattern.matcher(email); //controlliamo che la mail abbia questa corrispondenza
        return matcher.matches(); //restituisce true se va bene oppure false se non va bene
    }

    //inserimento indirizzo
    public void inserisciIndirizzo() {
        System.out.print("Inserisci il tuo indirizzo: ");
        String indirizzo = sc.nextLine();
        while(indirizzo.isEmpty()) {
            System.out.print("!ERRORE! Inserisci un indirizzo valido: ");
            indirizzo = sc.nextLine();
        }
        this.i = indirizzo;
    }
    
    //inserimento codice di pagamento
    public void inserisciMetodoPagamento() {
        System.out.print("Inserisci il numero della carta di credito: ");
        String mPagamento = sc.nextLine();
        while (!isValidCreditCardNumber(mPagamento)) {
            System.out.print("!ERRORE! Inserisci un numero di carta di credito valido: ");
            mPagamento = sc.nextLine();
        }
        this.m = mPagamento;

        //inserimento del CVV
        System.out.print("Inserisci il CVV: ");
        String cvv = sc.nextLine();
        while (!isValidCVV(cvv)) {
            System.out.print("!ERRORE! Inserisci un CVV valido (3 cifre): ");
            cvv = sc.nextLine();
        }

        //inserimento del MM/YY
        System.out.print("Inserisci la data di scadenza (MM/YY): ");
        String dataScadenza = sc.nextLine();
        while (!isValidExpirationDate(dataScadenza)) {
            System.out.print("!ERRORE! Inserisci una data di scadenza valida (formato MM/YY): ");
            dataScadenza = sc.nextLine();
        }
    }

    //-------------------------------------------------------------------------------------------------------
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
    
    //selezionamento del prodotto dopo aver visualizzato i prodotti disponibili
    public void selezionaProdotto() throws IOException {
        g1.getADisponibili(); // visualizzazione prodotti disponibili per poi sceglierlo

        // Controllo se il codice inserito coincide con uno presente
        int varControllo = 0;
        controllo = false;

        System.out.print("Inserisci il codice del prodotto: ");
        while (!controllo) {
            if (sc.hasNextInt()) { // Controlla se l'input è un intero
                varControllo = sc.nextInt();
                controllo = g1.controlloCodice(varControllo);

                if (!controllo) {
                    System.out.print("!ERRORE! Inserisci un codice valido: ");
                }
            } else {
                System.out.print("!ERRORE! Inserisci un codice valido: ");
                varControllo = sc.nextInt();
            }   
        }
        this.n = varControllo;
    }

    //inserisci la quantita desiderata
    public void inserisciQuantita() throws IOException {
        // Inseriamo la quantita
        controllo = false;
        System.out.print("Inserisci la quantita: ");
        int varControllo = sc.nextInt();

        while (!controllo) {
            if (varControllo <= 0) {
                System.out.print("!ERRORE! Inserisci una quantita valida: ");
                varControllo = sc.nextInt();
            } else if (!g1.controlloQuantita(this.n, varControllo)) {
                System.out.print("!ERRORE! Quantita non disponibile: ");
                varControllo = sc.nextInt();
            } else {
                this.q = varControllo;
                controllo = true;
            }
        }
    }
    
    //calcolo della spesa che abbiamo sostenuto
    public void calcolaSpesa() throws IOException {
        // Calcolo spesa
        this.spesa = q * g1.trovaPrezzo(this.n);
        System.out.println("");
    }
    
    //aggiorniamo i dati presenti nell'array e nel file dei prodotti disponibili
    public void aggiornamentoDati() throws IOException {
        // Funzione che aggiorna i dati dell'arraylist e del file dei prodotti disponibili
        g1.aggioramentoDatiFileArray(this.n, this.q);
    }

    public String getEmail() {
        return e;
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
