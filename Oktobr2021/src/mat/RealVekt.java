package mat;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RealVekt extends Vektor {
    public RealVekt() {
        /*
        Prazno ili moze odma da ucitamo sve brojeve preko konstruktora:

        public RealVekt(String nazivFajla) {
            ucitavanjeVektora(nazivFajla);
        }   

        */
    }

    public double izracunajProizvod() {
        double proizvod = 1;
        for (float broj : niz)
            proizvod = proizvod * broj;
        return proizvod;
    }

    public float izracunajSumu() {
        float suma = 0;
        for (float broj : niz)
            suma = suma + broj;
        return suma;
    }

    public void upisiSumuUBinarni(String nazivBinarnogFajla) {
        try {
            float suma = izracunajSumu();
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nazivBinarnogFajla)));
            dos.writeFloat(suma);
            dos.close();
        } catch (IOException error) {
            System.out.println(error);
        }
    }
    
}
