import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Broj> niz = new ArrayList<Broj>();
        for(int i = 0; i < 10; i += 2) {
            niz.add(new KompleksanBroj((int)(Math.random()*101), (int)(Math.random()*101)));
            niz.add(new RacionalanBroj((int)(Math.random()*101), (int)(Math.random()*101)));
        }
        Collections.sort(niz);
        /*
        for(Broj broj : niz) {
            broj.prikaziNaStandardniIzlaz();
            System.out.println(broj.vrednost + "\n ----");
        }
        */
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //ISPISATI SVE SORTIRANE BROJEVE U TXT FILE
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("formatBrojeva.txt"));
            for(Broj broj : niz) {
                bw.write(broj.prikaziNaStandardniIzlaz());
                bw.newLine();
            }
            bw.close();

        } catch (IOException error) {
            System.out.println("Error");
        }
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //ARITMETICKA SREDINA
        //Treba nam SUMA = 0, tako da imamo opciju da krenemo sa Racionalni ili Kompleksnim, svejedno koji ali bolje racinalni.
        Broj suma = new RacionalanBroj(0, 0); //Ovo je pocetna vrednost, ako saberemo sa kompleksi onda ce bude Kompleksni
        Broj suma1 = new KompleksanBroj(0,0); //Ovo je pocetna vrednost, i uvek ce da bude kompleksni po pravilima u "NAPOMENA"

        for (Broj broj : niz) {
            suma = suma.saberiSaDrugimBrojem(broj); // suma i suma1 su isti samo cisto da demonstriram da nebitno dal je KB ili RB na pocetku.
            suma1 = suma1.saberiSaDrugimBrojem(broj);
        }
        System.out.println("----------- \n" + "suma: " + suma.vrednost + "\n" + "suma1: " + suma1.vrednost);

        //ostaje samo da podelimo sumu sa brojem elemenata u nizu i upisemo u binarni file
        try {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("aritmetickaSredina" + ".bin")));
            dos.writeDouble(suma.deliSaCelimBrojem(niz.size()));
            //dos.writeDouble(suma1.vrednost /niz.size()); // druga varijanta
            dos.close();
        } catch (IOException error) {
            System.out.println("Error");
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Da proverimo dal je dobar broj upisan u aritmeticku sredinu        
        try {
            System.out.println("----------- \n" + "[Main] Aritmeticka Sredina: " + suma.vrednost / niz.size());
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("aritmetickaSredina.bin")));
            double AritmetickaSredinaIzBinarnog = dis.readDouble();
            dis.close();
            System.out.println("[Binary] Aritmeticka Sredina: " + AritmetickaSredinaIzBinarnog);
        } catch (IOException error) {
            System.out.println("Error");
        }



    }
}
