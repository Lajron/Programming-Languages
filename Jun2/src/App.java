//Ne importujemo algebra.* jer u zadataku kaze "U GLAVNOJ KLASI, VAN PAKETA ALGEBRA"
//import algebra.*;

public class App {
    public static void main(String[] args) throws Exception {
        algebra.Razlomak broj1 = new algebra.Razlomak();
        algebra.Razlomak broj2 = new algebra.Razlomak();

        broj1.ucitajBrojeve("brojilac1.txt", "imenilac1.txt");
        broj2.ucitajBrojeve("brojilac2.txt", "imenilac2.txt");

        if (broj1.compareTo(broj2) == 1)
            broj1.odstampajVrednost();
        else
            broj2.odstampajVrednost();
    }
}
