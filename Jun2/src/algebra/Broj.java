package algebra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Broj implements Comparable<Broj> {
    protected double vrednost;

    public int compareTo(Broj obj) {
        if( this.vrednost == obj.vrednost)  
            return 0;  
        else if( this.vrednost > obj.vrednost)  
            return 1;  
        else  
            return -1;  
    }

    public int UcitajBrojIzTekstFajla(String ime_putanja) {
        try {
            int ucitanBroj;

            BufferedReader br = new BufferedReader(new FileReader(ime_putanja));
            ucitanBroj = Integer.valueOf(br.readLine());
            br.close();

            return ucitanBroj;
        } catch (IOException error) {
            System.out.println("Error");
            return 0;
        }
    }

    protected abstract void odrediVrednostBroja();
    
    public void odstampajVrednost() {
        System.out.println(this.vrednost);
    }

}