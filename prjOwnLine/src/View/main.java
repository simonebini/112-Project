
package View;

import Controller.gestioneFile;
import Controller.gestoreAcquisti;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.acquistoProdotto;
public class main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
                
        //prendiamo il file che contiene i dati di ogni acquirente presso amazon
        BufferedReader br = new BufferedReader(new FileReader("prodottiDisponibili.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("prodotti.csv"));
        //ArrayList<prodottiDisponibili> arrayProdotti = new ArrayList<>();
        //ArrayList<prova> listaClienti = new ArrayList<>();
        
        gestoreAcquisti p1 = new gestoreAcquisti();
        gestioneFile g1 = new gestioneFile();
        Scanner sc = new Scanner(System.in);
        
        //--------------------------------------------------------------------------------
      
        
        while(true)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("A - acquista un nuovo prodotto");
            System.out.println("V - visualizza i prodotti che hai acquistato");
            System.out.println("P - visualizza i prodotti che puoi acquistare");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            System.out.print("Inserisci la tua scelta: ");
            String choose = sc.nextLine().toLowerCase();
            System.out.println(" ");
            
                    
            switch(choose)
            {       
                case "a":
                {
                    //inserimento dati riguardanti il nuovo acquisto e al suo acquirente
                    p1.aggiungiAcquisto();
                    
                    break;
                }
                case "v":
                {
                    //metodo per vedere i prodotti acquistati
                    p1.getAcquisti();
                    break;
                }
                case "p":
                {
                    
                    //g1.visualizzaProdotti();
                    //g1.aggiornamentoArrayProdotti();
                    g1.getADisponibili();
                    break;
                }
            }
            
        }
    }
}
        


    

