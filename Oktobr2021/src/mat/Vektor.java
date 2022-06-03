package mat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Vektor implements Comparable<Vektor> {
    //protected double proizvod; //moze ovako, a mozemo i direktno preko funkcije izracunajProizvod() da radim sve.
    protected float[] niz; // pravimo promenljivu koja je tipa float[], a velicinu float[] ce da odredimo i postavimo u ucitavanjeVektor metodi.


    //Ucitavanje vektora tj. niza
    public void ucitavanjeVektora(String ime_putanja) {
        try {
            //Brojevi u fajlu su u jednom redu i samo ima razmak izmedju njih npr 6 4 10 2 1 8 2
            String ucitaniText;

            BufferedReader br = new BufferedReader(new FileReader(ime_putanja));
            ucitaniText = br.readLine();
            br.close();

            String[] ucitaniTextSplitovan = ucitaniText.split(" ");

            //Prvi element je duzina niza
            int nizVelicina = Integer.valueOf(ucitaniTextSplitovan[0]);
            niz = new float[nizVelicina];
            
            //Popunjavamo niz od ucitaniTextSplitovan[1] do ucitaniTextSplitovan.length
            for (int i = 1; i < ucitaniTextSplitovan.length; i++)      
                niz[i-1] = Integer.valueOf(ucitaniTextSplitovan[i]);

            //Provera  da li su svi elementi vektora jednaki 0
            boolean jesuJednakiNuli = true;
            for (float broj : niz)
                if (broj != 0)
                    jesuJednakiNuli = false;
            if(jesuJednakiNuli == true)
                throw new NultiVektor("Svi elementi su jednaki nuli");
        } catch(NultiVektor error) {
            System.out.println(error);
        
        } catch (IOException error) {
            System.out.println(error);
        }        
    }

    public abstract double izracunajProizvod();

    public int compareTo(Vektor obj) {
        if( this.izracunajProizvod() == obj.izracunajProizvod())  
            return 0;  
        else if( this.izracunajProizvod() > obj.izracunajProizvod())  
            return 1;  
        else  
            return -1;  
    }

    public void ispisiElemente() {
        for (float broj : niz) {
            System.out.print( broj + " ");                
        }
    }
    
}
