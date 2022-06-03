public class App {
    public static void main(String[] args) throws Exception {
        mat.RealVekt rv1 = new mat.RealVekt();
        mat.RealVekt rv2 = new mat.RealVekt();
        mat.RealVekt rv3 = new mat.RealVekt();

        rv1.ucitavanjeVektora("prviVektor.txt");
        rv1.ispisiElemente();
        System.out.println("\n---------");
        rv2.ucitavanjeVektora("drugiVektor.txt");
        rv2.ispisiElemente();
        System.out.println("\n---------");
        rv3.ucitavanjeVektora("nultiVektor.txt");
        rv3.ispisiElemente();
        System.out.println("\n---------");

        if (rv1.izracunajSumu() > rv2.izracunajSumu())
            rv1.ispisiElemente();
        else 
            rv2.ispisiElemente();

        rv1.upisiSumuUBinarni("binarni.bin");



    }
}
