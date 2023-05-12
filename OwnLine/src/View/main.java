
package View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String intestazione = "\ncodiceProdotto | nomeProdotto | costo | quantita";
        
        //prendiamo il file che contiene i dati di ogni acquirente presso amazon
        BufferedReader br = new BufferedReader(new FileReader("prodottiDisponibili.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("prodotti.csv"));
        //ArrayList<prodottiDisponibili> arrayProdotti = new ArrayList<>();
        //ArrayList<prova> listaClienti = new ArrayList<>();
        
        gestioneFile g1 = new gestioneFile();
        Scanner sc = new Scanner(System.in);
        
        //--------------------------------------------------------------------------------
      
        
        //aggiorno l'array contenente tutti i prodotti disponibili
        

        while(true)
        {
            System.out.println("A - acquista un nuovo prodotto");
            System.out.println("V - visualizza i prodotti che hai acquistato");
            System.out.println("P - visualizza i prodotti che puoi acquistare");
            System.out.println(" ");
            System.out.print("Inserisci la tua scelta: ");
            String choose = sc.nextLine(); 
            System.out.println(" ");
            
            switch(choose)
            {
                case "A":
                {
                    //inserimento dati riguardanti il nuovo acquisto e al suo acquirente
                    System.out.print("Inserisci la tua email: ");
                    String email = sc.nextLine();
                    System.out.print("Inserisci il tuo indirizzo: ");
                    String indirizzo = sc.nextLine();
                    
                    g1.visualizzaProdotti();
                    
                    
                    
                    System.out.print("Inserisci il codice del prodotto: ");
                    String ncodice = sc.nextLine(); 
                    System.out.print("Inserisci la quantita: ");
                    int quantita = sc.nextInt();
                    System.out.print("Inserisci il metodo di pagamento: ");
                    String metodoPagamento = sc.nextLine();
                    
                    //calcolo di quanto spende pero fatto dal programma in futuro
                    
                }
                case "B":
                {
                    
                    //g1.visualizzaProdotti();
                    g1.aggiornamentoArrayProdotti();
                    g1.getADisponibili();
                }
            }
            
        }
        
       
        
        
       
        
        
    }
}
        


    

