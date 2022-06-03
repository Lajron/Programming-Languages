public class RacionalanBroj extends Broj {
    private int a;
    private int b;

    public RacionalanBroj(int a, int b) {
        this.a = a;
        this.b = b;
        odrediVrednostBroja();
    }

    //Trebace nam neka metoda koja ce da vrati STRING kad ispisujemo u .txt file
    //Ova metoda ce da vrati taj string i ispisace nam na standardni ulaz
    //Da ne pravimo 2 razlicite metode pa sve stavljamo u jednu, da ne pravimo getStringFormatBroja() i ona da nam vrati kako izgleda.
    public String prikaziNaStandardniIzlaz() {
        String broj = a + "/" + b;
        System.out.println(broj);
        return broj;
    }
    //Racionalni broj u zavinosti dal se sabere sa Racionalnim ili Kompleksnim moze da vrati ili Racionalan ili Kompleksan broj.
    public Broj saberiSaDrugimBrojem(Broj drugiBroj) {
        if (drugiBroj instanceof RacionalanBroj) {
            RacionalanBroj pom = new RacionalanBroj(0, 0); // pomocna - nebitni su nam ovde parametri jer cemo direktno .vrednost da promenimo/upisemo
            pom.vrednost = this.vrednost + ((RacionalanBroj)drugiBroj).vrednost;
            return pom; //vrati racionalanbroj
        } 
        else if (drugiBroj instanceof KompleksanBroj) {
            int pomA = (int)this.vrednost + ((KompleksanBroj)drugiBroj).getRealniDeo();
            int pomB = ((KompleksanBroj)drugiBroj).getImaginarniDeo(); // mogli smo direktno ovaj desni deo da stavimo u konsturktor al lepse ovako        
            KompleksanBroj pom = new KompleksanBroj(pomA, pomB);
            return pom; // moglo je i direktno -> return new KompleksanBroj(pomA, pomB);
        } 
        else {
            return null; //ovo za svaki slucaj ako se unese nesto drugo, ali moglo i bez toga
        }
    }

    public double deliSaCelimBrojem(int broj) {
        return this.vrednost / broj;
    }

    protected void odrediVrednostBroja() {
        //Javlja se problem kad su A i B jednaki 0 i treba da izvrsi operaciju 0/0 tako da to resavam sa ovaj IF, inace dobija se "NaN" umesto 0.0
        if (this.a == 0 && this.b == 0)
            this.vrednost = 0.0;
        else
            this.vrednost = (float)a/b;
    }
    
}
