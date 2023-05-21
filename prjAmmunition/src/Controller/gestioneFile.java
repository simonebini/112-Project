
package Controller;

import View.prodottiDisponibili;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class gestioneFile {
    
    private String filePath;
    ArrayList<prodottiDisponibili> ADisponibili = new ArrayList<>();
    
    private String messaggio = "";
    private String nome = "prodottiDisponibili.csv"; 
    
    //visualizzazione prodotti attraverso il file
    public void visualizzaProdotti() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("prodottiDisponibili.csv"));
        String line;
        String[] etichette = br.readLine().split(" , ");
        System.out.println("\ncodiceProdotto , nomeProdotto , costo , quantita");
        
        while((line = br.readLine()) != null){
            messaggio += line + "\n";
            System.out.println(line);
        }
        System.out.println("\n");
    }
    
    //metodo che ci permette di visualizzare
    public String getMessaggio()
    {
        return this.messaggio;
        
    }
    
    //aggiorna l'arraylist con i dati contenuti nel file
    public void aggiornamentoProdottiArray() throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("prodottiDisponibili.csv"));
        String line;
        String[] etichette = br.readLine().split(" , ");
        ADisponibili.clear();
        
        while((line = br.readLine()) != null){
            //System.out.println(line);
            String[] info = line.split(" , ");
            prodottiDisponibili p = new prodottiDisponibili(info[0], info[1], info[2], info[3]);
            ADisponibili.add(p);
        }
    }

    //ci permette di visualizzare il vettore contenente tutti i prodotti disponibili che possono esser acquistati
    public void getADisponibili() throws IOException {
        aggiornamentoProdottiArray();
        System.out.println("\ncodiceProdotto , nomeProdotto , costo , quantita");
        for(int i=0; i<(ADisponibili.size()); i++)
        {
            System.out.println(ADisponibili.get(i).toString());
        }
        System.out.println("");
    }
    
    
    //ci permette di controllare se il codice inserito coincide con uno presente nella lista prodotti disponibili
    public boolean controlloCodice(int cod) throws IOException
    {
        aggiornamentoProdottiArray();
        for(int i=0; i<(ADisponibili.size()); i++)
        {
            if(ADisponibili.get(i).getNcodice()==cod) return true;
        }
        return false;
    }
    
    //ci permette di controllare la quantita inserita durante il nostro acquisto
    public boolean controlloQuantita(int cod, int quant) throws IOException
    {
        aggiornamentoProdottiArray();
        for(int i=0; i<(ADisponibili.size()); i++)
        {
            if(ADisponibili.get(i).getNcodice()==cod)
            {
                if(quant<=ADisponibili.get(i).getQuantita())
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    //ci permette di trovare il prezzo di un prodotto (utilizzata per calcolare la spesa totale)
    public double trovaPrezzo(int cod) throws IOException
    {
        aggiornamentoProdottiArray();
        for(int i=0; i<(ADisponibili.size()); i++)
        {
            if(ADisponibili.get(i).getNcodice()==cod)
            {
                return ADisponibili.get(i).getCosto();
            }
        }
        return 0;
    }
    
    //aggioramento del file e dell'array dopo aver eseguito l'acquisto
    public void aggioramentoDatiFileArray(int cod, int quant) throws IOException
    {
        //aggiornamento array con i nuovi cambiamenti
        aggiornamentoProdottiArray();
        for(int i=0; i<(ADisponibili.size()); i++)
        {
            if(ADisponibili.get(i).getNcodice()==cod)
            {
                int supporto = ADisponibili.get(i).getQuantita();
                ADisponibili.get(i).setQuantita(supporto-quant);
            }
        } 
        
        //aggiornamento file con i nuovi dati
        BufferedWriter br = new BufferedWriter(new FileWriter("prodottiDisponibili.csv"));
        br.write("codice , nome , costo , quantita");
        
        for(int i=0; i<(ADisponibili.size()); i++)
        {
            br.newLine();
            br.write(ADisponibili.get(i).toString());
        }        
        br.close();
    }
}
