
package View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //prendiamo il file che contiene i dati di ogni acquirente presso amazon
        BufferedReader br = new BufferedReader(new FileReader("cliente.csv"));
        String line;
        String[] etichette = br.readLine().split(",");
        ArrayList<prova> listaChiamate = new ArrayList<>();
        
        while((line = br.readLine()) != null){
            //visualizzazione di ogni riga del file csv
            System.out.println(line);
            String[] info = line.split(",");
            prova p1 = new prova(info[0], info[1], info[2], info[3], info[4]);
            listaChiamate.add(p1);
        }
        
        prova p2 = new prova("simoneini@gmail.com", "gualtieri", "12", "657", "10");
        
        FileWriter scrivi = new FileWriter("cliente.csv");
        
        scrivi.write(p2);
        scrivi.close();
        
        //Stampare i dati del prodotto più costoso
        String cMax;
        prova x = null;
        
        }
    /*
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
    */
    }


    

