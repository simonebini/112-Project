
package Controller;

import View.prodottiDisponibili;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class gestioneFile {
    
    private String filePath;
    ArrayList<prodottiDisponibili> ADisponibili = new ArrayList<>();
    

    private String nome = "prodottiDisponibili.csv"; 
    
    //visualizzazione prodotti attraverso il file
    public void visualizzaProdotti() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("prodottiDisponibili.csv"));
        String line;
        String[] etichette = br.readLine().split(" , ");
        System.out.println("\ncodiceProdotto | nomeProdotto | costo | quantita");
        
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        System.out.println("\n");
    }
    
    //aggiorna l'arraylist con i dati contenuti nel file
    public void aggiornamentoProdottiArray() throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("prodottiDisponibili.csv"));
        String line;
        String[] etichette = br.readLine().split(" , ");
        
        while((line = br.readLine()) != null){
            //System.out.println(line);
            String[] info = line.split(" , ");
            prodottiDisponibili p = new prodottiDisponibili(info[0], info[1], info[2], info[3]);
            ADisponibili.add(p);
        }
    }
    
    public void aggiornamentoProdottiFile()
    {
        
    }

    //ci permette di visualizzare il vettore contenente tutti i prodotti disponibili che possono esser acquistati
    public void getADisponibili() throws IOException {
        aggiornamentoProdottiArray();
        System.out.println("\ncodiceProdotto | nomeProdotto | costo | quantita");
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
    
    public void aggioramentoDatiFileArray(int cod, int quant) throws IOException
    {
        aggiornamentoProdottiArray();
        for(int i=0; i<(ADisponibili.size()); i++)
        {
            if(ADisponibili.get(i).getNcodice()==cod)
            {
                int supporto = ADisponibili.get(i).getQuantita();
                ADisponibili.get(i).setQuantita(supporto-quant);
            }
        }
        
        BufferedWriter br = new BufferedWriter(new FileWriter("provaPratica.csv"));
        
        br.write("codice , nome , costo , quantita");
        br.close();
      
    }
}
