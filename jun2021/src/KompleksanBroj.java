public class KompleksanBroj extends Broj {
    private int a;
    private int b;

    public KompleksanBroj(int a, int b) {
        this.a = a;
        this.b = b;
        odrediVrednostBroja();
    }

    //Moglo je i samo da se A i B stave public, al ajde u zadataku pisalo privatni atributi :D 
    public int getRealniDeo() { return a; }
    public int getImaginarniDeo() { return b; }

    public String prikaziNaStandardniIzlaz() {
        String broj = a + "+j " + b;
        System.out.println(broj);
        return broj;
    }
    //Kompleksi broj sa kojim god da se sabere ce uvek da bude kompleksan.
    public Broj saberiSaDrugimBrojem(Broj drugiBroj) {
        if (drugiBroj instanceof RacionalanBroj) {
            int pomA = this.a + (int)((RacionalanBroj)drugiBroj).vrednost; // moze i ova varijanta (int)drugiBroj.vrednost, jer majka klasa sadrzi double vrednost
            return new KompleksanBroj(pomA, this.b);
        } 
        else if (drugiBroj instanceof KompleksanBroj) {
            int pomA = this.a + ((KompleksanBroj)drugiBroj).getRealniDeo();
            int pomB = this.b + ((KompleksanBroj)drugiBroj).getImaginarniDeo();     
            return new KompleksanBroj(pomA, pomB);
        } 
        else {
            return null;
        }
    }

    public double deliSaCelimBrojem(int broj) {
        return this.vrednost / broj;
    }

    protected void odrediVrednostBroja() {
        this.vrednost = Math.sqrt((a * a) + (this.b * this.b)); // Moze i sa THIS i BEZ NJEGA, isto dodje u ovom slucaju
    }
    
}
