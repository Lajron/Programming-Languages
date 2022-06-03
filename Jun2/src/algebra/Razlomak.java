package algebra;

public class Razlomak extends Broj {
    int brojilac;
    int imenilac;
    
    public Razlomak() {

    }

    public void ucitajBrojeve(String TekstFajlBrojilac, String TekstFajlImenilac) {
        this.brojilac = UcitajBrojIzTekstFajla(TekstFajlBrojilac);
        this.imenilac = UcitajBrojIzTekstFajla(TekstFajlImenilac);
        odrediVrednostBroja();
        /*
        Ovo smo mogli u konstruktor da uradim npr
        public Razlomak(String TekstFajlBrojilac, String TekstFajlImenilac) {
            this.brojilac = UcitajBrojIzTekstFajla(TekstFajlBrojilac);
            this.imenilac = UcitajBrojIzTekstFajla(TekstFajlBrojilac);
            odrediVrednostBroja();
        }
        */
    }

    public void odrediVrednostBroja() {
        if (this.brojilac == 0 || this.imenilac == 0)
            this.vrednost = 0.0;
        else
            this.vrednost = (float) this.brojilac / this.imenilac;
    }
}
