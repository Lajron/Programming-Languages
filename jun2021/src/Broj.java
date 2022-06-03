public abstract class Broj implements Comparable<Broj> {
    public double vrednost;

    public int compareTo(Broj obj) {
        if( this.vrednost == obj.vrednost)  
            return 0;  
        else if( this.vrednost > obj.vrednost)  
            return 1;  
        else  
            return -1;  
    }
    
    public abstract String prikaziNaStandardniIzlaz();
    public abstract Broj saberiSaDrugimBrojem(Broj drugiBroj);
    public abstract double deliSaCelimBrojem(int broj);
    protected abstract void odrediVrednostBroja();

    //public String toString() { return String.valueOf(this.vrednost); } // u main ne moze da convertuje pa ovo izvodimo,a mozemo da napisemo i funckiju printVrednost();
}
