
package Controller;

import java.io.IOException;
import java.util.ArrayList;
import model.acquistoProdotto;

public class gestoreAcquisti {
    
    ArrayList<acquistoProdotto> vettore = new ArrayList<>();
    
    public void aggiungiAcquisto() throws IOException
    {
        acquistoProdotto p = new acquistoProdotto();
        p.acquisto();
        System.out.println(p);
        vettore.add(p);
    }
    
    
}
