/*
Sia dato il file di testo allegato contenente dati relativi agli articoli prodotti da una azienda di elettronica

La prima riga del file contiene le seguenti etichette
codiceprodotto,descrizione,prezzo,venduto

Le successive righe riportano, sempre divisi dalla , 
i rispettivi dati di vari prodotti

- Progettare la classe Prodotto affinché possa memorizzare i dati presenti nel file
- Leggere i file di testo e valorizzare una struttura adatta (sugg. ArrayList<Prodotto>) per memorizzare i dati presenti nel file
- Stampare i dati del prodotto più costoso
- Stampare i dati del prodotto meno venduto
- Stampare il totale incassato dall'azienda (sommatoria di prezzo*venduto)
 */
package es02_files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author caprarif
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader("prodotti.csv"));
        String line;
        String[] etichette = br.readLine().split(",");
        ArrayList<Prodotto> ListaSpesa = new ArrayList<>();
        
        while((line = br.readLine()) != null){
            System.out.println(line);
            String[] info = line.split(",");
            Prodotto p = new Prodotto(info[0], info[1], info[2], info[3]);
            ListaSpesa.add(p);
        }
        
        //Stampare i dati del prodotto più costoso
        double cMax = 0;
        Prodotto x = null;
        for(Prodotto p : ListaSpesa){
            if(p.getPrezzo() > cMax){
                cMax = p.getPrezzo();
                x=p;
            }
        }
        System.out.println("Prodotto più costoso: " + x.getnProdotto() + ", "+ x.getNome() + ", "+ x.getPrezzo() + ", "+ x.getnVenduti());
        
        //Stampare i dati del prodotto meno venduto
        int min = 0;
        Prodotto y = null;
        for(Prodotto p : ListaSpesa){
            if(p == ListaSpesa.get(0)) min = p.getnVenduti();
            else if(p.getnVenduti() < min) y=p;
        }
        System.out.println("Prodotto meno venduto: " + y.getnProdotto() + ", "+ y.getNome() + ", "+ y.getPrezzo() + ", "+ y.getnVenduti());
        
        //Stampare il totale incassato dall'azienda
        double totIncassato = 0;
        for(Prodotto p : ListaSpesa){
            totIncassato += (p.getPrezzo() * p.getnVenduti());
        }
        System.out.println("Totale incassato dall'azienda: " + totIncassato);
    } 
}
S