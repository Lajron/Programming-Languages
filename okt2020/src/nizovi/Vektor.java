package nizovi;

public class Vektor {
    private Object niz[];
    private int n;

    public Vektor(int n) {
        this.n = n;
        niz = new Object[this.n];
    }

    public void add(Object obj, int n) {
        niz[n] = obj;
    }

    public void print() {
        for(int i = 0; i < n; i++)
            System.out.println(niz[i].toString());
    }
    
}
