
package View;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class gestioneFile {
    
    private String filePath;
    ArrayList<prodottiDisponibili> ADisponibili = new ArrayList<>();
    

    private String nome = "prodottiDisponibili.csv"; 
    
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
        aggiornamentoArrayProdotti();
    }
    
    public void aggiornamentoArrayProdotti() throws FileNotFoundException, IOException
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

    public void getADisponibili() {
        for(int i=0; i<(ADisponibili.size()); i++)
        {
            System.out.println(ADisponibili.get(i).toString());
        }
    }


    
    

    
    
    
    
}
