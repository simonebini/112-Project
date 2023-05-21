package Controller;

import View.prodottiDisponibili;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import model.acquistoProdotto;

public class gestoreAcquisti {
    
    private String messaggio = "";
    gestioneFile g1 = new gestioneFile();
    ArrayList<acquistoProdotto> vettore = new ArrayList<>();
       

    public boolean aggiungiAcquisto(String indirizzo, String mCodCarta, String cvv, String data, String nCodice, String quantita ) throws IOException
    {
        acquistoProdotto p = new acquistoProdotto();
        if(!p.controlloIndirizzo(indirizzo)) return false;
        
        if(!p.inserisciMetodoPagamento(mCodCarta, cvv, data)) return false;
        
        int supp1 = parseInt(nCodice);
        if(!p.controlloProdotto(supp1)) return false;
        
        int supp2 = parseInt(quantita);
        if(!p.controlloQuantitaInserita(supp2)) return false;
        
        p.calcolaSpesa();
        g1.aggioramentoDatiFileArray(supp1, supp2);
        
        aggioramentoAcqFile(p);
        return true;
    }
    
    //aggiunta del nuovo acquisto al file
    public void aggioramentoAcqFile(acquistoProdotto p) throws IOException
    {
        aggiornamentoAcqArray();
        vettore.add(p);
        BufferedWriter br = new BufferedWriter(new FileWriter("prodottiAcquistati.csv"));
        br.write("indirizzo , codCarta , codiceProdotto , quantita , spesa");  
        
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
            acquistoProdotto p = new acquistoProdotto(info[0], info[1], info[2], info[3], info[4]);
            vettore.add(p);
        }
    }
    
    //visualizzazione prodotti attraverso il file
    public void visualizzaProdottiFile() throws IOException
    {
        this.messaggio = "Indirizzo              Carta            Codice      Quantità   Spesa\n\n";
        BufferedReader br = new BufferedReader(new FileReader("prodottiAcquistati.csv"));
        String line;
        String[] etichette = br.readLine().split(" , ");
        System.out.println("indirizzo , codCarta , codiceProdotto , quantita , spesa");
        
        while((line = br.readLine()) != null){
            System.out.println(line);
            messaggio += line + "\n";
        }
        System.out.println("\n");
    }
    
    //ci permette di visualizzare il vettore contenente tutti i prodotti acquistati
    public void getAcquisti() throws IOException {
        aggiornamentoAcqArray();
        System.out.println("indirizzo , codCarta , codiceProdotto , quantita , spesa");
        for(int i=0; i<(vettore.size()); i++)
        {
            System.out.println(vettore.get(i).toString());
        }
        System.out.println("");
    }
    
    public String getMessaggio()
    {
        return this.messaggio;
    }
    
    public void svuotaFile() throws IOException
    {
        BufferedWriter br = new BufferedWriter(new FileWriter("prodottiAcquistati.csv"));
        br.write("indirizzo , codCarta , codiceProdotto , quantita , spesa"); 
        br.close();
    }
    
    
    
}
