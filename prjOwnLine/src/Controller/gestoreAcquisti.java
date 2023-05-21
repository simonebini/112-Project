package Controller;

import View.prodottiDisponibili;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.acquistoProdotto;

public class gestoreAcquisti {
    
    gestioneFile g1 = new gestioneFile();
    ArrayList<acquistoProdotto> vettore = new ArrayList<>();
    
    //metodo per il controllo è le chiamate per i vari controlli sui dati inseriti
    public void aggiungiAcquisto() throws IOException {
        //creazione oggetto per chiamare i vari controlli e inserimenti
        acquistoProdotto p = new acquistoProdotto();
        
        p.inserisciEmail();
        p.inserisciIndirizzo();
        p.inserisciMetodoPagamento();
        p.selezionaProdotto();
        p.inserisciQuantita();
        p.calcolaSpesa();
        p.aggiornamentoDati();
        
        System.out.println("Grazie per l'acquisto! Ecco il reso conto:");
        System.out.println(p);
        System.out.println("");
        
        //aggiungo il tutto al vettore
        aggioramentoAcqFile(p);
    }
    
    //aggiunta del nuovo acquisto al file
    public void aggioramentoAcqFile(acquistoProdotto p) throws IOException
    {
        aggiornamentoAcqArray();
        vettore.add(p);
        BufferedWriter br = new BufferedWriter(new FileWriter("prodottiAcquistati.csv"));
        br.write("email , indirizzo , codCarta , codiceProdotto , quantita , spesa");  
        
        for(int i=0; i<(vettore.size()); i++)
        {
            br.newLine();
            br.write(vettore.get(i).toString());
        }        
        br.close();  
    }
    
    //aggiornamento dell'array  con i prodotti presenti sul file
    public void aggiornamentoAcqArray() throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("prodottiAcquistati.csv"));
        String line;
        String[] etichette = br.readLine().split(" , ");
        vettore.clear();
        
        while((line = br.readLine()) != null){
            String[] info = line.split(" , ");
            acquistoProdotto p = new acquistoProdotto(info[0], info[1], info[2], info[3], info[4], info[5]);
            vettore.add(p);
        }
    }
    
    //visualizzazione prodotti attraverso il file
    public void visualizzaProdottiFile() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("prodottiAcquistati.csv"));
        String line;
        String[] etichette = br.readLine().split(" , ");
        System.out.println("email , indirizzo , codCarta , codiceProdotto , quantita , spesa");
        
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        System.out.println("\n");
    }
    
    //ci permette di visualizzare il vettore contenente tutti i prodotti acquistati
    public void getAcquisti() throws IOException {
        aggiornamentoAcqArray();
        System.out.println("email , indirizzo , codCarta , codiceProdotto , quantita , spesa");
        for(int i=0; i<(vettore.size()); i++)
        {
            System.out.println(vettore.get(i).toString());
        }
        System.out.println("");
    }
    
    
    
}
